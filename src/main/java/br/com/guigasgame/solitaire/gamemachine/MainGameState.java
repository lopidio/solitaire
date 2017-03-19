package br.com.guigasgame.solitaire.gamemachine;

import java.util.ArrayList;
import java.util.List;

import org.jsfml.graphics.RenderTarget;

import br.com.guigasgame.solitaire.card.Card;
import br.com.guigasgame.solitaire.card.Rank;
import br.com.guigasgame.solitaire.card.Suit;
import br.com.guigasgame.solitaire.position.PositionComponent;
import br.com.guigasgame.solitaire.solitaire.SolitaireCard;
import br.com.guigasgame.solitaire.solitaire.SolitaireWorkspaceCardStack;

public class MainGameState implements GameState
{
	
	SolitaireWorkspaceCardStack workspaceStack;
	
	public MainGameState()
	{
		List<SolitaireCard> cards = new ArrayList<>();
		cards.add(new SolitaireCard(new Card(Rank.ten, Suit.clubs)));
		cards.add(new SolitaireCard(new Card(Rank.nine, Suit.diamonds)));
		cards.add(new SolitaireCard(new Card(Rank.eight, Suit.clubs)));
		cards.add(new SolitaireCard(new Card(Rank.seven, Suit.diamonds)));
		workspaceStack = new SolitaireWorkspaceCardStack(cards, new PositionComponent(300, 300));
	}

	@Override
	public void update(float updateDelta)
	{

	}

	@Override
	public void draw(RenderTarget renderTarget)
	{
		workspaceStack.draw(renderTarget);
	}

}
