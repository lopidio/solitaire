package br.com.guigasgame.solitaire.solitaire;

import org.jsfml.graphics.FloatRect;
import org.jsfml.graphics.RenderTarget;

import br.com.guigasgame.solitaire.card.Card;
import br.com.guigasgame.solitaire.drawable.CardSprite;
import br.com.guigasgame.solitaire.drawable.Drawable;
import br.com.guigasgame.solitaire.position.PositionComponent;

public class SolitaireCard implements Drawable
{
	private CardSprite cardSprite;
	private Card card;
	private boolean selected;

	public SolitaireCard(Card card)
	{
		super();
		this.card = card;
		cardSprite = new CardSprite(card);
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
}
