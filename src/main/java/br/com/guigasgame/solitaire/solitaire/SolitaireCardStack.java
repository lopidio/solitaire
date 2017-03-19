package br.com.guigasgame.solitaire.solitaire;

import java.util.ArrayList;
import java.util.List;

import br.com.guigasgame.solitaire.stack.CardStack;

public abstract class SolitaireCardStack
{
	protected CardStack cardStack;
	protected List<SolitaireCard> faceDownCards;
	protected List<SolitaireCard> faceUpCards;

	public SolitaireCardStack(CardStack cardStack)
	{
		this.cardStack = cardStack;
		faceDownCards = new ArrayList<>();
		faceUpCards = new ArrayList<>();
	}

	public CardStack getCardStack()
	{
		return cardStack;
	}
	
	
}
