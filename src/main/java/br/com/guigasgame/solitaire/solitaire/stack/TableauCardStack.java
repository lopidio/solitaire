package br.com.guigasgame.solitaire.solitaire.stack;

import java.util.ArrayList;
import java.util.List;

import org.jsfml.graphics.FloatRect;
import org.jsfml.window.Mouse.Button;

import br.com.guigasgame.solitaire.card.Rank;
import br.com.guigasgame.solitaire.drawable.EmptyStackCardSprite;
import br.com.guigasgame.solitaire.input.InputEvent;
import br.com.guigasgame.solitaire.input.InputEventType;
import br.com.guigasgame.solitaire.input.InputListener;
import br.com.guigasgame.solitaire.input.MouseEvent;
import br.com.guigasgame.solitaire.position.PositionComponent;
import br.com.guigasgame.solitaire.solitaire.card.CardManager;
import br.com.guigasgame.solitaire.solitaire.card.CardSolitaire;
import br.com.guigasgame.solitaire.transaction.CardTransaction;

public class TableauCardStack extends SolitaireCardStack implements InputListener
{
	
	private FloatRect stackArea;

	public TableauCardStack(List<CardManager> cards)
	{
		super(SolitaireCardStackType.tableau);
		
		cards.stream().forEach(card ->
		{
			addCard(card);
		});
		
		stackArea = new FloatRect(0f, 0f, (float) (new EmptyStackCardSprite().getSize().width*2),
				(float) (new EmptyStackCardSprite().getSize().height*5));
		
		cards.get(cards.size() - 1).revealCard();
	}

	@Override
	public boolean canAddCards(List<CardManager> cardsToAdd)
	{
		CardManager card = cardsToAdd.get(0);
		if (cards.isEmpty())
		{
			return card.getCard().getRank() == Rank.king;
		}
		
		CardSolitaire cardAtTop = getSolitaireTop().getCard();
		if (card.getCard().getRank().getValue() == cardAtTop.getRank().getValue() - 1)
		{
			return card.getCard().getSuit().getSuitColor() != cardAtTop.getSuit().getSuitColor();
		}
		return false;
	}
	
	public void inputPressed(InputEvent inputValue)
	{
		List<CardManager> cardsToUnselect = new ArrayList<>();
		List<CardManager> cardsToSelect = new ArrayList<>();
		boolean unselecting = false;
		for (int i = cards.size() - 1; i >= 0; --i)
		{
			CardManager cardManager = cards.get(i);
			boolean wasSelected = cardManager.getCard().isSelected();
			if (unselecting)
			{
				if (!wasSelected && !cardManager.getCard().isSelected())
					break;
				cardManager.unselectCard();
				cardsToUnselect.add(0, cardManager);
			}
			else
			{
				cardManager.inputPressed(inputValue);
				if (cardManager.getCard().isSelected() && cardManager.hasReactedToInput())
				{
					cardsToSelect = selectFromIndexToTop(i);
					unselecting = true;
				}
				else if (!wasSelected && !cardManager.getCard().isSelected())
					continue;
				else if (null != transactionManager && cardManager.hasReactedToInput())
					cardsToUnselect.add(0, cardManager);
			}
			cardManager.clearInputReaction();
		}
		
		boolean stackClicked = checkClickInStack(inputValue);

		makeTransaction(cardsToUnselect, cardsToSelect, stackClicked);
	}
	
	@Override
	public void doubleTapInput(InputEvent inputValue)
	{
		CardManager top = getTop();
		if (null != top)
		{
			top.doubleTapInput(inputValue);
			if (top.hasReactedToInput())
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

	private boolean checkClickInStack(InputEvent inputValue)
	{
		if (inputValue.getInputEventType() == InputEventType.mouse)
		{
			MouseEvent mouseEvent = (MouseEvent) inputValue;
			if (stackArea.contains(mouseEvent.getPosition().x, mouseEvent.getPosition().y))
			{
				if (mouseEvent.getMouseButton() == Button.LEFT)
				{
					return true;
				}
			}
		}
		return false;
	}

	private void makeTransaction(List<CardManager> cardsToUnselect, List<CardManager> cardsToSelect, boolean stackClicked)
	{
		if (null != transactionManager)
			if (stackClicked || cardsToSelect.size() > 0 || cardsToUnselect.size() > 0)
			{
				CardTransaction transaction = new CardTransaction(this);
				transaction.setUnselectedCards(cardsToUnselect);
				transaction.setSelectedCards(cardsToSelect);
				transactionManager.addTransaction(transaction);
			}
	}

	private List<CardManager> selectFromIndexToTop(int initialIndex)
	{
		List<CardManager> cardsToSelect = new ArrayList<>();
		for (int i = initialIndex; i < cards.size(); ++i)
		{
			cards.get(i).selectCard();
			cardsToSelect.add(cards.get(i));
		}
		return cardsToSelect;
	}

	public void inputReleased(InputEvent inputValue)
	{
		cards.stream().forEach(cardManager -> cardManager.inputReleased(inputValue));
	}
	
	@Override
	public void setCenter(PositionComponent center)
	{
		super.setCenter(center);
		stackArea = new FloatRect(center.getX() - stackArea.width/2, center.getY() - (new EmptyStackCardSprite().getSize().height)/2, stackArea.width, stackArea.height);
	}
	
}
