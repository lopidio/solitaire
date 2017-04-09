package br.com.guigasgame.solitaire.solitaire.card;

import br.com.guigasgame.solitaire.card.Card;
import br.com.guigasgame.solitaire.card.Rank;
import br.com.guigasgame.solitaire.card.Suit;
import br.com.guigasgame.solitaire.solitaire.stack.SolitaireCardStack;

public class CardSolitaire extends Card
{
	private SolitaireCardStack stack; 
	private boolean selected;
	private boolean revealed;

	public CardSolitaire(Rank rank, Suit suit)
	{
		super(rank, suit);
		revealed = false;
	}

	public boolean isRevealed()
	{
		return revealed;
	}

	public void reveal()
	{
		revealed = true;
	}

	public boolean isSelected()
	{
		return selected;
	}

	public boolean isAtStackTop()
	{
		if (null == stack)
			return false;
		Card top = stack.getTop().getCard();
		return top.getRank() == getRank() && top.getSuit() == getSuit();
	}
	
	public void select()
	{
		selected = true;
	}

	public void unselect()
	{
		selected = false;
	}
	
	public void setStack(SolitaireCardStack stack)
	{
		this.stack = stack;
	}

	@Override
	public boolean equals(Object obj)
	{
		return super.equals(obj);
	}

	public SolitaireCardStack getStack()
	{
		return stack;
	}

	public void unreveal()
	{
		revealed = false;
	}

}
