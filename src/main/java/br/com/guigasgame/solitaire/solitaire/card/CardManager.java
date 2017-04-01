package br.com.guigasgame.solitaire.solitaire.card;

import java.util.ArrayList;
import java.util.List;

import org.jsfml.window.Mouse.Button;

import br.com.guigasgame.solitaire.drawable.CardDrawable;
import br.com.guigasgame.solitaire.input.InputEvent;
import br.com.guigasgame.solitaire.input.InputEventType;
import br.com.guigasgame.solitaire.input.InputListener;
import br.com.guigasgame.solitaire.input.MouseEvent;

public class CardManager implements InputListener
{
	private CardSolitaire card;
	private CardDrawable cardDrawable;
	private List<CardSolitaireListener> listeners;

	public CardManager(CardDrawable cardDrawable)
	{
		super();
		this.card = cardDrawable.getCard();
		this.cardDrawable = cardDrawable;
		listeners = new ArrayList<>();
		addCardListener(cardDrawable);
	}

	@Override
	public void inputPressed(InputEvent inputValue)
	{
		if (inputValue.getInputEventType() == InputEventType.mouse)
		{
			MouseEvent mouseEvent = (MouseEvent) inputValue;
			if (cardDrawable.contains(mouseEvent.getPosition().x, mouseEvent.getPosition().y))
			{
				if (mouseEvent.getMouseButton() == Button.LEFT)
				{
					if (card.isRevealed())
					{
						card.select();
						listeners.stream().forEach(listener -> listener.cardSelectAction(card));
					}
					else
					{
						if (card.isAtStackTop())
						{
							revealCard();
						}
					}
				}
				if (mouseEvent.getMouseButton() == Button.RIGHT && card.isRevealed())
				{
					cardDrawable.setPriorityDrawing(true);
				}
			}
			else
			{
				if (card.isSelected())
				{
					card.unselect();
					listeners.stream().forEach(listener -> listener.cardSelectAction(card));
				}
			}
		}
	}
	

	@Override
	public void inputReleased(InputEvent inputValue)
	{
		if (inputValue.getInputEventType() == InputEventType.mouse)
		{
			MouseEvent mouseEvent = (MouseEvent) inputValue;
			if (mouseEvent.getMouseButton() == Button.RIGHT)
			{
				cardDrawable.setPriorityDrawing(false);
			}
		}	
	}
	
	public void addCardListener(CardSolitaireListener listener)
	{
		listeners.add(listener);
	}

	public void removeCardListener(CardSolitaireListener listener)
	{
		listeners.remove(listener);
	}

	public CardDrawable getDrawableCard()
	{
		return cardDrawable;
	}

	public CardSolitaire getCard()
	{
		return card;
	}

	public void revealCard()
	{
		card.reveal();
		listeners.stream().forEach(listener -> listener.cardRevealAction(card));
	}


}
