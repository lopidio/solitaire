package br.com.guigasgame.solitaire.resourcemanager;

import java.io.IOException;
import java.nio.file.Paths;
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
		
		texture.loadFromFile(Paths.get("resources/" + key));
		return texture;
	}

	public static TextureResourceManager getInstance()
	{
		return singleton;
	}

}