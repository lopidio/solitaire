package br.com.guigasgame.solitaire.position;

import org.jsfml.system.Vector2f;
import org.jsfml.system.Vector2i;

public class PositionComponent
{
	private Vector2f position;
	
	public PositionComponent(Vector2f position)
	{
		super();
		this.position = position;
	}

	public PositionComponent(int x, int y)
	{
		super();
		this.position = new Vector2f(x, y);
	}

	public PositionComponent()
	{
		super();
		this.position = new Vector2f(0, 0);
	}

	public PositionComponent(float x, float y)
	{
		this.position = new Vector2f(x, y);
	}

	public Vector2f getPosition()
	{
		return position;
	}

	public void setPosition(Vector2f position)
	{
		this.position = position;
	}

}
