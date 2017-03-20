package br.com.guigasgame.solitaire.solitaire;

import org.jsfml.graphics.FloatRect;
import org.jsfml.graphics.RenderTarget;
import org.jsfml.window.Mouse.Button;

import br.com.guigasgame.solitaire.card.Card;
import br.com.guigasgame.solitaire.drawable.CardSprite;
import br.com.guigasgame.solitaire.drawable.Drawable;
import br.com.guigasgame.solitaire.input.InputEvent;
import br.com.guigasgame.solitaire.input.InputEventType;
import br.com.guigasgame.solitaire.input.InputListener;
import br.com.guigasgame.solitaire.input.MouseEvent;
import br.com.guigasgame.solitaire.position.PositionComponent;
import br.com.guigasgame.solitaire.updatable.TimeUpdatable;

public class SolitaireCard implements Drawable, InputListener, TimeUpdatable
{
	private CardSprite cardSprite;
	private Card card;
	private boolean selected;
	private boolean atStackTop;
	private boolean visualizeMode;

	public SolitaireCard(Card card)
	{
		super();
		this.card = card;
		cardSprite = new CardSprite(card);
		atStackTop = false;
	}
	
	public Card getCard()
	{
		return card;
	}

	public boolean isRevealed()
	{
		return cardSprite.isRevealed();
	}

	public void flip()
	{
		cardSprite.flip();
	}

	public boolean isSelected()
	{
		return selected;
	}

	@Override
	public void draw(RenderTarget renderTarget)
	{
		cardSprite.draw(renderTarget);
	}

	public CardSprite getCardSprite()
	{
		return cardSprite;
	}

	public void moveTo(PositionComponent position)
	{
		//TODO create interpolator
		cardSprite.setPosition(position);
	}

	public FloatRect getSize()
	{
		return cardSprite.getSprite().getLocalBounds();
	}

	@Override
	public void inputPressed(InputEvent inputValue)
	{
		if (inputValue.getInputEventType() == InputEventType.mouse)
		{
			MouseEvent mouseEvent = (MouseEvent) inputValue;
			System.out.println(mouseEvent.getMouseButton());
			if (cardSprite.getSprite().getGlobalBounds().contains(mouseEvent.getPosition().x, mouseEvent.getPosition().y))
			{
				if (mouseEvent.getMouseButton() == Button.LEFT)
				{
					if (cardSprite.isRevealed())
					{
						if (cardSprite.isSelected())
							cardSprite.unselect();
						else
							cardSprite.select();
					}
				}
				if (mouseEvent.getMouseButton() == Button.RIGHT)
				{
					visualizeMode = true;
				}
			}
			else
			{
				if (cardSprite.isRevealed())
				{
					if (cardSprite.isSelected())
						cardSprite.unselect();
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
				visualizeMode = false;
			}
		}	
	}

	public void setIsAtStackTop(boolean value)
	{
		atStackTop = value;
	}

	@Override
	public void update(float deltaTime)
	{
		
	}

	public boolean isVisualizeModeActive()
	{
		return visualizeMode;
	}

	public boolean isAtStackTop()
	{
		return atStackTop;
	}

}
