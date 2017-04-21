package br.com.guigasgame.solitaire.drawable;

import org.jsfml.graphics.FloatRect;

import br.com.guigasgame.solitaire.position.PositionComponent;
import br.com.guigasgame.solitaire.solitaire.card.CardSolitaire;

public interface CardDrawable extends Drawable
{
	public void setPosition(PositionComponent positionComponent);

	public boolean contains(int x, int y);

	public FloatRect getSize();

	public void slideToPosition(PositionComponent position);

	public CardSolitaire getCard();

	public boolean isPriorityDrawing();

	public void setPriorityDrawing(boolean priorityDrawing);

	public void reveal();

	public void select();

	public void unselect();

	public void unreveal();

	public void moveTo(PositionComponent newPosition, float slowFactor);

	public boolean isNotMoving();

}
