package br.com.guigasgame.solitaire.card;

public enum Suit
{
	hearts(SuitColor.red, "♥", 1), 
	spades(SuitColor.black, "♠", 2),
	diamonds(SuitColor.red, "♦", 3),
	clubs(SuitColor.black, "♣", 4);

	private SuitColor color;
	private String text;
	private int value;
	
	Suit(SuitColor color, String text, int value)
	{
		this.color = color;
		this.text = text;
		this.value = value;
	}

	public SuitColor getSuitColor()
	{
		return color;
	}
	
	public String getText()
	{
		return text;
	}

	public int getValue()
	{
		return value;
	}
	
	
}
