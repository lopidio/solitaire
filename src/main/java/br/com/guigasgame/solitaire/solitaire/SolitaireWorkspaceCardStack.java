package br.com.guigasgame.solitaire.solitaire;

import java.util.List;

import org.jsfml.graphics.RenderTarget;

import br.com.guigasgame.solitaire.card.Rank;
import br.com.guigasgame.solitaire.drawable.CardSprite;
import br.com.guigasgame.solitaire.position.PositionComponent;

public class SolitaireWorkspaceCardStack extends SolitaireCardStack
{

	public SolitaireWorkspaceCardStack(List<SolitaireCard> cards, PositionComponent positionComponent)
	{
		this.cards = cards;
		this.yDrawingOffset = 40;
		int i = 0;
		for (SolitaireCard solitaireCard : cards)
		{
			CardSprite cardSprite = solitaireCard.getCardSprite();
			cardSprite.setPosition(positionComponent);
			adjustCardPosition(solitaireCard, ++i);
		}
		SolitaireCard cardAtTop = getCardGameObjectAtTop();
		if (cardAtTop != null)
			cardAtTop.flip();
	}

	@Override
	public void draw(RenderTarget renderTarget)
	{
		for (SolitaireCard solitaireCard : cards)
		{
			solitaireCard.draw(renderTarget);
		}
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
	public SolitaireCard removeCardAtTop()
	{
		// TODO Auto-generated method stub
		return null;
	}

}
