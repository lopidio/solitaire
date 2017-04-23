package br.com.guigasgame.solitaire.resourcemanager;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import org.jsfml.graphics.Font;

public class FontResourceManager extends ResourceManager<String, Font>
{

	private static FontResourceManager singleton;

	static
	{
		singleton = new FontResourceManager();
	}

	private FontResourceManager()
	{
		super(new HashMap<String, Font>());
	}

	@Override
	protected Font loadResource(String key) throws IOException
	{
		Font font = new Font();
		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource(key).getFile());
		font.loadFromFile(file.toPath());
		return font;
	}

	public static FontResourceManager getInstance()
	{
		return singleton;
	}

}
