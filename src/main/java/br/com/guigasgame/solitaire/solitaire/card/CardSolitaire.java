package br.com.guigasgame.solitaire.solitaire.card;

import java.util.ArrayList;
import java.util.List;

import br.com.guigasgame.solitaire.card.Card;
import br.com.guigasgame.solitaire.card.Rank;
import br.com.guigasgame.solitaire.card.Suit;
import br.com.guigasgame.solitaire.solitaire.SolitaireCardStack;

public class CardSolitaire extends Card
{
	private SolitaireCardStack stack; 
	private boolean selected;
	private boolean revealed;
	private List<CardSolitaireListener> listeners;

	public CardSolitaire(Rank rank, Suit suit)
	{
		super(rank, suit);
		revealed = false;
		listeners = new ArrayList<>();
	}

	public boolean isRevealed()
	{
		return revealed;
	}

	public void reveal()
	{
		revealed = true;
		listeners.stream().forEach(listener -> listener.revealAction(this));
	}

	public boolean isSelected()
	{
		return selected;
	}

	public boolean isAtStackTop()
	{
		if (null == stack)
			return false;
		Card top = stack.getTop();
		return top.getRank() == getRank() && top.getSuit() == getSuit();
	}
	
	public void addListener(CardSolitaireListener listener)
	{
		listeners.add(listener);
	}

	public void removeListener(CardSolitaireListener listener)
	{
		listeners.remove(listener);
	}

	public SolitaireCardStack getStack()
	{
		return stack;
	}

	public void setStack(SolitaireCardStack stack)
	{
		this.stack = stack;
	}

	public void select()
	{
		selected = true;
		listeners.stream().forEach(listener -> listener.selectAction(this));
	}

	public void unselect()
	{
		selected = false;
		listeners.stream().forEach(listener -> listener.selectAction(this));
	}
}
