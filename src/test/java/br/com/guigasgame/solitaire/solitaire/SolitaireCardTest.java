package br.com.guigasgame.solitaire.solitaire;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.com.guigasgame.solitaire.card.Card;
import br.com.guigasgame.solitaire.card.Rank;
import br.com.guigasgame.solitaire.card.Suit;

public class SolitaireCardTest
{

	@Test
	public void testFlip()
	{
		SolitaireCard cardGameObject = new SolitaireCard(new Card(Rank.ace, Suit.spades));
		assertEquals(false, cardGameObject.isRevealed());
		cardGameObject.flip();
		assertEquals(true, cardGameObject.isRevealed());
		cardGameObject.flip();
		assertEquals(false, cardGameObject.isRevealed());
	}

}
