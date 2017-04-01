package br.com.guigasgame.solitaire.drawable;

import java.util.List;

import br.com.guigasgame.solitaire.card.Card;
import br.com.guigasgame.solitaire.position.PositionComponent;

public class CascadeCardStack extends StackDrawable
{
	private PositionComponent drawingOffset;
	private PositionComponent center;

	public CascadeCardStack(List<CardDrawable> cardDrawables, PositionComponent center)
	{
		super(cardDrawables);
		this.center = center;
		this.drawingOffset = new PositionComponent(.01f, .35f);
	}
	
	@Override
	public void adjustCardsPosition()
	{
		int cardIndex = 0;

		for (CardDrawable card: cardDrawables)
		{
			PositionComponent initial = new PositionComponent(center.getX(), center.getY());
			initial.add(new PositionComponent(card.getSize().width * drawingOffset.getX(), 
											drawingOffset.getY() * card.getSize().height * cardIndex));
			card.moveTo(initial);
			++cardIndex;
		}
	}

	@Override
	public void cardRemoved(Card card)
	{
		adjustCardsPosition();
	}

	@Override
	public void cardAdded(Card card)
	{
		adjustCardsPosition();
	}

}
