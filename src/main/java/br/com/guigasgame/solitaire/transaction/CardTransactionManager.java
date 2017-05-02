package br.com.guigasgame.solitaire.transaction;

import java.util.ArrayList;
import java.util.List;

import org.jsfml.window.Mouse.Button;

import br.com.guigasgame.solitaire.input.InputEvent;
import br.com.guigasgame.solitaire.input.InputEventType;
import br.com.guigasgame.solitaire.input.InputListener;
import br.com.guigasgame.solitaire.input.MouseEvent;
import br.com.guigasgame.solitaire.score.ScoreCounter;
import br.com.guigasgame.solitaire.solitaire.card.CardManager;
import br.com.guigasgame.solitaire.solitaire.stack.FoundationCardStack;
import br.com.guigasgame.solitaire.solitaire.stack.SolitaireCardStack;
import br.com.guigasgame.solitaire.solitaire.stack.SolitaireCardStackType;
import br.com.guigasgame.solitaire.solitaire.stack.TableauCardStack;
import br.com.guigasgame.solitaire.solitaire.stack.WasteCardStack;

public class CardTransactionManager implements InputListener
{
	private List<CardTransaction> transactions;
	private List<FoundationCardStack> foundations;
	private ScoreCounter scoreCounter;
	private List<SolitaireCardStack> stacksToSendCardsFromToFoundations;
	private boolean sendCardsToFoundationWhilePossible;
	
	public CardTransactionManager()
	{
		transactions = new ArrayList<>();
		foundations = new ArrayList<>();
		stacksToSendCardsFromToFoundations = new ArrayList<>();
	}

	public void addTransaction(CardTransaction transaction)
	{
		transactions.add(transaction);
	}

	
	public boolean updateTransactions()
	{
		if (sendCardsToFoundationWhilePossible)
			makeAttemptToSendCardsToFoundationFromAllStacks();
		boolean methodReturn = false;
		while (transactions.size() > 1)
		{
			CardTransaction a = transactions.get(0);
			CardTransaction b = transactions.get(1);
			if (a.getStack() != b.getStack())
			{
				if (b.getUnselectedCards().size() > 0) //from b to a
				{
					methodReturn |= tryToMakeTransaction(b, a);
				}
				else if (a.getUnselectedCards().size() > 0) //from a to b
				{
					methodReturn |= tryToMakeTransaction(a, b);
				}
			}
			transactions.remove(0);
		}
		if (!transactions.isEmpty())
			if (transactions.get(0).getSelectedCards().isEmpty())
				transactions.clear();
		if (sendCardsToFoundationWhilePossible)
			sendCardsToFoundationWhilePossible = methodReturn;
		return methodReturn;
	}

	private boolean tryToMakeTransaction(CardTransaction from, CardTransaction to)
	{
		if (checkIfTransactionIsPossible(to.getStack(), from.getUnselectedCards()))
		{
			System.out.println("Transfering " + from.getUnselectedCards().size() + " cards from: " + from.getStack().getStackType() + " to " + to.getStack().getStackType());
			doTransaction(to.getStack(), from.getStack(), from.getUnselectedCards());
			scoreCounter.registerTransaction(from.getStack().getStackType(), to.getStack().getStackType());
			return true;
		}
		return false;
	}

	private void doTransaction(SolitaireCardStack destinyStack, SolitaireCardStack sourceStack, List<CardManager> cards)
	{
		List<CardManager> cardsToMove = new ArrayList<>(cards); //clones
		while(!cardsToMove.isEmpty())
		{
			CardManager card = cardsToMove.get(0);
			sourceStack.removeCard(card);
			destinyStack.addCard(card);
			if (!cardsToMove.remove(card))
			{
				System.out.println("Error to remove card: " + card.getCard());
			}
		}
		destinyStack.unselectAll();
	}

	private boolean checkIfTransactionIsPossible(SolitaireCardStack destinyStack, List<CardManager> cardsToMove)
	{
		List<CardManager> list = new ArrayList<>();
		list.addAll(cardsToMove);
		return (destinyStack.canAddCards(list));
	}
	
	private void makeAttemptToSendCardsToFoundationFromAllStacks()
	{
		transactions.clear();

		for (SolitaireCardStack solitaireCardStack : stacksToSendCardsFromToFoundations)
		{
			CardTransaction transaction = new CardTransaction(solitaireCardStack);
			transaction.setUnselectedCards(new ArrayList<>());
			List<CardManager> selected = new ArrayList<>();
			CardManager top = solitaireCardStack.getTop();
			if (null != top)
			{
				if (solitaireCardStack.getStackType() == SolitaireCardStackType.tableau && !top.isRevealed())
				{
					top.revealCard();
					scoreCounter.registerCardRevelation();
				}
				selected.add(top);
				transaction.setSelectedCards(selected);
				addTransactionToFoundationsAttempt(transaction);
			}
		}
	}

	public void addTransactionToFoundationsAttempt(CardTransaction transaction)
	{
		transaction.setUnselectedCards(transaction.getSelectedCards());
		for (FoundationCardStack foundationCardStack : foundations)
		{
			addTransaction(transaction);
			addTransaction(new CardTransaction(foundationCardStack));
		}
	}

	public void addFoundation(FoundationCardStack foundationCardStack)
	{
		foundations.add(foundationCardStack);
	}

	public void setScoreCounter(ScoreCounter scoreCounter)
	{
		this.scoreCounter = scoreCounter;
	}

	public void registerCardRevelation()
	{
		scoreCounter.registerCardRevelation();
	}

	public void setWasteStack(WasteCardStack wasteCardStack)
	{
		stacksToSendCardsFromToFoundations.add(wasteCardStack);
	}

	public void addTableauStack(TableauCardStack tableauCardStack)
	{
		stacksToSendCardsFromToFoundations.add(tableauCardStack);
	}
	
	@Override
	public void inputPressed(InputEvent inputValue)
	{
		if (inputValue.getInputEventType() == InputEventType.mouse)
		{
			MouseEvent mouseEvent = (MouseEvent) inputValue;
			if (mouseEvent.getMouseButton() ==  Button.RIGHT)
			{
				sendCardsToFoundationWhilePossible = true;
			}
				
		}
	}
}
