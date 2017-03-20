package br.com.guigasgame.solitaire.input;

import java.util.ArrayList;
import java.util.List;

public class InputController
{
	// https://github.com/SFML/SFML/wiki/Tutorial:-Manage-dynamic-key-binding
	private List<InputHandler> handlers;
	public InputController()
	{
		handlers = new ArrayList<InputHandler>();
	}

	public void handleEvent(float deltaTime)
	{
		for (InputHandler inputHandler : handlers)
		{
			inputHandler.handleEvent(deltaTime);
		}
		
	}

	public void addInputHandler(InputHandler inputHandler)
	{
		handlers.add(inputHandler);
	}
}