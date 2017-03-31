package br.com.guigasgame.solitaire.stack;

import br.com.guigasgame.solitaire.card.Card;

public interface CardStackListener
{
	void cardRemoved(Card card);
	void cardAdded(Card card);

}
