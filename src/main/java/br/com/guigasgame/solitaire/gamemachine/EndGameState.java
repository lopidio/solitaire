package br.com.guigasgame.solitaire.gamemachine;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
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
import br.com.guigasgame.solitaire.gui.MenuOptionsFrame;
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
		finishGameAnimation.setSize(renderWindow.getSize());
		addScoreInAnotherThread();
	}

	private void addScoreInAnotherThread()
	{
		Runnable task = () ->
		{
			System.out.println("Parabéns!");
			ScoreModel score = new ScoreModel(scoreCounter.getScore(), scoreCounter.getTransactionCounter(), 
					scoreCounter.getTotalTime(), ConfigFile.getInstance().getValue("playerName"));
			System.out.println(score);
			System.out.println("Scores locais:");
			registerScore(score, scoreRecorder.getLocal());
			System.out.println("Scores online:");
			registerScore(score, scoreRecorder.getOnline());
		};
		
		ExecutorService executorScoreAdd = Executors.newFixedThreadPool(1);
		futureScoreAdd = executorScoreAdd.submit(task);
	}

	private void registerScore(ScoreModel score, ScoreRepository repository)
	{
		ScorePositionModel positionOnline = repository.addScore(score);
		if (null != positionOnline)
		{
			System.out.println("\tPosição: " + (positionOnline.getPosition() + 1) + "/" + positionOnline.getTotal());
			List<ScoreModel> topOnline = repository.getTop(5);
			if (null != topOnline)
				topOnline.stream().forEachOrdered(top -> System.out.println("\t" + top));
		}
		else
			System.out.println("Erro ao registrar score");
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
		if (markToSwitchState)
			GameMachine.getInstance().switchState(new MainGameState());
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
