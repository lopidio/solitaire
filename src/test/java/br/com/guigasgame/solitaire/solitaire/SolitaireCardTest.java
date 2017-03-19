package br.com.guigasgame.solitaire.solitaire;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.com.guigasgame.solitaire.card.Card;
import br.com.guigasgame.solitaire.card.Rank;
import br.com.guigasgame.solitaire.card.Suit;
import br.com.guigasgame.solitaire.position.PositionComponent;

public class SolitaireCardTest
{

	@Test
	public void testFlip()
	{
		SolitaireCard cardGameObject = new SolitaireCard(new Card(Rank.ace, Suit.spades), new PositionComponent());
		assertEquals(false, cardGameObject.isRevealed());
		cardGameObject.flip();
		assertEquals(true, cardGameObject.isRevealed());
		cardGameObject.flip();
		assertEquals(false, cardGameObject.isRevealed());
	}

}
