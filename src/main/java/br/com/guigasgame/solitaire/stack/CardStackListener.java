package br.com.guigasgame.solitaire.stack;

import br.com.guigasgame.solitaire.solitaire.card.CardManager;

public interface CardStackListener
{
	void cardRemoved(CardManager card);
	void cardAdded(CardManager card);

}
