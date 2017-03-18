package br.com.guigasgame.solitaire.gameObject;

import org.jsfml.graphics.FloatRect;
import org.jsfml.graphics.RenderTarget;

import br.com.guigasgame.solitaire.card.Card;
import br.com.guigasgame.solitaire.drawable.CardSprite;
import br.com.guigasgame.solitaire.drawable.Drawable;
import br.com.guigasgame.solitaire.position.PositionComponent;

public class CardGameObject implements Drawable
{
	private CardSprite cardSprite;
	private Card card;
	private boolean revealed;
	private boolean holded;

	public CardGameObject(Card card, PositionComponent positionComponent)
	{
		super();
		this.card = card;
		this.revealed = false;
		cardSprite = new CardSprite(card);
		cardSprite.setPosition(positionComponent);
	}
	
	public Card getCard()
	{
		return card;
	}

	public boolean isRevealed()
	{
		return revealed;
	}

	public void flip()
	{
		revealed = !revealed;
	}

	public boolean isHolded()
	{
		return holded;
	}

	public boolean isOverOtherCard(CardGameObject otherCardGameObject)
	{
		FloatRect intersection = cardSprite.getSprite().getGlobalBounds().
					intersection(otherCardGameObject.getCardSprite().getSprite().getGlobalBounds());
		if (intersection != null)
			return intersection.width > 0 || intersection.height > 0;
		return false;
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
}
