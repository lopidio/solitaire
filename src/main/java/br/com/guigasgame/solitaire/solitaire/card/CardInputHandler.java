package br.com.guigasgame.solitaire.solitaire.card;

import org.jsfml.window.Mouse.Button;

import br.com.guigasgame.solitaire.drawable.CardDrawable;
import br.com.guigasgame.solitaire.input.InputEvent;
import br.com.guigasgame.solitaire.input.InputEventType;
import br.com.guigasgame.solitaire.input.InputListener;
import br.com.guigasgame.solitaire.input.MouseEvent;

public class CardInputHandler implements InputListener
{
	CardSolitaire card;
	private CardDrawable cardDrawable;

	public CardInputHandler(CardSolitaire card, CardDrawable cardDrawable)
	{
		super();
		this.card = card;
		this.cardDrawable = cardDrawable;
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
						card.select();
					else
						card.reveal();
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
					card.unselect();
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
//				if (card.isRevealed() && !card.isAtStackTop())
//					card.revealed();
//				card.setVisualizeMode(true);
			}
		}	
	}

}
