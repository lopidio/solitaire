package br.com.guigasgame.solitaire.stack;

import br.com.guigasgame.solitaire.solitaire.SolitaireCard;

public interface CardStack
{
	SolitaireCard getCardGameObjectAtTop();
	boolean canAddNewCard(SolitaireCard card);
	boolean addCard(SolitaireCard card);
	SolitaireCard removeCardAtTop();
}
