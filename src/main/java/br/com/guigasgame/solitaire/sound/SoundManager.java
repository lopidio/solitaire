package br.com.guigasgame.solitaire.sound;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.jsfml.audio.Sound;

import br.com.guigasgame.solitaire.config.ConfigFile;
import br.com.guigasgame.solitaire.resourcemanager.SoundBufferResourceManager;

public class SoundManager
{
	private static SoundManager instance;
	private boolean soundEnabled;
	private List<Sound> cardFlipSounds;
	private List<Sound> cardMoveSounds;
	private Sound newGameSound;
	private Random random;
	
	private SoundManager()
	{
		soundEnabled = Boolean.parseBoolean(ConfigFile.getInstance().getValue("soundEnabled"));
		newGameSound = new Sound(SoundBufferResourceManager.getInstance().getResource("newGame.wav"));
		random = new Random();

		initCardFlipSounds();
		initCardMoveSounds();
	}

	private void initCardMoveSounds()
	{
		cardMoveSounds = new ArrayList<>();
		cardMoveSounds.add(new Sound(SoundBufferResourceManager.getInstance().getResource("cardMove1.wav")));
		cardMoveSounds.add(new Sound(SoundBufferResourceManager.getInstance().getResource("cardMove2.wav")));
		cardMoveSounds.add(new Sound(SoundBufferResourceManager.getInstance().getResource("cardMove3.wav")));
		cardMoveSounds.add(new Sound(SoundBufferResourceManager.getInstance().getResource("cardMove4.wav")));
		cardMoveSounds.add(new Sound(SoundBufferResourceManager.getInstance().getResource("cardMove5.wav")));
	}

	private void initCardFlipSounds()
	{
		cardFlipSounds = new ArrayList<>();
		cardFlipSounds.add(new Sound(SoundBufferResourceManager.getInstance().getResource("cardFlip1.wav")));
		cardFlipSounds.add(new Sound(SoundBufferResourceManager.getInstance().getResource("cardFlip2.wav")));
		cardFlipSounds.add(new Sound(SoundBufferResourceManager.getInstance().getResource("cardFlip3.wav")));
		cardFlipSounds.add(new Sound(SoundBufferResourceManager.getInstance().getResource("cardFlip4.wav")));
	}

	public static SoundManager getInstance()
	{
		if (null == instance)
			instance = new SoundManager();
		return instance;
	}

	public void playCardFlip()
	{
		if (soundEnabled)
		{
			cardFlipSounds.get(random.nextInt(cardFlipSounds.size())).play();
		}
	}

	public void playCardMove()
	{
		if (soundEnabled)
		{
			cardMoveSounds.get(random.nextInt(cardMoveSounds.size())).play();
		}
	}

	public void playCardsShuffle()
	{
		if (soundEnabled)
		{
			newGameSound.play();
		}
	}

}
