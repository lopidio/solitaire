package br.com.guigasgame.solitaire.transaction;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import br.com.guigasgame.solitaire.solitaire.card.CardManager;
import br.com.guigasgame.solitaire.solitaire.stack.SolitaireCardStack;

public class CardTransactionManager
{
	private Set<CardManager> selectedCardManagers;
	private List<CardManager> cardsToAddToSelection;
	private List<CardManager> cardsToRemoveToSelection;
	public CardTransactionManager()
	{
		selectedCardManagers = new LinkedHashSet<CardManager>();
		cardsToAddToSelection = new ArrayList<>();
		cardsToRemoveToSelection = new ArrayList<>();
	}

	public void addCardToSelection(List<CardManager> cardManager)
	{
		cardsToAddToSelection.addAll(cardManager);
		cardsToRemoveToSelection.removeAll(cardManager);
	}

	public void removeCardToSelection(List<CardManager> cardManager)
	{
		cardsToRemoveToSelection.addAll(cardManager);
		cardsToAddToSelection.removeAll(cardManager);
	}
	
	public void updateTransactions()
	{
		if (cardsToRemoveToSelection.size() > 0)
		{
			if (cardsToAddToSelection.size() > 0)
			{
				SolitaireCardStack destinyStack = cardsToAddToSelection.stream().findFirst().get().getCard().getStack();
				if (destinyStack.canAddCards(cardsToRemoveToSelection))
				{
					startTransaction(destinyStack);
				}
				
				selectedCardManagers.addAll(cardsToAddToSelection);
				selectedCardManagers.removeAll(cardsToRemoveToSelection);
				
				cardsToAddToSelection.clear();
			}
			cardsToRemoveToSelection.clear();
		}
	}

	private void startTransaction(SolitaireCardStack destinyStack)
	{
		SolitaireCardStack sourceStack = cardsToRemoveToSelection.stream().findFirst().get().getCard().getStack();
		while(cardsToRemoveToSelection.size() > 0)
		{
			CardManager highestCard = cardsToRemoveToSelection.get(cardsToRemoveToSelection.size() - 1);
			sourceStack.removeCard();
			destinyStack.addCard(highestCard);
			cardsToRemoveToSelection.remove(highestCard);
		}
		destinyStack.unselectAll();
	}
}
