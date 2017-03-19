package br.com.guigasgame.solitaire.solitaire;

import org.jsfml.graphics.RenderTarget;

import br.com.guigasgame.solitaire.card.Card;
import br.com.guigasgame.solitaire.drawable.CardSprite;
import br.com.guigasgame.solitaire.drawable.Drawable;
import br.com.guigasgame.solitaire.position.PositionComponent;

public class SolitaireCard implements Drawable
{
	private CardSprite cardSprite;
	private Card card;
	private boolean revealed;
	private boolean selected;

	public SolitaireCard(Card card, PositionComponent positionComponent)
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
}
