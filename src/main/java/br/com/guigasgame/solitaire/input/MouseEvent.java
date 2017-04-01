package br.com.guigasgame.solitaire.input;

import org.jsfml.system.Vector2f;
import org.jsfml.system.Vector2i;
import org.jsfml.window.Mouse.Button;

public class MouseEvent extends InputEvent
{
	private Vector2i position;
	private Button mouseButton;
	
	public MouseEvent(Vector2f position, Button mouseButton)
	{
		super(InputEventType.mouse);
		this.position = new Vector2i(position);
		this.mouseButton = mouseButton;
	}
	public Vector2i getPosition()
	{
		return position;
	}
	public Button getMouseButton()
	{
		return mouseButton;
	}

}
