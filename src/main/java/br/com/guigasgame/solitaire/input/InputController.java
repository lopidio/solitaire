package br.com.guigasgame.solitaire.input;

import java.util.ArrayList;
import java.util.List;

public class InputController
{
	private static final float DOUBLE_TAP_INTERVAL = 0.2f; //seconds
	
	// https://github.com/SFML/SFML/wiki/Tutorial:-Manage-dynamic-key-binding
	private List<InputListener> inputListeners;

	private List<InputHandler> handlers;

	private boolean state;
	private boolean prevState;
	private float doubleTapCounter;

	public InputController()
	{
		handlers = new ArrayList<InputHandler>();
		state = false;
		prevState = false;
		doubleTapCounter = 2*DOUBLE_TAP_INTERVAL;
		inputListeners = new ArrayList<>();
	}

	public void handleEvent(float deltaTime)
	{
		if (inputListeners.isEmpty())
			return;
		
		incrementDoubleTapCounter(deltaTime);
		prevState = state;
		boolean hasSomePressed = false;
		List<InputEvent> events = new ArrayList<>();
		for( InputHandler inputHandler : handlers )
		{
			if (inputHandler.handleInput())
			{
				events.add(inputHandler.getInputEvent());
				hasSomePressed = true;
			}
		}
		state = hasSomePressed;

		reportToListener(events);
	}

	private void reportToListener(List<InputEvent> events)
	{
		if (state)
		{
			activate(events);
		}
		else // if (!state)
		{
			deactivate(events);
		}
	}

	private void deactivate(List<InputEvent> events)
	{
		if (prevState)
		{
			for (InputEvent inputEvent : events)
			{
				for (InputListener inputListener : inputListeners)
				{
					inputListener.inputReleased(inputEvent);
				}
			}
		}
	}

	private void activate(List<InputEvent> events)
	{
		for (InputEvent inputEvent : events)
		{
			for (InputListener inputListener : inputListeners)
			{
				inputListener.isPressing(inputEvent);
				if (!prevState)
				{
					inputListener.inputPressed(inputEvent);
					if (checkDoubleTap())
						inputListener.doubleTapInput(inputEvent);
				}
			}

		}
		doubleTapCounter = 0;
	}

	private void incrementDoubleTapCounter(float deltaTime)
	{
		if (doubleTapCounter < 2*DOUBLE_TAP_INTERVAL)
			doubleTapCounter += deltaTime;
	}

	private boolean checkDoubleTap()
	{
		return doubleTapCounter <= DOUBLE_TAP_INTERVAL;
	}


	public void addInputListener(InputListener inputListener)
	{
		inputListeners.add(inputListener);
	}

	public InputController addInputHandler(InputHandler inputHandler)
	{
		handlers.add(inputHandler);
		return this;
	}
}