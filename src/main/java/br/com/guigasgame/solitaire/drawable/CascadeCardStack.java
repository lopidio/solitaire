package br.com.guigasgame.solitaire.drawable;

import org.jsfml.graphics.RenderTarget;

import br.com.guigasgame.solitaire.position.PositionComponent;
import br.com.guigasgame.solitaire.solitaire.card.CardManager;
import br.com.guigasgame.solitaire.solitaire.stack.SolitaireCardStack;

public class CascadeCardStack extends StackDrawable
{
	private PositionComponent drawingOffset;
	private PositionComponent center;
	private EmptyStackCardSprite emptyStackCardSprite;

	public CascadeCardStack(SolitaireCardStack cardStack, PositionComponent center, PositionComponent drawingOffset, boolean drawEmptyStack)
	{
		super(cardStack);
		this.center = center;
		cardStack.setCenter(center);
		this.drawingOffset = drawingOffset;
		for (int i = 0; i < cards.size(); ++i)
		{
			cards.get(i).getDrawableCard().moveTo(getCardPosition(i));
		}
		if (drawEmptyStack)
		{
			emptyStackCardSprite = new EmptyStackCardSprite();
			emptyStackCardSprite.moveTo(center);
		}
	}

	public CascadeCardStack(SolitaireCardStack cardStack, PositionComponent center, PositionComponent drawingOffset)
	{
		this(cardStack, center, drawingOffset, false);
	}
	
	@Override
	public PositionComponent getCardPosition(int index)
	{
		CardDrawable card = cards.get(index).getDrawableCard();
		PositionComponent initial = new PositionComponent(center.getX(), center.getY());
		initial.add(new PositionComponent(
										drawingOffset.getX() * card.getSize().width * index, 
										drawingOffset.getY() * card.getSize().height * index));
		return initial;
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
		int index= cards.size() - 1;
		cards.get(index).getDrawableCard().moveTo(getCardPosition(index));
	}
	
	@Override
	public void draw(RenderTarget renderTarget)
	{
		super.draw(renderTarget);
		if (cards.isEmpty() && null != emptyStackCardSprite)
			emptyStackCardSprite.draw(renderTarget);	
	}

}
