package br.com.guigasgame.solitaire.gamemachine;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;
import java.util.Vector;

import org.jsfml.graphics.Color;
import org.jsfml.graphics.RenderWindow;
import org.jsfml.system.Clock;
import org.jsfml.window.Keyboard;
import org.jsfml.window.VideoMode;
import org.jsfml.window.event.Event;


public class GameMachine
{
	private static GameMachine gameMachine;
	
	public static GameMachine getInstance()
	{
		if (gameMachine == null)
			gameMachine = new GameMachine();
		return gameMachine;
	}
	
	public final int FRAME_RATE = 60;
	private boolean isRunning;
	private RenderWindow renderWindow;
	private Vector<GameState> gameStates;

	public static void main(String[] args) throws Exception
	{
		GameMachine gameMachine = getInstance();

		gameMachine.popState();
		gameMachine.addState(new MainGameState());
		gameMachine.execute();
	}

	public void popState()
	{
		if (gameStates.size() > 0)
			gameStates.remove(gameStates.lastElement());
	}

	public void addState(GameState gameState)
	{
		gameState.enterState(renderWindow);
		gameStates.add(gameState);
	}

	public GameMachine()
	{

		VideoMode[] modes = VideoMode.getFullscreenModes();
		Arrays.sort(modes, new Comparator<VideoMode>()
		{

			@Override
			public int compare(VideoMode o1, VideoMode o2)
			{
				int retorno = o1.height * o1.width - o2.height * o2.width;
				if (retorno == 0)
					return o1.bitsPerPixel - o2.bitsPerPixel;
				return retorno;
			}

		});
//		for( VideoMode videoMode : modes )
//		{
//			System.out.println(videoMode);
//		}
//		final VideoMode best = modes[modes.length - 1];

//		renderWindow = new RenderWindow(best, "Solitaire");//, Window.FULLSCREEN);  //Window.TRANSPARENT
		renderWindow = new RenderWindow(new VideoMode(800, 600, 32), "Solitaire");//, Window.FULLSCREEN);  //Window.TRANSPARENT
//		renderWindow = new RenderWindow(worst, "High Order Ninja");//, Window.FULLSCREEN);  //Window.TRANSPARENT
		renderWindow.setFramerateLimit(FRAME_RATE);
		renderWindow.setVerticalSyncEnabled(true);
		renderWindow.setMouseCursorVisible(true);

		isRunning = true;
		gameStates = new Stack<GameState>();
	}

	private void execute()
	{
		gameStates.lastElement().load();
		gameLoop();
		gameStates.lastElement().unload();
		gameStates.lastElement().exitState();
		System.exit(0);					
	}

	private void gameLoop()
	{
		// http://gafferongames.com/game-physics/fix-your-timestep/
		Clock clock = new Clock();
		float remainingAcumulator = 0f;
		final float updateDelta = (float) 1 / FRAME_RATE;
		while (isRunning)
		{
			float iterationTime = clock.restart().asSeconds();

			// max frame time to avoid spiral of death
			if (iterationTime > 0.25f)
				iterationTime = 0.25f;

			renderWindow.clear(new Color(0, 128, 0));
			handleEvents();

			remainingAcumulator += iterationTime;
			while (remainingAcumulator >= iterationTime)
			{
				gameStates.lastElement().update(updateDelta);
				remainingAcumulator -= updateDelta;
			}

			gameStates.lastElement().draw(renderWindow);
			renderWindow.display();
		}
	}

	private void handleEvents()
	{
		Iterable<Event> events = renderWindow.pollEvents();
		for( Event event : events )
		{
			gameStates.lastElement().handleEvent(event, renderWindow);
			if (event.type == Event.Type.KEY_PRESSED)
			{
				if (event.asKeyEvent().key == Keyboard.Key.ESCAPE)
				{
					isRunning = false;
					break;
				}
			}
			if (event.type == Event.Type.CLOSED)
			{
				isRunning = false;
			}
		}
	}

	public void switchState(GameState gameState)
	{
		popState();
		addState(gameState);
	}

}