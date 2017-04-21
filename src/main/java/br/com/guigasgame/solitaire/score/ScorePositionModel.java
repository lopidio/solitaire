package br.com.guigasgame.solitaire.score;

public class ScorePositionModel
{
	private int position;
	
	private int total;

	public ScorePositionModel()
	{
		this(-1, -1);
	}

	public ScorePositionModel(int position, int total)
	{
		super();
		this.position = position;
		this.total = total;
	}

	public int getPosition()
	{
		return position;
	}

	public void setPosition(int position)
	{
		this.position = position;
	}

	public int getTotal()
	{
		return total;
	}

	public void setTotal(int total)
	{
		this.total = total;
	}
	
	
}
