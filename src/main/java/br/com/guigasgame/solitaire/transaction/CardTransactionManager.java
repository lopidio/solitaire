package br.com.guigasgame.solitaire.transaction;

import java.util.ArrayList;
import java.util.List;

import br.com.guigasgame.solitaire.solitaire.card.CardManager;
import br.com.guigasgame.solitaire.solitaire.stack.FoundationCardStack;
import br.com.guigasgame.solitaire.solitaire.stack.SolitaireCardStack;

public class CardTransactionManager
{
	private List<CardTransaction> transactions;
	private List<FoundationCardStack> foundations;
	public CardTransactionManager()
	{
		transactions = new ArrayList<>();
		foundations = new ArrayList<>();
	}

	public void addTransaction(CardTransaction transaction)
	{
		transactions.add(transaction);
	}

	
	public boolean updateTransactions()
	{
		boolean methodReturn = false;
		while (transactions.size() > 1)
		{
			CardTransaction a = transactions.get(0);
			CardTransaction b = transactions.get(1);
			if (a.getStack() != b.getStack())
			{
				if (b.getUnselectedCards().size() > 0) //from b to a
				{
					methodReturn = tryToMakeTransaction(b, a);
				}
				else if (a.getUnselectedCards().size() > 0) //from a to b
				{
					methodReturn = tryToMakeTransaction(a, b);
				}
			}
			transactions.remove(0);
		}
		if (!transactions.isEmpty())
			if (transactions.get(0).getSelectedCards().isEmpty())
				transactions.clear();
		return methodReturn;
	}

	private boolean tryToMakeTransaction(CardTransaction from, CardTransaction to)
	{
		if (checkIfTransactionIsPossible(to.getStack(), from.getUnselectedCards()))
		{
			System.out.println("Transfering " + from.getUnselectedCards().size() + " cards from: " + from.getStack().getStackType() + " to " + to.getStack().getStackType());
			doTransaction(to.getStack(), from.getStack(), from.getUnselectedCards());
			return true;
		}
		return false;
	}

	private void doTransaction(SolitaireCardStack destinyStack, SolitaireCardStack sourceStack, List<CardManager> cards)
	{
		List<CardManager> cardsToMove = new ArrayList<>(cards); //clones
		while(!cardsToMove.isEmpty())
		{
			CardManager card = sourceStack.removeCard();
			destinyStack.addCard(card);
			int index = cardsToMove.indexOf(card);
			if (index == -1)
			{
				System.out.println("Error");
			}
			cardsToMove.remove(index);
		}
		destinyStack.unselectAll();
	}

	private boolean checkIfTransactionIsPossible(SolitaireCardStack destinyStack, List<CardManager> cardsToMove)
	{
		List<CardManager> list = new ArrayList<>();
		list.addAll(cardsToMove);
		return (destinyStack.canAddCards(list));
	}

	public void addTransactionToFoundationsAttempt(CardTransaction transaction)
	{
		transaction.setUnselectedCards(transaction.getSelectedCards());
		transaction.setSelectedCards(new ArrayList<>());
		for (FoundationCardStack foundationCardStack : foundations)
		{
			addTransaction(transaction);
			CardTransaction destiny = new CardTransaction(foundationCardStack);
			destiny.setUnselectedCards(new ArrayList<>());
			destiny.setSelectedCards(new ArrayList<>());
			addTransaction(destiny);
		}
	}

	public void addFoundation(FoundationCardStack foundationCardStack)
	{
		foundations.add(foundationCardStack);
	}
}
