package br.com.guigasgame.solitaire.drawable;

import java.util.List;

import org.jsfml.graphics.RenderTarget;

import br.com.guigasgame.solitaire.stack.CardStackListener;

public abstract class StackDrawable implements Drawable, CardStackListener
{
	protected List<CardDrawable> cardDrawables;
	
	public StackDrawable(List<CardDrawable> cardDrawables)
	{
		this.cardDrawables = cardDrawables;
	}

	@Override
	public void draw(RenderTarget renderTarget)
	{
		cardDrawables.stream().forEach(card -> card.draw(renderTarget));
	}
	
	abstract protected void adjustCardsPosition();

}
