package br.com.guigasgame.solitaire.stack;

import java.util.List;

import br.com.guigasgame.solitaire.solitaire.card.CardManager;
import br.com.guigasgame.solitaire.solitaire.stack.SolitaireCardStackType;

public interface CardStack
{
	CardManager getTop();
	boolean addCard(CardManager card);
	CardManager removeCard();
	int getSize();
	boolean canAddCards(SolitaireCardStackType sourceStackType, List<CardManager> cards);
}
