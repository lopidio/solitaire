package br.com.guigasgame.solitaire.gamemachine;

import java.util.List;

import org.jsfml.graphics.RenderTarget;
import org.jsfml.graphics.RenderWindow;

import br.com.guigasgame.solitaire.drawable.CascadeCardStack;
import br.com.guigasgame.solitaire.drawable.FinishGameAnimation;
import br.com.guigasgame.solitaire.solitaire.ScoreCounter;

public class EndGameState implements GameState
{
	private FinishGameAnimation finishGameAnimation;
	private ScoreCounter scoreCounter;

	public EndGameState(ScoreCounter scoreCounter, List<CascadeCardStack> cascadeStacks)
	{
		finishGameAnimation = new FinishGameAnimation();
		cascadeStacks.stream().forEach(cascade -> 
		{
			if (cascade.getCards().size() > 0) 
				finishGameAnimation.addCascade(cascade.getCards());
		});
		this.scoreCounter = scoreCounter;
	}

	@Override
	public void enterState(RenderWindow renderWindow)
	{
		finishGameAnimation.setSize(renderWindow.getSize());
		System.out.println("Congratulations!");
		System.out.println("Your time: " + scoreCounter.getTotalTime());
		System.out.println("Your score: " + scoreCounter.getScore());
		System.out.println("Your moves: " + scoreCounter.getTransactionCounter());
	}
	
	@Override
	public void draw(RenderTarget renderTarget)
	{
		finishGameAnimation.draw(renderTarget);
	}
	
	@Override
	public void update(float updateDelta)
	{
		finishGameAnimation.update(updateDelta);
	}
}
