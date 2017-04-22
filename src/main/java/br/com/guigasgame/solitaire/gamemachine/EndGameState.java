package br.com.guigasgame.solitaire.gamemachine;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.jsfml.graphics.RenderTarget;
import org.jsfml.graphics.RenderWindow;
import org.jsfml.window.Keyboard;
import org.jsfml.window.event.Event;

import br.com.guigasgame.solitaire.config.ConfigFile;
import br.com.guigasgame.solitaire.drawable.CascadeCardStack;
import br.com.guigasgame.solitaire.drawable.Drawable;
import br.com.guigasgame.solitaire.drawable.FinishGameAnimation;
import br.com.guigasgame.solitaire.score.ScoreCounter;
import br.com.guigasgame.solitaire.score.ScoreModel;
import br.com.guigasgame.solitaire.score.ScorePositionModel;
import br.com.guigasgame.solitaire.score.ScoreRecorder;

public class EndGameState implements GameState
{
	private FinishGameAnimation finishGameAnimation;
	private ScoreCounter scoreCounter;
	ScoreRecorder scoreRecorder;
	private Future<?> futureScoreAdd;
	private List<Drawable> hudList;

	public EndGameState(ScoreCounter scoreCounter, List<CascadeCardStack> cascadeStacks, List<Drawable> hudList)
	{
		finishGameAnimation = new FinishGameAnimation();
		cascadeStacks.stream().forEach(cascade -> 
		{
			if (cascade.getCards().size() > 0) 
				finishGameAnimation.addCascade(cascade.getCards());
		});
		this.scoreCounter = scoreCounter;
		scoreRecorder = new ScoreRecorder();
		this.hudList = hudList;
	}

	@Override
	public void enterState(RenderWindow renderWindow)
	{
		finishGameAnimation.setSize(renderWindow.getSize());
		addScoreInAnotherThread();
	}

	private void addScoreInAnotherThread()
	{
		Runnable task = () ->
		{
			System.out.println("Congratulations!");
			ScoreModel score = new ScoreModel(scoreCounter.getScore(), scoreCounter.getTransactionCounter(), 
					scoreCounter.getTotalTime(), ConfigFile.getInstance().getValue("playerName"));
			System.out.println(score);
			ScorePositionModel position = scoreRecorder.addScoreLocal(score);
			System.out.println("Posição obtida local: " + (position.getPosition() + 1) + "/" + position.getTotal());
			ScorePositionModel positionOnline = scoreRecorder.addScoreOnline(score);
			if (null != positionOnline)
				System.out.println("Posição obtida online: " + (position.getPosition() + 1) + "/" + position.getTotal());
			else
				System.out.println("Erro ao registrar posição online");
		};
		
		ExecutorService executorScoreAdd = Executors.newFixedThreadPool(1);
		futureScoreAdd = executorScoreAdd.submit(task);
	}
	
	@Override
	public void draw(RenderTarget renderTarget)
	{
		hudList.stream().forEach(hud -> hud.draw(renderTarget));
		finishGameAnimation.draw(renderTarget);
	}
	
	@Override
	public void update(float updateDelta)
	{
		if (null != futureScoreAdd && futureScoreAdd.isDone())
		{
			System.out.println("Scores foram registrados");
			futureScoreAdd = null;
		}
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
