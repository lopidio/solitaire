package br.com.guigasgame.solitaire.input;

import org.jsfml.graphics.RenderWindow;
import org.jsfml.window.Mouse;
import org.jsfml.window.Mouse.Button;

public class MouseInput implements InputHandler
{
	private Mouse.Button mouseButton;
	private RenderWindow renderWindow;

	public MouseInput(Button mouseButton, RenderWindow renderWindow)
	{
		super();
		this.mouseButton = mouseButton;
		this.renderWindow = renderWindow;
	}

	@Override
	public boolean handleInput()
	{
		if (Mouse.isButtonPressed(mouseButton))
			return true;
		return false;
	}

	@Override
	public MouseEvent getInputEvent()
	{
		return new MouseEvent(Mouse.getPosition(renderWindow), 
				Mouse.isButtonPressed(Button.LEFT),
				Mouse.isButtonPressed(Button.RIGHT));
	}

}