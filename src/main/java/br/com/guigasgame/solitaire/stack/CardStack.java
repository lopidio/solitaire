package br.com.guigasgame.solitaire.stack;

import java.util.List;

import br.com.guigasgame.solitaire.solitaire.card.CardManager;

public interface CardStack
{
	CardManager getTop();
	boolean addCard(CardManager card);
	CardManager removeCard(CardManager card);
	int getSize();
	boolean canAddCards(List<CardManager> cards);
}
