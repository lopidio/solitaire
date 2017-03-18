package br.com.guigasgame.solitaire.card;

public class Card
{
	private Rank rank;
	private Suit suit;

	public Card(Rank rank, Suit suit)
	{
		super();
		this.rank = rank;
		this.suit = suit;
	}

	public Rank getRank()
	{
		return rank;
	}

	public Suit getSuit()
	{
		return suit;
	}
}
