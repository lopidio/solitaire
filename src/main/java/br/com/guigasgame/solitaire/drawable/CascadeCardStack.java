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
		this.drawingOffset = new PositionComponent(.05f, .35f);
	}
	
	public void setDrawingOffset(PositionComponent drawingOffset)
	{
		this.drawingOffset = drawingOffset;
	}

	@Override
	public void adjustCardsPosition()
	{
		int cardIndex = 0;

		PositionComponent position = new PositionComponent(center.getX(), center.getY());
		for (CardDrawable card: cardDrawables)
		{
			position.add(new PositionComponent(drawingOffset.getX() * card.getSize().width * cardIndex, 
												drawingOffset.getY()*card.getSize().height * cardIndex));
			card.moveTo(position);
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
