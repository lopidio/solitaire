package br.com.guigasgame.solitaire.solitaire.stack;

import java.util.List;

import org.jsfml.graphics.FloatRect;
import org.jsfml.window.Mouse.Button;

import br.com.guigasgame.solitaire.input.InputEvent;
import br.com.guigasgame.solitaire.input.InputEventType;
import br.com.guigasgame.solitaire.input.InputListener;
import br.com.guigasgame.solitaire.input.MouseEvent;
import br.com.guigasgame.solitaire.position.PositionComponent;
import br.com.guigasgame.solitaire.solitaire.card.CardManager;

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

//		cards.get(cards.size() - 1).revealCard();
		stackArea = cards.get(0).getDrawableCard().getSize();
	}
	
	@Override
	public boolean canAddCards(List<CardManager> cards)
	{
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
				while (!waste.getCards().isEmpty())
				{
					addCard(waste.removeCard());
				}
			}
		}
		else
		{
			CardManager cardManager = cards.get(cards.size() - 1);
			cardManager.inputPressed(inputValue);
			if (cardManager.getCard().isRevealed())
			{
				waste.addCard(cardManager);
				cardManager.unselectCard();
				removeCard();
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

}
