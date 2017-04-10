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

public class FoundationCardStack extends SolitaireCardStack implements InputListener
{

	private FloatRect stackArea;

	public FoundationCardStack()
	{
		super(SolitaireCardStackType.foundation);
		stackArea = new FloatRect(0f, 0f, (float) (new EmptyStackCardSprite().getSize().width*1.2),
				(float) (new EmptyStackCardSprite().getSize().height));

	}

	public void inputPressed(InputEvent inputValue)
	{
		if (cards.isEmpty())
		{
			if (checkClickInStack(inputValue))
				makeTransaction(new ArrayList<>(), new ArrayList<>());
		}
		else //if (cards.size() > 0)
		{
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

	@Override
	public boolean canAddCards(List<CardManager> cardsToAdd)
	{
		if (cardsToAdd.size() != 1)
			return false;
		CardManager topCardToAdd = cardsToAdd.get(0);
		if (topCardToAdd.getCard().getStack().getStackType() == SolitaireCardStackType.stock)
			return false;
		if (cards.isEmpty())
			return topCardToAdd.getCard().getRank() == Rank.ace && topCardToAdd.getCard().getStack().getStackType() != SolitaireCardStackType.foundation;
	
		CardSolitaire myCardAtTop = getSolitaireTop().getCard();
		if (topCardToAdd.getCard().getRank().getValue() == myCardAtTop.getRank().getValue() + 1)
		{
			return topCardToAdd.getCard().getSuit() == myCardAtTop.getSuit();
		}
		return false;
	}

	@Override
	public void setCenter(PositionComponent center)
	{
		super.setCenter(center);
		stackArea = new FloatRect(center.getX() - stackArea.width/2, center.getY() - stackArea.height/2, stackArea.width, stackArea.height);
	}
}
