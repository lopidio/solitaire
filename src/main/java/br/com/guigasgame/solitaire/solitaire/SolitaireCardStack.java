package br.com.guigasgame.solitaire.solitaire;

import java.util.ArrayList;
import java.util.List;

import br.com.guigasgame.solitaire.drawable.Drawable;
import br.com.guigasgame.solitaire.position.PositionComponent;
import br.com.guigasgame.solitaire.stack.CardStack;

public abstract class SolitaireCardStack implements CardStack, Drawable
{
	protected List<SolitaireCard> cards;
	protected int yDrawingOffset;

	public SolitaireCardStack()
	{
		this.cards = new ArrayList<>();
		yDrawingOffset = 0;
	}

	@Override
	public SolitaireCard getCardGameObjectAtTop()
	{
		if (cards.size() > 0)
			return cards.get(cards.size() - 1);
		return null;
	}
	
	@Override
	public boolean addCard(SolitaireCard card)
	{
		if (canAddNewCard(card))
		{
			adjustCardPosition(card, cards.size());
			cards.add(card);
		}
		return false;
	}

	protected void adjustCardPosition(SolitaireCard card, int cardPosition)
	{
		PositionComponent currentPosition = card.getCardSprite().getPosition();
		currentPosition.move(new PositionComponent(0, yDrawingOffset*cardPosition));
		card.getCardSprite().setPosition(currentPosition);
		System.out.println(card.getCardSprite().getPosition().getPosition());
	}


}
