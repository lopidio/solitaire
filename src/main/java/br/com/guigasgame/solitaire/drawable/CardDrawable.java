package br.com.guigasgame.solitaire.drawable;

import org.jsfml.graphics.FloatRect;

import br.com.guigasgame.solitaire.position.PositionComponent;
import br.com.guigasgame.solitaire.solitaire.card.CardSolitaire;
import br.com.guigasgame.solitaire.solitaire.card.CardSolitaireListener;

public interface CardDrawable extends Drawable, CardSolitaireListener
{
	public void setPosition(PositionComponent positionComponent);

	public boolean contains(int x, int y);

	public FloatRect getSize();

	public void moveTo(PositionComponent position);

	public CardSolitaire getCard();

	public boolean isPriorityDrawing();

	public void setPriorityDrawing(boolean priorityDrawing);

}
