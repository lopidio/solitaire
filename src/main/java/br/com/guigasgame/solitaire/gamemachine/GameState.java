package br.com.guigasgame.solitaire.gamemachine;

import org.jsfml.graphics.RenderTarget;
import org.jsfml.window.event.Event;


public interface GameState
{

	public void update(float updateDelta);

	public void draw(RenderTarget renderTarget);

	public default void enterState(RenderTarget renderTarget)
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

	public default void handleEvent(Event event, RenderTarget renderTarget)
	{

	}
}