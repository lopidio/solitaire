package br.com.guigasgame.solitaire.resourcemanager;

import java.io.File;
import java.io.IOException;
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
		soundBuffer.loadFromFile(new File(key).toPath());
		return soundBuffer;
	}

	public static SoundBufferResourceManager getInstance()
	{
		return singleton;
	}

}