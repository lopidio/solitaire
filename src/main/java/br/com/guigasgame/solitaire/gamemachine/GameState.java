package br.com.guigasgame.solitaire.gamemachine;

import org.jsfml.graphics.RenderTarget;
import org.jsfml.graphics.RenderWindow;
import org.jsfml.window.event.Event;


public interface GameState
{

	public default void update(float updateDelta)
	{
		
	}

	public default void draw(RenderTarget renderTarget)
	{
		
	}

	public default void enterState(RenderWindow renderWindow)
	{

	}

	public default void exitState()
	{

	}

	public default void load()
	{

	}

	public default void unload()
	{

	}

	public default void handleEvent(Event event, RenderWindow renderWindow)
	{

	}
}