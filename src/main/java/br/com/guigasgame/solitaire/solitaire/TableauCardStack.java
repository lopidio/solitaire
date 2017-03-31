package br.com.guigasgame.solitaire.solitaire;

import java.util.List;

import org.jsfml.graphics.RenderTarget;

import br.com.guigasgame.solitaire.card.Rank;
import br.com.guigasgame.solitaire.drawable.CardSprite;
import br.com.guigasgame.solitaire.input.InputListener;
import br.com.guigasgame.solitaire.position.PositionComponent;

public class SolitaireWorkspaceCardStack extends SolitaireCardStack implements InputListener, SolitaireCardListener
{

	public SolitaireWorkspaceCardStack(List<SolitaireCard> cards, PositionComponent positionComponent)
	{
		this.cards = cards;
		this.yDrawingOffset = 0.35;
		int i = 0;
		for (SolitaireCard solitaireCard : cards)
		{
			solitaireCard.addListener(this);
			solitaireCard.setStack(this);
			CardSprite cardSprite = solitaireCard.getCardSprite();
			cardSprite.setPosition(positionComponent);
			adjustCardPosition(solitaireCard, ++i);
		}
		SolitaireCard cardAtTop = getCardGameObjectAtTop();
		if (cardAtTop != null)
		{
			cardAtTop.flip();
			cardAtTop.setIsAtStackTop(true);
		}
	}

	@Override
	public void draw(RenderTarget renderTarget)
	{
		SolitaireCard visualizeCard = null;
		for (SolitaireCard solitaireCard : cards)
		{
			if (solitaireCard.isVisualizeModeActive())
				visualizeCard = solitaireCard;
			solitaireCard.draw(renderTarget);
		}
		if (visualizeCard != null)
			visualizeCard.draw(renderTarget);
	}

	@Override
	public boolean canAddNewCard(SolitaireCard card)
	{
		if (cards.isEmpty())
		{
			return card.getCard().getRank() == Rank.king;
		}
		
		SolitaireCard cardAtTop = getCardGameObjectAtTop();
		if (card.getCard().getRank().getValue() == cardAtTop.getCard().getRank().getValue() - 1)
		{
			return card.getCard().getSuit().getSuitColor() != cardAtTop.getCard().getSuit().getSuitColor();
		}
		return false;
	}

	@Override
	public void cardSelected(SolitaireCard card)
	{
		if (!card.isAtStackTop())
			cards.get(cards.indexOf(card) + 1).select();
	}

	@Override
	public void cardUnselected(SolitaireCard card)
	{
		if (!card.isAtStackTop())
			cards.get(cards.indexOf(card) + 1).unselect();
	}

	@Override
	public boolean addCard(SolitaireCard card)
	{
		card.addListener(this);
		return super.addCard(card);
	}

	@Override
	public SolitaireCard removeCardAtTop()
	{
		if (!cards.isEmpty())
			getCardGameObjectAtTop().removeListener(this);
		return super.removeCardAtTop();
	}
	
	

}
