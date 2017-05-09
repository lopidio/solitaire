package br.com.guigasgame.solitaire.resourcemanager;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.HashMap;

import org.jsfml.audio.SoundBuffer;

public class SoundBufferResourceManager extends ResourceManager<String, SoundBuffer>
{

	private static SoundBufferResourceManager singleton;

	static
	{
		singleton = new SoundBufferResourceManager();
	}

	private SoundBufferResourceManager()
	{
		super(new HashMap<String, SoundBuffer>());
	}

	@Override
	protected SoundBuffer loadResource(String key) throws IOException
	{
		SoundBuffer soundBuffer = new SoundBuffer();
//		ClassLoader classLoader = getClass().getClassLoader();
//		File file = new File(classLoader.getResource(key).getFile());
//		soundBuffer.loadFromFile(file.toPath());
		soundBuffer.loadFromFile(Paths.get("resources/" + key));
		
		return soundBuffer;
	}

	public static SoundBufferResourceManager getInstance()
	{
		return singleton;
	}

}