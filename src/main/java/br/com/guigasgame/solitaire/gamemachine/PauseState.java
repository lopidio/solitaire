package br.com.guigasgame.solitaire.gamemachine;


import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import br.com.guigasgame.solitaire.gui.PauseFrame;

public class PauseState implements GameState, WindowListener 
{
	public PauseState()
	{
		PauseFrame pauseFrame = new PauseFrame();
		pauseFrame.setVisible(true);
		pauseFrame.addWindowListener(this);
	}


	@Override
	public void windowClosed(WindowEvent e)
	{
		GameMachine.getInstance().popState();
	}

	@Override
	public void windowClosing(WindowEvent e)
	{
		GameMachine.getInstance().popState();
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
