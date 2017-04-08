package br.com.guigasgame.solitaire.drawable;

import br.com.guigasgame.solitaire.position.PositionComponent;
import br.com.guigasgame.solitaire.solitaire.card.CardManager;
import br.com.guigasgame.solitaire.solitaire.stack.SolitaireCardStack;

public class CascadeCardStack extends StackDrawable
{
	private PositionComponent drawingOffset;
	private PositionComponent center;

	public CascadeCardStack(SolitaireCardStack cardStack, PositionComponent center)
	{
		super(cardStack);
		this.center = center;
		cardStack.setCenter(center);
		this.drawingOffset = new PositionComponent(.05f, .35f);
		for (int i = 0; i < cards.size(); ++i)
			adjustCardPosition(i);
	}
	
	@Override
	public void adjustCardPosition(int index)
	{
		CardDrawable card = cards.get(index).getDrawableCard();
		PositionComponent initial = new PositionComponent(center.getX(), center.getY());
		initial.add(new PositionComponent(
										drawingOffset.getX() * card.getSize().width * index, 
										drawingOffset.getY() * card.getSize().height * index));
		card.moveTo(initial);
	}

	@Override
	public void cardRemoved(CardManager card)
	{
		cards.remove(card);
	}

	@Override
	public void cardAdded(CardManager card)
	{
		cards.add(card);
		adjustCardPosition(cards.size() - 1);
	}

}
