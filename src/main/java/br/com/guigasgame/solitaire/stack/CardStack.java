package br.com.guigasgame.solitaire.stack;

import br.com.guigasgame.solitaire.solitaire.card.CardManager;

public interface CardStack
{
	CardManager getTop();
	boolean canAddCard(CardManager card);
	boolean addCard(CardManager card);
	CardManager removeCard();
	int getSize();
}
