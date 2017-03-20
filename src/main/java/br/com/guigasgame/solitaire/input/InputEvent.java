package br.com.guigasgame.solitaire.input;

public class InputEvent
{
	private InputEventType inputEventType;
	

	public InputEvent(InputEventType inputEventType)
	{
		super();
		this.inputEventType = inputEventType;
	}

	public InputEventType getInputEventType()
	{
		return inputEventType;
	}
}
