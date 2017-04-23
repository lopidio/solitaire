package br.com.guigasgame.solitaire.resourcemanager;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import org.jsfml.graphics.Texture;

public class TextureResourceManager extends ResourceManager<String, Texture>
{

	private static TextureResourceManager singleton;

	static
	{
		singleton = new TextureResourceManager();
	}

	private TextureResourceManager()
	{
		super(new HashMap<String, Texture>());
	}

	@Override
	protected Texture loadResource(String key) throws IOException
	{
		Texture texture = new Texture();
		
		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource(key).getFile());
		texture.loadFromFile(file.toPath());
		return texture;
	}

	public static TextureResourceManager getInstance()
	{
		return singleton;
	}

}