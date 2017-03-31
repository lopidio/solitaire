package br.com.guigasgame.solitaire.stack;

import br.com.guigasgame.solitaire.card.Card;

public interface CardStack
{
	Card getTop();
	boolean canAddCard(Card card);
	boolean addCard(Card card);
	Card removeCard();
	int getSize();
}
