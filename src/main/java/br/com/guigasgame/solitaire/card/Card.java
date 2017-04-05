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
	
	@Override
	public boolean equals(Object obj)
	{
		if (obj == null)
		{
			return false;
		}
		if (!Card.class.isAssignableFrom(obj.getClass()))
		{
			return false;
		}
		final Card other = (Card) obj;
		if ((this.rank == null) ? (other.rank != null) : !this.rank.equals(other.rank))
		{
			return false;
		}
		if ((this.suit == null) ? (other.suit != null) : !this.suit.equals(other.suit))
		{
			return false;
		}
		return true;
	
	}

	@Override
	public String toString()
	{
		return rank.getValue() + suit.getText();
	}

}
