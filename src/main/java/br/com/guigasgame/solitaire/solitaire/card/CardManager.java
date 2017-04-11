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
	private boolean reactedToInput;

	public CardManager(CardSolitaire card)
	{
		super();
		this.card = card;
		this.cardDrawable = new CardSprite(card);
	}

	@Override
	public void inputPressed(InputEvent inputValue)
	{
		//TODO deattach from specific inputs 
		if (inputValue.getInputEventType() == InputEventType.mouse)
		{
			MouseEvent mouseEvent = (MouseEvent) inputValue;
			if (cardDrawable.contains(mouseEvent.getPosition().x, mouseEvent.getPosition().y))
			{
				reactedToInput = true;
				if (mouseEvent.getMouseButton() == Button.LEFT)
					selectInput();
				if (mouseEvent.getMouseButton() == Button.RIGHT)
					makeVisibleInput();
			}
			else if (card.isSelected() && mouseEvent.getMouseButton() == Button.LEFT)
			{
				reactedToInput = true;
				unselectCard();
			}
		}
	}
	
	@Override
	public void doubleTapInput(InputEvent inputValue)
	{
		if (inputValue.getInputEventType() == InputEventType.mouse)
		{
			MouseEvent mouseEvent = (MouseEvent) inputValue;
			if (cardDrawable.contains(mouseEvent.getPosition().x, mouseEvent.getPosition().y))
			{
				reactedToInput = true;
			}
		}
	}

	private void makeVisibleInput()
	{
		if (!cardDrawable.isPriorityDrawing())
		{
			cardDrawable.setPriorityDrawing(true);
		}
	}

	private void selectInput()
	{
		if (card.isRevealed())
		{
			if (!card.isSelected())
			{
				selectCard();
			}
		}
		else if (card.isAtStackTop())
		{
			if (!card.isRevealed())
			{
				revealCard();
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
				if (cardDrawable.isPriorityDrawing())
				{
					cardDrawable.setPriorityDrawing(false);
				}
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
	
	public boolean hasReactedToInput()
	{
		return reactedToInput;
	}

	public void clearInputReaction()
	{
		reactedToInput = false;;
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

	public void unrevealCard()
	{
		card.unreveal();
		cardDrawable.unreveal();
	}

	public boolean isRevealed()
	{
		return card.isRevealed();
	}
	
}
