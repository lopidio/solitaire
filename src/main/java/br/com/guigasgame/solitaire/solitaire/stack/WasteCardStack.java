package br.com.guigasgame.solitaire.solitaire.stack;

import java.util.ArrayList;
import java.util.List;

import br.com.guigasgame.solitaire.input.InputEvent;
import br.com.guigasgame.solitaire.input.InputListener;
import br.com.guigasgame.solitaire.solitaire.card.CardManager;
import br.com.guigasgame.solitaire.transaction.CardTransaction;

public class WasteCardStack extends SolitaireCardStack implements InputListener
{
	public WasteCardStack()
	{
		super(SolitaireCardStackType.waste);
	}

	@Override
	public boolean canAddCards(List<CardManager> cards)
	{
		if (cards.size() == 1)
		{
			return cards.get(0).getCard().getStack().getStackType() == SolitaireCardStackType.stock;
		}
		return false;
	}
	
	public void inputPressed(InputEvent inputValue)
	{
		if (cards.isEmpty())
		{
			return;
		}

		CardManager cardManager = cards.get(cards.size() - 1);

		List<CardManager> cardsToUnselect = new ArrayList<>();
		List<CardManager> cardsToSelect = new ArrayList<>();
	
		boolean wasSelected = cardManager.getCard().isSelected();
		cardManager.inputPressed(inputValue);
		boolean isSelected = cardManager.getCard().isSelected();
		if (wasSelected != isSelected)
		{
			if (wasSelected)
			{
				cardManager.unselectCard();
				cardsToUnselect.add(0, cardManager);
			}
			else
			{
				cardManager.selectCard();
				cardsToSelect.add(0, cardManager);
			}
			cardManager.clearInputReaction();
			makeTransaction(cardsToUnselect, cardsToSelect);
		}
	}
	
	@Override
	public void doubleTapInput(InputEvent inputValue)
	{
		CardManager top = getTop();
		if (null != top)
		{
			top.doubleTapInput(inputValue);
			if (top.hasReactedToInput() && top.getCard().isSelected())
			{
				CardTransaction transaction = new CardTransaction(this);
				transaction.setUnselectedCards(new ArrayList<>());
				List<CardManager> selected = new ArrayList<>();
				selected.add(top);
				transaction.setSelectedCards(selected);
				transactionManager.addTransactionToFoundationsAttempt(transaction);
			}
		}
	}

	private void makeTransaction(List<CardManager> cardsToUnselect, List<CardManager> cardsToSelect)
	{
		if (null != transactionManager)
		{
			CardTransaction transaction = new CardTransaction(this);
			transaction.setUnselectedCards(cardsToUnselect);
			transaction.setSelectedCards(cardsToSelect);
			transactionManager.addTransaction(transaction);
		}
	}

}
