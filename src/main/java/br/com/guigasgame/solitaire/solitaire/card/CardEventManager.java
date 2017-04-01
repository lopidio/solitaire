package br.com.guigasgame.solitaire.solitaire.card;

import java.util.ArrayList;
import java.util.List;

import org.jsfml.window.Mouse.Button;

import br.com.guigasgame.solitaire.drawable.CardDrawable;
import br.com.guigasgame.solitaire.input.InputEvent;
import br.com.guigasgame.solitaire.input.InputEventType;
import br.com.guigasgame.solitaire.input.InputListener;
import br.com.guigasgame.solitaire.input.MouseEvent;

public class CardEventManager implements InputListener
{
	private CardSolitaire card;
	private CardDrawable cardDrawable;
	private List<CardSolitaireListener> listeners;

	public CardEventManager(CardSolitaire card, CardDrawable cardDrawable)
	{
		super();
		this.card = card;
		this.cardDrawable = cardDrawable;
		listeners = new ArrayList<>();
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
							card.reveal();
					}
				}
				if (mouseEvent.getMouseButton() == Button.RIGHT)
				{
//					card.flip();
//					card.setVisualizeMode(false);
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
//				listeners.stream().forEach(listener -> listener.revealAction(card));

//				if (card.isRevealed() && !card.isAtStackTop())
//					card.revealed();
//				card.setVisualizeMode(true);
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


}
