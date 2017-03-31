package br.com.guigasgame.solitaire.solitaire.stack;

import java.util.List;

import br.com.guigasgame.solitaire.card.Rank;
import br.com.guigasgame.solitaire.solitaire.card.CardSolitaire;

public class TableauCardStack extends SolitaireCardStack
{

	public TableauCardStack(List<CardSolitaire> cards)
	{
		super(SolitaireCardStackType.tableau);
		for (CardSolitaire solitaireCard : cards)
		{
			addCard(solitaireCard);
		}
		CardSolitaire cardAtTop = getSolitaireTop();
		if (cardAtTop != null)
		{
			cardAtTop.reveal();
		}
	}

	public boolean canAddSolitaireCard(CardSolitaire card)
	{
		if (cards.isEmpty())
		{
			return card.getRank() == Rank.king;
		}
		
		CardSolitaire cardAtTop = getSolitaireTop();
		if (card.getRank().getValue() == cardAtTop.getRank().getValue() - 1)
		{
			return card.getSuit().getSuitColor() != cardAtTop.getSuit().getSuitColor();
		}
		return false;
	}

}
