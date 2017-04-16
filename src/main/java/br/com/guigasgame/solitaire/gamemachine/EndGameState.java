package br.com.guigasgame.solitaire.gamemachine;

import java.util.List;

import org.jsfml.graphics.RenderTarget;
import org.jsfml.graphics.RenderWindow;
import org.jsfml.window.Keyboard;
import org.jsfml.window.event.Event;

import br.com.guigasgame.solitaire.drawable.CascadeCardStack;
import br.com.guigasgame.solitaire.drawable.FinishGameAnimation;
import br.com.guigasgame.solitaire.solitaire.score.RecordRank;
import br.com.guigasgame.solitaire.solitaire.score.Score;
import br.com.guigasgame.solitaire.solitaire.score.ScoreCounter;

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
		RecordRank recordRank = RecordRank.loadFromFile();
		if (null == recordRank)
		{
			recordRank = new RecordRank();
		}
		
		Score score = new Score(scoreCounter.getScore(), scoreCounter.getTransactionCounter(), scoreCounter.getTotalTime());
		System.out.println(score);
		recordRank.addScore(score);
		recordRank.save();
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
	
	@Override
	public void handleEvent(Event event, RenderWindow renderWindow)
	{
		if (event.type == Event.Type.KEY_PRESSED)
		{
			if (event.asKeyEvent().key == Keyboard.Key.F2)
			{
				GameMachine.getInstance().switchState(new MainGameState());
			}
		}

	}

}
