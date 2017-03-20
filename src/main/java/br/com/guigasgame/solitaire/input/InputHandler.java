package br.com.guigasgame.solitaire.input;

import java.util.ArrayList;
import java.util.List;

public abstract class InputHandler
{
	
	private static final float DOUBLE_TAP_INTERVAL = 0.2f; //seconds
	
	// https://github.com/SFML/SFML/wiki/Tutorial:-Manage-dynamic-key-binding
	private List<InputListener> inputListeners;

	private boolean state;
	private boolean prevState;
	private float doubleTapCounter;

	public InputHandler()
	{
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
		if (handleInput())
		{
			hasSomePressed = true;
		}
		state = hasSomePressed;

		reportToListener(getInputEvent());
	}

	private void reportToListener(InputEvent inputEvent)
	{
		if (state)
		{
			activate(inputEvent);
		}
		else // if (!state)
		{
			deactivate(inputEvent);
		}
	}

	private void deactivate(InputEvent inputEvent)
	{
		if (prevState)
		{
			for (InputListener inputListener : inputListeners)
			{
				inputListener.inputReleased(inputEvent);
			}
		}
	}

	private void activate(InputEvent inputEvent)
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

	
	abstract boolean handleInput();
	abstract public InputEvent getInputEvent();
	
	public void addInputListener(InputListener inputListener)
	{
		inputListeners.add(inputListener);
	}

}
