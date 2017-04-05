package br.com.guigasgame.solitaire.transaction;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import br.com.guigasgame.solitaire.solitaire.card.CardManager;

public class CardTransactionManager
{
	private Set<CardManager> selectedCardManagers;
	private Set<CardManager> cardsToAddToSelection;
	private Set<CardManager> cardsToRemoveToSelection;
	public CardTransactionManager()
	{
		selectedCardManagers = new LinkedHashSet<CardManager>();
		cardsToAddToSelection = new LinkedHashSet<CardManager>();
		cardsToRemoveToSelection = new LinkedHashSet<CardManager>();
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
		System.out.println("---");
		System.out.println("Greatest: " + cardsToRemoveToSelection.stream().skip(cardsToRemoveToSelection.size() - 1).findFirst().get().getCard());
		System.out.println("Destiny top: " + cardsToAddToSelection.stream().findFirst().get().getCard().getStack().getSolitaireTop());

	}

	public void updateTransactions()
	{
		if (cardsToRemoveToSelection.size() > 0)
		{
			if (cardsToAddToSelection.size() > 0)
			{
				System.out.println("There is a transaction to perform");
				display();
				selectedCardManagers.addAll(cardsToAddToSelection);
				selectedCardManagers.removeAll(cardsToRemoveToSelection);
				
				cardsToAddToSelection.clear();
			}
			cardsToRemoveToSelection.clear();
		}
	}
}
