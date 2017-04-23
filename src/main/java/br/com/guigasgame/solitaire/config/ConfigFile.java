package br.com.guigasgame.solitaire.config;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

public class ConfigFile
{
	private static final String FILE_NAME = "aux/config.properties";

	private Properties properties;

	private static ConfigFile instance;
	
	private ConfigFile()
	{
		createFolder();
		properties = new Properties();
		loadFile();
	}
	
	public static ConfigFile getInstance()
	{
		if (null == instance)
			instance = new ConfigFile();
		return instance;
	}
	
	private void loadFile()
	{
		FileInputStream input = null;
		try
		{
			input = new FileInputStream(FILE_NAME);
			properties.load(input);
			
			properties.get("animationEnabled");
			properties.get("soundEnabled");
			properties.get("playerName");
			properties.get("cardCover");
		}
		catch (FileNotFoundException e)
		{
			properties.setProperty("animationEnabled", "true");
			properties.setProperty("soundEnabled", "true");
			properties.setProperty("playerName", System.getProperty("user.name"));
			properties.setProperty("cardCover", "0");

			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		finally 
		{
			if (input != null) 
			{
				try 
				{
					input.close();
				} 
				catch (IOException e) 
				{
					e.printStackTrace();
				}
			}
		}
	}
	
	private void createFolder()
	{
		File theDir = new File("aux");

		// if the directory does not exist, create it
		if (!theDir.exists())
		{
			System.out.println("creating directory: " + theDir.getName());
			boolean result = false;

			try
			{
				theDir.mkdir();
				result = true;
			}
			catch (SecurityException se)
			{
				// handle it
			}
			if (result)
			{
				System.out.println("DIR created");
			}
		}	
	}

	public void setValue(String key, String value)
	{
		properties.setProperty(key, value);
		saveFile();
	}
	
	public String getValue(String key)
	{
		return properties.getProperty(key);
	}
	
	private void saveFile()
	{

		OutputStream output = null;
		try 
		{
			output = new FileOutputStream(FILE_NAME);
			properties.store(output, null);
		}
		catch (IOException io)
		{
			io.printStackTrace();
		}
		finally
		{
			if (output != null)
			{
				try
				{
					output.close();
				}
				catch (IOException e)
				{
					e.printStackTrace();
				}
			}
		}
	}
	
	public static void main(String[] args)
	{
		ConfigFile instance2 = ConfigFile.getInstance();
		instance2.loadFile();
		System.out.println(instance2.getValue("playerName"));
	}
	
}
