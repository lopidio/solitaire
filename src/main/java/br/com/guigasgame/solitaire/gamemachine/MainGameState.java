package br.com.guigasgame.solitaire.gamemachine;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.jsfml.graphics.RenderTarget;
import org.jsfml.system.Vector2i;

import br.com.guigasgame.solitaire.card.Card;
import br.com.guigasgame.solitaire.card.Rank;
import br.com.guigasgame.solitaire.card.Suit;
import br.com.guigasgame.solitaire.position.PositionComponent;
import br.com.guigasgame.solitaire.solitaire.SolitaireCard;
import br.com.guigasgame.solitaire.solitaire.SolitaireWorkspaceCardStack;

public class MainGameState implements GameState
{
	
	private List<SolitaireCard> fullDeck;
	private List<SolitaireWorkspaceCardStack> workspaceStacks;
	
	public MainGameState()
	{
		fullDeck = new ArrayList<>();		
		initalizeDeck();
		shuffleCards();
		workspaceStacks = new ArrayList<>();
	}

	private void initializeWorkspaceStacks(Vector2i windowSize)
	{
		for (int i = 0; i < 7; ++i)
		{
			List<SolitaireCard> stackCards = new ArrayList<>();
			for (int j = 0; j < i + 1; ++j)
				stackCards.add(fullDeck.remove(fullDeck.size() - 1));
			workspaceStacks.add(new SolitaireWorkspaceCardStack(stackCards, 
																new PositionComponent((windowSize.x/14) * (2*i + 1), 
																					  (int) (windowSize.y*0.4))));
		}
	}
	
	@Override
	public void enterState(RenderTarget renderTarget)
	{
		initializeWorkspaceStacks(renderTarget.getSize());
	}

	private void shuffleCards()
	{
		long seed = System.nanoTime();
		Collections.shuffle(fullDeck, new Random(seed));		
	}

	private void initalizeDeck()
	{
		for (Suit suit : Suit.values())
		{
			for (Rank rank : Rank.values())
			{
				fullDeck.add(new SolitaireCard(new Card(rank, suit)));
			}
		}
	}

	@Override
	public void update(float updateDelta)
	{

	}

	@Override
	public void draw(RenderTarget renderTarget)
	{
		for (SolitaireWorkspaceCardStack solitaireWorkspaceCardStack : workspaceStacks)
		{
			solitaireWorkspaceCardStack.draw(renderTarget);
		}
	}

}
