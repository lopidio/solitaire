package br.com.guigasgame.solitaire.gamemachine;

import java.util.List;

import org.jsfml.graphics.RenderTarget;
import org.jsfml.graphics.RenderWindow;
import org.jsfml.window.Keyboard;
import org.jsfml.window.event.Event;

import br.com.guigasgame.solitaire.drawable.CascadeCardStack;
import br.com.guigasgame.solitaire.drawable.FinishGameAnimation;
import br.com.guigasgame.solitaire.score.ScoreCounter;
import br.com.guigasgame.solitaire.score.ScoreModel;
import br.com.guigasgame.solitaire.score.ScoreRecorder;

public class EndGameState implements GameState
{
	private FinishGameAnimation finishGameAnimation;
	private ScoreCounter scoreCounter;
	ScoreRecorder recordRank;

	public EndGameState(ScoreCounter scoreCounter, List<CascadeCardStack> cascadeStacks)
	{
		finishGameAnimation = new FinishGameAnimation();
		cascadeStacks.stream().forEach(cascade -> 
		{
			if (cascade.getCards().size() > 0) 
				finishGameAnimation.addCascade(cascade.getCards());
		});
		this.scoreCounter = scoreCounter;
		recordRank = new ScoreRecorder();
	}

	@Override
	public void enterState(RenderWindow renderWindow)
	{
		finishGameAnimation.setSize(renderWindow.getSize());
		System.out.println("Congratulations!");
		ScoreModel score = new ScoreModel(scoreCounter.getScore(), scoreCounter.getTransactionCounter(), scoreCounter.getTotalTime(), "Guilherme Moraes");
		System.out.println(score);
		int position = recordRank.addScore(score).getPosition();
		System.out.println("Posição obtida: " + position);
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
