package br.com.guigasgame.solitaire.transaction;

import java.util.LinkedHashSet;
import java.util.Set;

import br.com.guigasgame.solitaire.solitaire.card.CardManager;

public class CardTransactionManager
{
	private Set<CardManager> cardManagers;
	public CardTransactionManager()
	{
		cardManagers = new LinkedHashSet<CardManager>();
	}

	public void addCardToSelection(CardManager cardManager)
	{
		cardManagers.add(cardManager);
		display();
	}

	public void removeCardToSelection(CardManager cardManager)
	{
		cardManagers.remove(cardManager);
		display();
	}
	

	private void display()
	{
		System.out.println("Current list: ");
		cardManagers.stream().forEach(cardManager ->
		{
			System.out.print(cardManager.getCard().getRank().getValue() + cardManager.getCard().getSuit().getText() + "; ");
		});
		System.out.println("---");

	}
}
