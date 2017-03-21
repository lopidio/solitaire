package br.com.guigasgame.solitaire.card;

public enum Suit
{
	hearts(SuitColor.red, "♥"), 
	diamonds(SuitColor.red, "♦"),
	clubs(SuitColor.black, "♣"),
	spades(SuitColor.black, "♠");

	private SuitColor color;
	private String text;
	
	Suit(SuitColor color, String text)
	{
		this.color = color;
		this.text = text;
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
		return ordinal() + 1;
	}
	
	
}
