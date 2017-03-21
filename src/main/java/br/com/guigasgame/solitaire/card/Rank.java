package br.com.guigasgame.solitaire.card;

public enum Rank
{
	ace,
	two,
	three,
	four,
	five,
	six,
	seven,
	eight,
	nine,
	ten,
	jack,
	queen,
	king;
	
	public int getValue()
	{
		return ordinal() + 1;
	}
}
