package br.com.guigasgame.solitaire.transaction;

import java.util.ArrayList;
import java.util.List;

import br.com.guigasgame.solitaire.solitaire.card.CardManager;
import br.com.guigasgame.solitaire.solitaire.stack.SolitaireCardStack;

public class CardTransactionManager
{
	private List<CardTransaction> transactions;
	public CardTransactionManager()
	{
		transactions = new ArrayList<>();
	}

	public void addTransaction(CardTransaction transaction)
	{
		transactions.add(transaction);
	}

	
	public void updateTransactions()
	{
		if (transactions.size() > 1)
		{
			CardTransaction a = transactions.get(0);
			CardTransaction b = transactions.get(1);
			if (a.getStack() != b.getStack())
			{
				if (b.getUnselectedCards().size() > 0) //from b to a
				{
					tryToMakeTransaction(b, a);
				}
				else if (a.getUnselectedCards().size() > 0) //from a to b
				{
					tryToMakeTransaction(a, b);
				}
			}
			transactions.remove(0);
		}
	}

	private void tryToMakeTransaction(CardTransaction from, CardTransaction to)
	{
		if (checkIfTransactionIsPossible(to.getStack(), from.getUnselectedCards()))
		{
			doTransaction(to.getStack(), from.getStack(), from.getUnselectedCards());
		}
	}

	private void doTransaction(SolitaireCardStack destinyStack, SolitaireCardStack sourceStack, List<CardManager> cardsToMove)
	{
		while(cardsToMove.size() > 0)
		{
			CardManager card = cardsToMove.get(0);
			sourceStack.removeCard();
			destinyStack.addCard(card);
			cardsToMove.remove(card);
		}
		destinyStack.unselectAll();
	}

	private boolean checkIfTransactionIsPossible(SolitaireCardStack destinyStack, List<CardManager> cardsToMove)
	{
		List<CardManager> list = new ArrayList<>();
		list.addAll(cardsToMove);
		return (destinyStack.canAddCards(list));
	}
}
