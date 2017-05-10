package br.com.guigasgame.solitaire.gamemachine;


import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import br.com.guigasgame.solitaire.gui.MenuOptionsFrame;

public class PauseState implements GameState, WindowListener 
{
	private MenuOptionsFrame pauseFrame;
	private boolean markToSwitchState;

	public PauseState()
	{
		Runnable task = () ->
		{

			pauseFrame = new MenuOptionsFrame();
			pauseFrame.setVisible(true);
			pauseFrame.addWindowListener(this);
		};
		ExecutorService executorScoreAdd = Executors.newFixedThreadPool(1);
		executorScoreAdd.submit(task);
	}
	
	@Override
	public void update(float updateDelta)
	{
		if (pauseFrame != null && markToSwitchState)
		{
			GameMachine.getInstance().popState();
			if (pauseFrame.requiresNewGame())
			{
//				GameMachine.getInstance().popState();
				GameMachine.getInstance().switchState(new MainGameState());
			}

		}
			
	}


	@Override
	public void windowClosed(WindowEvent e)
	{
		markToSwitchState = true;
	}

	@Override
	public void windowClosing(WindowEvent e)
	{
	}

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
	public void windowActivated(WindowEvent e)
	{
	}

	@Override
	public void windowDeactivated(WindowEvent e)
	{
	}

}
