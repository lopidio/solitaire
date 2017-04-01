package br.com.guigasgame.solitaire.drawable;

import java.util.ArrayList;
import java.util.List;

import org.jsfml.graphics.RenderTarget;

import br.com.guigasgame.solitaire.solitaire.card.CardManager;
import br.com.guigasgame.solitaire.stack.CardStackListener;

public abstract class StackDrawable implements Drawable, CardStackListener
{
	private CardDrawable priority;
	protected List<CardDrawable> cards;
	
	public StackDrawable(List<CardManager> cardManagers)
	{
		cards = new ArrayList<>();
		cardManagers.stream().forEach(card -> cards.add(card.getDrawableCard()));
	}

	@Override
	public void draw(RenderTarget renderTarget)
	{
		priority = null;

		cards.stream().forEach(card -> 
			{
				if (card.isPriorityDrawing())
					priority = card;
				card.draw(renderTarget);	
			});
		if (null != priority)
			priority.draw(renderTarget);
	}
	
	abstract protected void adjustCardsPosition();
	
	
}
