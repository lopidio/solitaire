package br.com.guigasgame.solitaire.solitaire.stack;

import java.util.ArrayList;
import java.util.List;

import org.jsfml.graphics.FloatRect;
import org.jsfml.window.Mouse.Button;

import br.com.guigasgame.solitaire.input.InputEvent;
import br.com.guigasgame.solitaire.input.InputEventType;
import br.com.guigasgame.solitaire.input.InputListener;
import br.com.guigasgame.solitaire.input.MouseEvent;
import br.com.guigasgame.solitaire.position.PositionComponent;
import br.com.guigasgame.solitaire.solitaire.card.CardManager;
import br.com.guigasgame.solitaire.transaction.CardTransaction;

public class StockCardStack extends SolitaireCardStack implements InputListener
{
	private WasteCardStack waste;
	private FloatRect stackArea;
	
	public StockCardStack(List<CardManager> cards, WasteCardStack waste)
	{
		super(SolitaireCardStackType.stock);
		this.waste = waste;
		
		cards.stream().forEach(card ->
		{
			addCard(card);
		});
		stackArea = cards.get(0).getDrawableCard().getSize();
	}
	
	@Override
	public boolean canAddCards(List<CardManager> cards)
	{
		if (this.cards.isEmpty() && cards.size() == cards.get(0).getCard().getStack().getCards().size())
		{
			return cards.get(0).getCard().getStack().getStackType() == SolitaireCardStackType.waste;
		}
		return false;
	}
	
	@Override
	public void setCenter(PositionComponent center)
	{
		super.setCenter(center);
		stackArea = new FloatRect(center.getX() - stackArea.width/2, center.getY() - stackArea.height/2, stackArea.width, stackArea.height);
	}
	
	public void inputPressed(InputEvent inputValue)
	{
		if (cards.isEmpty())
		{
			if (checkClickInStack(inputValue))
			{
				receiveAllWasteCards();
			}
		}
		else
		{
			sendCardToWasteStack(inputValue);
		}
	}

	private void receiveAllWasteCards()
	{
		CardTransaction from = new CardTransaction(waste);
		
		List<CardManager> copy = waste.getCards().subList(0, waste.getCards().size());
		from.setUnselectedCards(copy);
		transactionManager.addTransaction(from);
		
		transactionManager.addTransaction(new CardTransaction(this));
	}

	private void sendCardToWasteStack(InputEvent inputValue)
	{
		CardManager cardManager = cards.get(cards.size() - 1);
		System.out.println("Stock top card: " + cardManager.getCard());
		cardManager.inputPressed(inputValue);
		if (cardManager.getCard().isRevealed())
		{
			CardTransaction from = new CardTransaction(this);
			List<CardManager> unselectedCards = new ArrayList<>();
			unselectedCards.add(cardManager);
			from.setUnselectedCards(unselectedCards);
			transactionManager.addTransaction(from);
			
			transactionManager.addTransaction(new CardTransaction(waste));
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
	
	@Override
	public boolean addCard(CardManager card)
	{
		card.unrevealCard();
		return super.addCard(card);
	}

}
