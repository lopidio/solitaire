package br.com.guigasgame.solitaire.gamemachine;


import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import br.com.guigasgame.solitaire.gui.MenuOptionsFrame;

public class PauseState implements GameState, WindowListener 
{
	private MenuOptionsFrame pauseFrame;
	private boolean markToSwitchState;

	public PauseState()
	{
		pauseFrame = new MenuOptionsFrame();
		pauseFrame.setVisible(true);
		pauseFrame.addWindowListener(this);
	}
	
	@Override
	public void update(float updateDelta)
	{
		if (markToSwitchState)
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
