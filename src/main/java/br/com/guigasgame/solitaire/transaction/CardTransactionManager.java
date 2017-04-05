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
	

	private void display()
	{
		System.out.println("Selected list: ");
		cardsToAddToSelection.stream().forEach(cardManager ->
		{
			System.out.print(cardManager.getCard() + "; ");
		});

	}

	public void updateTransactions()
	{
		if (cardsToRemoveToSelection.size() > 0)
		{
			if (cardsToAddToSelection.size() > 0)
			{
				System.out.println("There is a transaction to perform");
				
				cardsToAddToSelection.stream().forEach(card -> card.unselectCard());
				SolitaireCardStack destinyStack = cardsToAddToSelection.stream().findFirst().get().getCard().getStack();
				SolitaireCardStack sourceStack = cardsToRemoveToSelection.stream().findFirst().get().getCard().getStack();
				while(cardsToRemoveToSelection.size() > 0)
				{
					CardManager greatestOfCardSource = cardsToRemoveToSelection.get(cardsToRemoveToSelection.size() - 1);
					if (destinyStack.canAddCard(greatestOfCardSource))
					{
						greatestOfCardSource.unselectCard();
						sourceStack.removeCard();
						destinyStack.addCard(greatestOfCardSource);
						cardsToRemoveToSelection.remove(greatestOfCardSource);
					}
					else
						break;
				}
				
				
				selectedCardManagers.addAll(cardsToAddToSelection);
				selectedCardManagers.removeAll(cardsToRemoveToSelection);
				
				cardsToAddToSelection.clear();
			}
			cardsToRemoveToSelection.clear();
		}
	}
}
