package br.com.guigasgame.solitaire.solitaire;

import org.junit.Test;

public class SolitaireWorkspaceCardStackTest
{

	@Test
	public void testCanAddNewCard()
	{
//		List<SolitaireCard> cards = new ArrayList<>();
//		cards.add(new SolitaireCard(Rank.ten, Suit.clubs));
//		SolitaireTableau workspaceStack = new SolitaireTableau(cards, new PositionComponent(300, 300));
//		assertFalse(workspaceStack.canAddCard(new SolitaireCard(Rank.jack, Suit.diamonds))));
//		assertFalse(workspaceStack.canAddCard(new SolitaireCard(Rank.jack, Suit.clubs))));
//		assertFalse(workspaceStack.canAddCard(new SolitaireCard(Rank.ten, Suit.clubs))));
//		assertTrue(workspaceStack.canAddCard(new SolitaireCard(Rank.nine, Suit.diamonds))));
//		assertTrue(workspaceStack.canAddCard(new SolitaireCard(Rank.nine, Suit.hearts))));
//		assertFalse(workspaceStack.canAddCard(new SolitaireCard(Rank.nine, Suit.clubs))));
//		assertFalse(workspaceStack.canAddCard(new SolitaireCard(Rank.eight, Suit.clubs))));
//		
//		SolitaireTableau emptyWorkspaceStack = new SolitaireTableau(new ArrayList<>(), new PositionComponent(300, 300));
//		assertTrue(emptyWorkspaceStack.canAddCard(new SolitaireCard(Rank.king, Suit.diamonds))));
//		assertTrue(emptyWorkspaceStack.canAddCard(new SolitaireCard(Rank.king, Suit.clubs))));
//		assertFalse(emptyWorkspaceStack.canAddCard(new SolitaireCard(Rank.queen, Suit.diamonds))));
//		assertFalse(emptyWorkspaceStack.canAddCard(new SolitaireCard(Rank.ace, Suit.diamonds))));
//
//	}
//
//	@Test
//	public void testGetCardGameObjectAtTop()
//	{
//		List<SolitaireCard> cards = new ArrayList<>();
//		cards.add(new SolitaireCard(Rank.ten, Suit.clubs));
//		SolitaireTableau workspaceStack = new SolitaireTableau(cards, new PositionComponent(300, 300));
//		SolitaireCard card = workspaceStack.getCardGameObjectAtTop();
//		assertEquals(Suit.clubs, card.getSuit());
//		assertEquals(Rank.ten, card.getRank());
//		
//		SolitaireTableau emptyWorkspaceStack = new SolitaireTableau(new ArrayList<>(), new PositionComponent(300, 300));
//		assertEquals(null, emptyWorkspaceStack.getCardGameObjectAtTop());
	}

	@Test
	public void testAddCard()
	{
//		List<SolitaireCard> cards = new ArrayList<>();
//		SolitaireCard firstAtTop = new SolitaireCard(Rank.eight, Suit.hearts));
//		cards.add(firstAtTop);
//		
//		SolitaireTableau workspaceStack = new SolitaireTableau(cards, new PositionComponent(300, 300));
//		assertTrue(workspaceStack.getCardGameObjectAtTop().isAtStackTop());
//		assertFalse(workspaceStack.addCard(new SolitaireCard(Rank.jack, Suit.diamonds))));
//		assertFalse(workspaceStack.addCard(new SolitaireCard(Rank.nine, Suit.clubs))));
//		assertFalse(workspaceStack.addCard(new SolitaireCard(Rank.seven, Suit.diamonds))));
//		SolitaireCard secondAtTop = new SolitaireCard(Rank.seven, Suit.clubs));
//		assertTrue(workspaceStack.addCard(secondAtTop));
//		assertEquals(Suit.clubs, workspaceStack.getCardGameObjectAtTop().getTop().getSuit());
//		assertEquals(Rank.seven, workspaceStack.getCardGameObjectAtTop().getTop().getRank());
//		assertTrue(workspaceStack.getCardGameObjectAtTop().isAtStackTop());
//		assertFalse(firstAtTop.isAtStackTop());
//		assertTrue(secondAtTop.isAtStackTop());
//		
//		SolitaireTableau emptyWorkspaceStack = new SolitaireTableau(new ArrayList<>(), new PositionComponent(300, 300));
//		assertFalse(emptyWorkspaceStack.addCard(new SolitaireCard(Rank.jack, Suit.diamonds))));
//		assertTrue(emptyWorkspaceStack.addCard(new SolitaireCard(Rank.king, Suit.diamonds))));
//		assertNotEquals(Suit.clubs, emptyWorkspaceStack.getCardGameObjectAtTop().getTop().getSuit());
//		assertEquals(Suit.diamonds, emptyWorkspaceStack.getCardGameObjectAtTop().getTop().getSuit());
//		assertEquals(Rank.king, emptyWorkspaceStack.getCardGameObjectAtTop().getTop().getRank());
	}

	@Test
	public void testRemoveCardAtTop()
	{
//		List<SolitaireCard> cards = new ArrayList<>();
//		cards.add(new SolitaireCard(Rank.two, Suit.hearts)));
//		cards.add(new SolitaireCard(Rank.ace, Suit.spades)));
//		
//		SolitaireTableau workspaceStack = new SolitaireTableau(cards, new PositionComponent(300, 300));
//		assertTrue(workspaceStack.getCardGameObjectAtTop().isAtStackTop());
//		SolitaireCard removed = workspaceStack.removeCard();
//		assertNotEquals(Suit.clubs, removed.getTop().getSuit());
//		assertEquals(Suit.spades, removed.getTop().getSuit());
//		assertEquals(Rank.ace, removed.getTop().getRank());
//		
//		assertFalse(removed.isAtStackTop());
//		assertFalse(workspaceStack.removeCard().isAtStackTop());
//		assertEquals(null, workspaceStack.removeCard());
//		
	}

}
