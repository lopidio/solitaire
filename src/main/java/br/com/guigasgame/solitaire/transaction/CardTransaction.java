package br.com.guigasgame.solitaire.transaction;

import java.util.List;

import br.com.guigasgame.solitaire.solitaire.card.CardManager;
import br.com.guigasgame.solitaire.solitaire.stack.SolitaireCardStack;

public class CardTransaction
{
	private SolitaireCardStack stack;
	private List<CardManager> selectedCards;
	private List<CardManager> unselectedCards;
	
	public CardTransaction(SolitaireCardStack stack)
	{
		super();
		this.stack = stack;
	}
	
	public List<CardManager> getSelectedCards()
	{
		return selectedCards;
	}

	public List<CardManager> getUnselectedCards()
	{
		return unselectedCards;
	}

	public SolitaireCardStack getStack()
	{
		return stack;
	}

	public void setSelectedCards(List<CardManager> selectedCards)
	{
		this.selectedCards = selectedCards;
	}

	public void setUnselectedCards(List<CardManager> unselectedCards)
	{
		this.unselectedCards = unselectedCards;
	}
	
}
