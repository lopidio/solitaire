package br.com.guigasgame.solitaire.gameobject;

import static org.junit.Assert.assertEquals;

import org.jsfml.graphics.IntRect;
import org.junit.Test;

import br.com.guigasgame.solitaire.card.Card;
import br.com.guigasgame.solitaire.card.Rank;
import br.com.guigasgame.solitaire.card.Suit;
import br.com.guigasgame.solitaire.gameObject.CardGameObject;
import br.com.guigasgame.solitaire.position.PositionComponent;

public class CardGameObjectTest
{

	@Test
	public void testFlip()
	{
		CardGameObject cardGameObject = new CardGameObject(new Card(Rank.ace, Suit.spades), new PositionComponent());
		assertEquals(false, cardGameObject.isRevealed());
		cardGameObject.flip();
		assertEquals(true, cardGameObject.isRevealed());
		cardGameObject.flip();
		assertEquals(false, cardGameObject.isRevealed());
	}

	@Test
	public void testIsOverOtherCard()
	{
		CardGameObject cardGameObject = new CardGameObject(new Card(Rank.ace, Suit.spades), new PositionComponent(0, 0));
		IntRect cardDimensions = cardGameObject.getCardSprite().getSprite().getTextureRect();
		
		CardGameObject notOverCardGameObject = new CardGameObject(new Card(Rank.ace, Suit.spades), new PositionComponent(cardDimensions.width, cardDimensions.height));
		assertEquals(false, cardGameObject.isOverOtherCard(notOverCardGameObject));

		CardGameObject overCardGameObject = new CardGameObject(new Card(Rank.ace, Suit.spades), new PositionComponent(cardDimensions.width/2, cardDimensions.height/2));
		assertEquals(true, cardGameObject.isOverOtherCard(overCardGameObject));
	}

}
