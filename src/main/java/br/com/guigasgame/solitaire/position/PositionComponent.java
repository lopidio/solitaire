package br.com.guigasgame.solitaire.position;

import org.jsfml.system.Vector2f;

public class PositionComponent
{
	private float x;
	private float y;
	
	public PositionComponent(Vector2f position)
	{
		super();
		x = position.x;
		y = position.y;
	}

	public PositionComponent(int x, int y)
	{
		super();
		this.x = x;
		this.y = y;
	}

	public PositionComponent()
	{
		super();
		x = 0;
		y = 0;
	}

	public PositionComponent(float x, float y)
	{
		this.x = x;
		this.y = y;
	}

	public void add(PositionComponent positionComponent)
	{
		x += positionComponent.x;
		y += positionComponent.y;
	}

	public float getX()
	{
		return x;
	}

	public void setX(float x)
	{
		this.x = x;
	}

	public float getY()
	{
		return y;
	}

	public void setY(float y)
	{
		this.y = y;
	}
	
}
