package br.com.guigasgame.solitaire.solitaire;

import static org.junit.Assert.*;

import org.junit.Test;

import br.com.guigasgame.solitaire.card.Rank;
import br.com.guigasgame.solitaire.card.Suit;
import br.com.guigasgame.solitaire.solitaire.card.CardSolitaire;

public class SolitaireCardTest
{

	@Test
	public void testFlip()
	{
		CardSolitaire cardGameObject = new CardSolitaire(Rank.ace, Suit.spades);
		assertFalse(cardGameObject.isRevealed());
		cardGameObject.reveal();
		assertTrue(cardGameObject.isRevealed());
		cardGameObject.reveal();
		assertFalse(cardGameObject.isRevealed());
	}

}
