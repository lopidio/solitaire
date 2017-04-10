package br.com.guigasgame.solitaire.solitaire.stack;

import java.util.ArrayList;
import java.util.List;

import br.com.guigasgame.solitaire.position.PositionComponent;
import br.com.guigasgame.solitaire.solitaire.card.CardManager;
import br.com.guigasgame.solitaire.stack.CardStack;
import br.com.guigasgame.solitaire.stack.CardStackListener;
import br.com.guigasgame.solitaire.transaction.CardTransactionManager;

public abstract class SolitaireCardStack implements CardStack
{
	protected List<CardManager> cards;
	protected CardTransactionManager transactionManager;
	protected PositionComponent center;
	private SolitaireCardStackType stackType;
	protected List<CardStackListener> listeners;

	public SolitaireCardStack(SolitaireCardStackType stackType)
	{
		this.cards = new ArrayList<>();
		this.stackType = stackType;
		listeners = new ArrayList<>();
	}
	
	@Override
	public int getSize()
	{
		return cards.size();
	}

	@Override
	public CardManager getTop()
	{
		if (cards.size() > 0)
			return cards.get(cards.size() - 1);
		return null;
	}

	@Override
	public boolean addCard(CardManager card)
	{
		cards.add(card);
		card.getCard().setStack(this);
		listeners.stream().forEach(listener -> listener.cardAdded(card));
		return true;
	}
	
	@Override
	public CardManager removeCard(CardManager card)
	{
		if (cards.isEmpty())
			return null;
		cards.remove(card);
		card.getCard().setStack(null);
		listeners.stream().forEach(listener -> listener.cardRemoved(card));
		return card;
	}

	public CardManager getSolitaireTop()
	{
		if (cards.size() > 0)
			return cards.get(cards.size() - 1);
		return null;
	}
	public List<CardManager> getCards()
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
	
	public void setTransactionManager(CardTransactionManager transactionManager)
	{
		this.transactionManager = transactionManager;
	}

	public void unselectAll()
	{
		cards.stream().forEach(card -> card.unselectCard());		
	}

	public void setCenter(PositionComponent center)
	{
		this.center = center;
	}

}
