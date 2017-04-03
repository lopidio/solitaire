package br.com.guigasgame.solitaire.solitaire.stack;

import java.util.List;

import br.com.guigasgame.solitaire.card.Rank;
import br.com.guigasgame.solitaire.input.InputEvent;
import br.com.guigasgame.solitaire.input.InputListener;
import br.com.guigasgame.solitaire.solitaire.card.CardManager;
import br.com.guigasgame.solitaire.solitaire.card.CardSolitaire;

public class TableauCardStack extends SolitaireCardStack implements InputListener
{
	protected List<CardManager> cardManagers;

	public TableauCardStack(List<CardManager> cardManagers)
	{
		super(SolitaireCardStackType.tableau);
		this.cardManagers = cardManagers;
		
		cardManagers.stream().forEach(card ->
		{
			addCard(card.getCard());
			card.revealCard();
		});
		
		cardManagers.get(cardManagers.size() - 1).revealCard();
	}

	public boolean canAddSolitaireCard(CardSolitaire card)
	{
		if (cards.isEmpty())
		{
			return card.getRank() == Rank.king;
		}
		
		CardSolitaire cardAtTop = getSolitaireTop();
		if (card.getRank().getValue() == cardAtTop.getRank().getValue() - 1)
		{
			return card.getSuit().getSuitColor() != cardAtTop.getSuit().getSuitColor();
		}
		return false;
	}
	
	public void inputPressed(InputEvent inputValue)
	{
		boolean unselecting = false;
		for (int i = cardManagers.size() - 1; i >= 0; --i)
		{
			CardManager cardManager = cardManagers.get(i);
			if (unselecting)
			{
				cardManager.unselectCard();
				if (null != transactionManager)
					transactionManager.removeCardToSelection(cardManagers.get(i));
			}
			else
			{
				cardManager.inputPressed(inputValue);
				if (cardManager.getCard().isSelected())
				{
					selectFromIndexToTop(i);
					unselecting = true;
				}
				else
				{
					if (null != transactionManager)
						transactionManager.removeCardToSelection(cardManagers.get(i));
				}
			}
		}
	}

	private void selectFromIndexToTop(int initialIndex)
	{
		for (int i = initialIndex; i < cardManagers.size(); ++i)
		{
			cardManagers.get(i).selectCard();
			if (null != transactionManager)
				transactionManager.addCardToSelection(cardManagers.get(i));
		}
	}

	public void inputReleased(InputEvent inputValue)
	{
		cardManagers.stream().forEach(cardManager -> cardManager.inputReleased(inputValue));
	}

	public void isPressing(InputEvent inputValue)
	{

	}


}
