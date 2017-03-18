package br.com.guigasgame.solitaire.card;

public enum Suit
{
	spades(SuitColor.black, "♠"),
	hearts(SuitColor.red, "♥"), 
	diamonds(SuitColor.red, "♦"),
	clubs(SuitColor.black, "♣");

	private SuitColor color;
	String text;
	
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
	
	
}
