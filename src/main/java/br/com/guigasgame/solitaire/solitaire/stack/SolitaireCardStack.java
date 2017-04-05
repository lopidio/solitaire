package br.com.guigasgame.solitaire.solitaire.stack;

import java.util.ArrayList;
import java.util.List;

import br.com.guigasgame.solitaire.solitaire.card.CardManager;
import br.com.guigasgame.solitaire.stack.CardStack;
import br.com.guigasgame.solitaire.stack.CardStackListener;
import br.com.guigasgame.solitaire.transaction.CardTransactionManager;

public abstract class SolitaireCardStack implements CardStack
{
	protected List<CardManager> cards;
	protected CardTransactionManager transactionManager;
	private SolitaireCardStackType stackType;
	private List<CardStackListener> listeners;

	public SolitaireCardStack(SolitaireCardStackType stackType)
	{
		this.cards = new ArrayList<>();
		this.stackType = stackType;
		listeners = new ArrayList<>();
	}
	
	protected abstract boolean canAddSolitaireCard(CardManager card);
	
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
	public boolean canAddCard(CardManager card)
	{
		return canAddSolitaireCard(card);
	}

	@Override
	public CardManager removeCard()
	{
		if (cards.isEmpty())
			return null;
		CardManager returnCard = cards.remove(cards.size() - 1);
		returnCard.getCard().setStack(null);
		listeners.stream().forEach(listener -> listener.cardRemoved(returnCard));
		return returnCard;
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

}
