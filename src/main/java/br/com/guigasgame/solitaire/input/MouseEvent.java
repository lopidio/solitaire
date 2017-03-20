package br.com.guigasgame.solitaire.input;

import org.jsfml.system.Vector2i;

public class MouseEvent extends InputEvent
{
	private Vector2i position;
	private boolean leftPressed;
	private boolean rightPressed;
	
	public MouseEvent(Vector2i position, boolean leftPressed, boolean rightPressed)
	{
		super(InputEventType.mouse);
		this.position = position;
		this.leftPressed = leftPressed;
		this.rightPressed = rightPressed;
	}
	public Vector2i getPosition()
	{
		return position;
	}
	public boolean isLeftPressed()
	{
		return leftPressed;
	}
	public boolean isRightPressed()
	{
		return rightPressed;
	}

}
