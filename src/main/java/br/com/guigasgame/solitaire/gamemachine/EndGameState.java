package br.com.guigasgame.solitaire.gamemachine;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.jsfml.graphics.RenderTarget;
import org.jsfml.graphics.RenderWindow;

import br.com.guigasgame.solitaire.config.ConfigFile;
import br.com.guigasgame.solitaire.drawable.CascadeCardStack;
import br.com.guigasgame.solitaire.drawable.Drawable;
import br.com.guigasgame.solitaire.drawable.FinishGameAnimation;
import br.com.guigasgame.solitaire.drawable.PositionHUD;
import br.com.guigasgame.solitaire.gui.MenuOptionsFrame;
import br.com.guigasgame.solitaire.position.PositionComponent;
import br.com.guigasgame.solitaire.score.ScoreCounter;
import br.com.guigasgame.solitaire.score.ScoreModel;
import br.com.guigasgame.solitaire.score.ScorePositionModel;
import br.com.guigasgame.solitaire.score.ScoreRecorder;
import br.com.guigasgame.solitaire.score.ScoreRepository;

public class EndGameState implements GameState
{
	private FinishGameAnimation finishGameAnimation;
	private ScoreCounter scoreCounter;
	private ScoreRecorder scoreRecorder;
	private Future<?> futureScoreAdd;
	private List<Drawable> hudList;
	private boolean markToSwitchState;
	private PositionComponent windowSize;

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
		
		createMenuFrame();

	}

	@Override
	public void enterState(RenderWindow renderWindow)
	{
		windowSize = new PositionComponent(renderWindow.getSize().x, renderWindow.getSize().y);
		finishGameAnimation.setSize(renderWindow.getSize());
		addScoreInAnotherThread();
	}

	private void addScoreInAnotherThread()
	{
		PositionHUD localPositionHud = new PositionHUD("Local position: ", new PositionComponent(windowSize.getX()/2, windowSize.getY()/2 - 50));
		hudList.add(localPositionHud);

		PositionHUD onlinePositionHud = new PositionHUD("Online position: ", new PositionComponent(windowSize.getX()/2, windowSize.getY()/2 + 50));
		hudList.add(onlinePositionHud);

		Runnable task = () ->
		{
			System.out.println("Parabéns!");
			ScoreModel score = new ScoreModel(scoreCounter.getScore(), scoreCounter.getTransactionCounter(), 
					scoreCounter.getTotalTime(), ConfigFile.getInstance().getValue("playerName"));
			System.out.println(score);
			System.out.println("Scores locais:");
			ScorePositionModel localPosition = registerScore(score, scoreRecorder.getLocal());
			if (null != localPosition)
				localPositionHud.setPositionText(localPosition);
			System.out.println("Scores online:");
			ScorePositionModel onlinePosition = registerScore(score, scoreRecorder.getOnline());
			if (null != onlinePosition)
				onlinePositionHud.setPositionText(onlinePosition);
		};
		
		ExecutorService executorScoreAdd = Executors.newFixedThreadPool(1);
		futureScoreAdd = executorScoreAdd.submit(task);
	}

	private ScorePositionModel registerScore(ScoreModel score, ScoreRepository repository)
	{
		ScorePositionModel positionModel = repository.addScore(score);
		if (null != positionModel)
		{
			System.out.println("\tPosição: " + (positionModel.getPosition() + 1) + "/" + positionModel.getTotal());
			return positionModel;
		}
		else
			System.out.println("Erro ao registrar score");
		return null;
	}
	
	@Override
	public void draw(RenderTarget renderTarget)
	{
		finishGameAnimation.draw(renderTarget);
		hudList.stream().forEach(hud -> hud.draw(renderTarget));
	}
	
	@Override
	public void update(float updateDelta)
	{
		if (null != futureScoreAdd && futureScoreAdd.isDone())
		{
			System.out.println("Scores foram registrados");
			futureScoreAdd = null;
		}
		if (markToSwitchState)
			GameMachine.getInstance().switchState(new MainGameState());
		finishGameAnimation.update(updateDelta);
	}

	private void createMenuFrame()
	{
		MenuOptionsFrame pauseFrame = new MenuOptionsFrame();
		pauseFrame.setVisible(true);
		pauseFrame.addWindowListener(new WindowListener()
		{
			
			@Override
			public void windowOpened(WindowEvent e)
			{
			}
			
			@Override
			public void windowIconified(WindowEvent e)
			{
			}
			
			@Override
			public void windowDeiconified(WindowEvent e)
			{
			}
			
			@Override
			public void windowDeactivated(WindowEvent e)
			{
			}
			
			@Override
			public void windowClosing(WindowEvent e)
			{
				GameMachine.getInstance().switchState(new MainGameState());
			}
			
			@Override
			public void windowClosed(WindowEvent e)
			{
				markToSwitchState = true;
			}
			
			@Override
			public void windowActivated(WindowEvent e)
			{
			}
		});
	}

}
