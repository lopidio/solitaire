package br.com.guigasgame.solitaire.solitaire.stack;

import java.util.ArrayList;
import java.util.List;

import br.com.guigasgame.solitaire.card.Card;
import br.com.guigasgame.solitaire.solitaire.card.CardSolitaire;
import br.com.guigasgame.solitaire.stack.CardStack;
import br.com.guigasgame.solitaire.stack.CardStackListener;

public abstract class SolitaireCardStack implements CardStack
{
	protected List<CardSolitaire> cards;
	private SolitaireCardStackType stackType;
	private List<CardStackListener> listeners;

	public SolitaireCardStack(SolitaireCardStackType stackType)
	{
		this.cards = new ArrayList<>();
		this.stackType = stackType;
		listeners = new ArrayList<>();
	}
	
	protected abstract boolean canAddSolitaireCard(CardSolitaire card);
	
	@Override
	public int getSize()
	{
		return cards.size();
	}

	@Override
	public Card getTop()
	{
		if (cards.size() > 0)
			return cards.get(cards.size() - 1);
		return null;
	}

	@Override
	public boolean addCard(Card card)
	{
		CardSolitaire solitaireCard = (CardSolitaire) card;
		cards.add(solitaireCard);
		solitaireCard.setStack(this);
		listeners.stream().forEach(listener -> listener.cardAdded(card));
		return true;
	}
	
	@Override
	public boolean canAddCard(Card card)
	{
		return canAddSolitaireCard((CardSolitaire) card);
	}

	@Override
	public CardSolitaire removeCard()
	{
		if (cards.isEmpty())
			return null;
		CardSolitaire returnCard = cards.remove(cards.size() - 1);
		returnCard.setStack(null);
		listeners.stream().forEach(listener -> listener.cardRemoved(returnCard));
		return returnCard;
	}

	public CardSolitaire getSolitaireTop()
	{
		if (cards.size() > 0)
			return cards.get(cards.size() - 1);
		return null;
	}
	public List<CardSolitaire> getCards()
	{
		return cards;
	}

	public SolitaireCardStackType getStackType()
	{
		return stackType;
	}
	
	public void addListener(CardStackListener cardStackListener)
	{
		listeners.add(cardStackListener);
	}
	
	public void removeListener(CardStackListener cardStackListener)
	{
		listeners.remove(cardStackListener);
	}
	
}
