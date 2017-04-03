package br.com.guigasgame.solitaire.solitaire.card;

import org.jsfml.window.Mouse.Button;

import br.com.guigasgame.solitaire.drawable.CardDrawable;
import br.com.guigasgame.solitaire.drawable.CardSprite;
import br.com.guigasgame.solitaire.input.InputEvent;
import br.com.guigasgame.solitaire.input.InputEventType;
import br.com.guigasgame.solitaire.input.InputListener;
import br.com.guigasgame.solitaire.input.MouseEvent;

public class CardManager implements InputListener
{
	private CardSolitaire card;
	private CardDrawable cardDrawable;

	public CardManager(CardSolitaire card)
	{
		super();
		this.card = card;
		this.cardDrawable = new CardSprite(card);
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
						selectCard();
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
					unselectCard();
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
		cardDrawable.reveal();
	}

	public void selectCard()
	{
		card.select();
		cardDrawable.select();
	}

	public void unselectCard()
	{
		card.unselect();
		cardDrawable.unselect();
	}
	
	@Override
	public boolean equals(Object obj)
	{
		if (obj == null)
		{
			return false;
		}
		if (!CardManager.class.isAssignableFrom(obj.getClass()))
		{
			return false;
		}
		final CardManager other = (CardManager) obj;
		if ((this.card == null) ? (other.card != null) : !this.card.equals(other.card))
		{
			return false;
		}
		return true;
	}

}
