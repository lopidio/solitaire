package br.com.guigasgame.solitaire.drawable;

import java.util.ArrayList;
import java.util.List;

import org.jsfml.graphics.RenderTarget;

import br.com.guigasgame.solitaire.solitaire.card.CardManager;
import br.com.guigasgame.solitaire.solitaire.stack.SolitaireCardStack;
import br.com.guigasgame.solitaire.stack.CardStackListener;

public abstract class StackDrawable implements Drawable, CardStackListener
{
	private CardDrawable prioritaireVisibilityCard;
	protected List<CardManager> cards;
	
	public StackDrawable(SolitaireCardStack cardStack)
	{
		cards = new ArrayList<>();
		cardStack.getCards().stream().forEach(card -> cards.add(card));
	}

	@Override
	public void draw(RenderTarget renderTarget)
	{
		prioritaireVisibilityCard = null;

		cards.stream().forEach(card -> 
			{
				if (card.getDrawableCard().isPriorityDrawing())
					prioritaireVisibilityCard = card.getDrawableCard();
				card.getDrawableCard().draw(renderTarget);	
			});
		if (null != prioritaireVisibilityCard)
			prioritaireVisibilityCard.draw(renderTarget);
	}
	
	abstract protected void adjustCardPosition(int index);
	
	
}
