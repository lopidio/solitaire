package br.com.guigasgame.solitaire.solitaire;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import br.com.guigasgame.solitaire.card.Card;
import br.com.guigasgame.solitaire.card.Rank;
import br.com.guigasgame.solitaire.card.Suit;
import br.com.guigasgame.solitaire.position.PositionComponent;

public class SolitaireWorkspaceCardStackTest
{

	@Test
	public void testCanAddNewCard()
	{
		List<SolitaireCard> cards = new ArrayList<>();
		cards.add(new SolitaireCard(new Card(Rank.ten, Suit.clubs)));
		SolitaireWorkspaceCardStack workspaceStack = new SolitaireWorkspaceCardStack(cards, new PositionComponent(300, 300));
		assertEquals(false, workspaceStack.canAddNewCard(new SolitaireCard(new Card(Rank.jack, Suit.diamonds))));
		assertEquals(false, workspaceStack.canAddNewCard(new SolitaireCard(new Card(Rank.jack, Suit.clubs))));
		assertEquals(false, workspaceStack.canAddNewCard(new SolitaireCard(new Card(Rank.ten, Suit.clubs))));
		assertEquals(true, workspaceStack.canAddNewCard(new SolitaireCard(new Card(Rank.nine, Suit.diamonds))));
		assertEquals(true, workspaceStack.canAddNewCard(new SolitaireCard(new Card(Rank.nine, Suit.hearts))));
		assertEquals(false, workspaceStack.canAddNewCard(new SolitaireCard(new Card(Rank.nine, Suit.clubs))));
		assertEquals(false, workspaceStack.canAddNewCard(new SolitaireCard(new Card(Rank.eight, Suit.clubs))));
		
		SolitaireWorkspaceCardStack emptyWorkspaceStack = new SolitaireWorkspaceCardStack(new ArrayList<>(), new PositionComponent(300, 300));
		assertEquals(true, emptyWorkspaceStack.canAddNewCard(new SolitaireCard(new Card(Rank.king, Suit.diamonds))));
		assertEquals(true, emptyWorkspaceStack.canAddNewCard(new SolitaireCard(new Card(Rank.king, Suit.clubs))));
		assertEquals(false, emptyWorkspaceStack.canAddNewCard(new SolitaireCard(new Card(Rank.queen, Suit.diamonds))));
		assertEquals(false, emptyWorkspaceStack.canAddNewCard(new SolitaireCard(new Card(Rank.ace, Suit.diamonds))));

	}

	@Test
	public void testGetCardGameObjectAtTop()
	{
		List<SolitaireCard> cards = new ArrayList<>();
		cards.add(new SolitaireCard(new Card(Rank.ten, Suit.clubs)));
		SolitaireWorkspaceCardStack workspaceStack = new SolitaireWorkspaceCardStack(cards, new PositionComponent(300, 300));
		SolitaireCard card = workspaceStack.getCardGameObjectAtTop();
		assertEquals(Suit.clubs, card.getCard().getSuit());
		assertEquals(Rank.ten, card.getCard().getRank());
		
		SolitaireWorkspaceCardStack emptyWorkspaceStack = new SolitaireWorkspaceCardStack(new ArrayList<>(), new PositionComponent(300, 300));
		assertEquals(null, emptyWorkspaceStack.getCardGameObjectAtTop());
	}

	@Test
	public void testAddCard()
	{
		List<SolitaireCard> cards = new ArrayList<>();
		cards.add(new SolitaireCard(new Card(Rank.eight, Suit.hearts)));
		
		SolitaireWorkspaceCardStack workspaceStack = new SolitaireWorkspaceCardStack(cards, new PositionComponent(300, 300));
		assertEquals(false, workspaceStack.addCard(new SolitaireCard(new Card(Rank.jack, Suit.diamonds))));
		assertEquals(false, workspaceStack.addCard(new SolitaireCard(new Card(Rank.nine, Suit.clubs))));
		assertEquals(false, workspaceStack.addCard(new SolitaireCard(new Card(Rank.seven, Suit.diamonds))));
		assertEquals(true, workspaceStack.addCard(new SolitaireCard(new Card(Rank.seven, Suit.clubs))));
		assertEquals(Suit.clubs, workspaceStack.getCardGameObjectAtTop().getCard().getSuit());
		assertEquals(Rank.seven, workspaceStack.getCardGameObjectAtTop().getCard().getRank());
		
		SolitaireWorkspaceCardStack emptyWorkspaceStack = new SolitaireWorkspaceCardStack(new ArrayList<>(), new PositionComponent(300, 300));
		assertEquals(false, emptyWorkspaceStack.addCard(new SolitaireCard(new Card(Rank.jack, Suit.diamonds))));
		assertEquals(true, emptyWorkspaceStack.addCard(new SolitaireCard(new Card(Rank.king, Suit.diamonds))));
		assertNotEquals(Suit.clubs, emptyWorkspaceStack.getCardGameObjectAtTop().getCard().getSuit());
		assertEquals(Suit.diamonds, emptyWorkspaceStack.getCardGameObjectAtTop().getCard().getSuit());
		assertEquals(Rank.king, emptyWorkspaceStack.getCardGameObjectAtTop().getCard().getRank());
	}

	@Test
	public void testRemoveCardAtTop()
	{
		List<SolitaireCard> cards = new ArrayList<>();
		cards.add(new SolitaireCard(new Card(Rank.ace, Suit.hearts)));
		
		SolitaireWorkspaceCardStack workspaceStack = new SolitaireWorkspaceCardStack(cards, new PositionComponent(300, 300));
		SolitaireCard removed = workspaceStack.removeCardAtTop();
		assertNotEquals(Suit.clubs, removed.getCard().getSuit());
		assertEquals(Suit.hearts, removed.getCard().getSuit());
		assertEquals(Rank.ace, removed.getCard().getRank());
		
		assertEquals(null, workspaceStack.removeCardAtTop());
		
	}

}
