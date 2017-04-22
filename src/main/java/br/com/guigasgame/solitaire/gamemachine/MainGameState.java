package br.com.guigasgame.solitaire.gamemachine;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.jsfml.graphics.FloatRect;
import org.jsfml.graphics.RenderTarget;
import org.jsfml.graphics.RenderWindow;
import org.jsfml.graphics.View;
import org.jsfml.system.Vector2i;
import org.jsfml.window.Keyboard;
import org.jsfml.window.Mouse.Button;
import org.jsfml.window.event.Event;
import org.jsfml.window.event.Event.Type;

import br.com.guigasgame.solitaire.card.Rank;
import br.com.guigasgame.solitaire.card.Suit;
import br.com.guigasgame.solitaire.drawable.CascadeCardStack;
import br.com.guigasgame.solitaire.drawable.Drawable;
import br.com.guigasgame.solitaire.drawable.ScoreHUD;
import br.com.guigasgame.solitaire.drawable.TimeCounterHUD;
import br.com.guigasgame.solitaire.input.InputController;
import br.com.guigasgame.solitaire.input.MouseInput;
import br.com.guigasgame.solitaire.position.PositionComponent;
import br.com.guigasgame.solitaire.score.ScoreCounter;
import br.com.guigasgame.solitaire.solitaire.card.CardManager;
import br.com.guigasgame.solitaire.solitaire.card.CardSolitaire;
import br.com.guigasgame.solitaire.solitaire.stack.FoundationCardStack;
import br.com.guigasgame.solitaire.solitaire.stack.StockCardStack;
import br.com.guigasgame.solitaire.solitaire.stack.TableauCardStack;
import br.com.guigasgame.solitaire.solitaire.stack.WasteCardStack;
import br.com.guigasgame.solitaire.sound.SoundManager;
import br.com.guigasgame.solitaire.transaction.CardTransactionManager;

public class MainGameState implements GameState
{
	
	private List<CardSolitaire> fullDeck;
	private List<Drawable> drawables;
	private InputController inputController;
	private MouseInput rightButtonHandler;
	private MouseInput leftButtonHandler;
	private CardTransactionManager transactionManager;
	private List<CascadeCardStack> cascadeStacks;
	private List<TableauCardStack> tableaus;
	boolean gameWon;
	private ScoreCounter scoreCounter;
	private ScoreHUD scoreHUD;
	private TimeCounterHUD timeCounterHUD;
	
	public MainGameState() 
	{
		transactionManager = new CardTransactionManager();
		inputController = new InputController();
		
		fullDeck = new ArrayList<>();		
		drawables = new ArrayList<>();
		cascadeStacks = new ArrayList<>();
		tableaus = new ArrayList<>();
		scoreCounter = new ScoreCounter();
		transactionManager.setScoreCounter(scoreCounter);
	}
	
	private void initTableauStacks(Vector2i windowSize)
	{
		for (int i = 0; i < 7; ++i)
		{
			List<CardSolitaire> stackCards = new ArrayList<>();
			for (int j = 0; j < i + 1; ++j)
				stackCards.add(fullDeck.remove(fullDeck.size() - 1));
			
			List<CardManager> cardManagers = new ArrayList<>();
			stackCards.stream().forEach(card -> cardManagers.add(new CardManager(card)));
			TableauCardStack tableauCardStack = new TableauCardStack(cardManagers);
			CascadeCardStack cascadeCardStack = new CascadeCardStack(tableauCardStack, 
													new PositionComponent(windowSize.x, windowSize.y),
													new PositionComponent((float)((2 * i + 1)/14.0), 0.4f),
													new PositionComponent(.03f, .25f)); 

			tableauCardStack.setTransactionManager(transactionManager);
			tableauCardStack.addListener(cascadeCardStack);

			leftButtonHandler.addInputListener(tableauCardStack);
			rightButtonHandler.addInputListener(tableauCardStack);
			transactionManager.addTableauStack(tableauCardStack);

			drawables.add(cascadeCardStack);
			cascadeStacks.add(cascadeCardStack);
			tableaus.add(tableauCardStack);
		}
	}

	private void initStockCardStack(Vector2i windowSize, WasteCardStack wasteCardStack)
	{
		List<CardManager> cardManagers = new ArrayList<>();
		fullDeck.stream().forEach(card -> cardManagers.add(new CardManager(card)));

		
		StockCardStack stockCardStack = new StockCardStack(cardManagers, wasteCardStack);
		CascadeCardStack cascadeCardStack = new CascadeCardStack(stockCardStack, 
												new PositionComponent(windowSize.x, windowSize.y),
												new PositionComponent((float)(1.0/14.0), 0.1f),
												new PositionComponent(.01f, .01f), true); 
		stockCardStack.setTransactionManager(transactionManager);
		stockCardStack.addListener(cascadeCardStack);

		leftButtonHandler.addInputListener(stockCardStack);

		drawables.add(cascadeCardStack);
		cascadeStacks.add(cascadeCardStack);
	}

	private WasteCardStack initWasteStack(Vector2i windowSize)
	{
		WasteCardStack wasteCardStack = new WasteCardStack();
		CascadeCardStack wasteCascadeCardStack = new CascadeCardStack(wasteCardStack,
													new PositionComponent(windowSize.x, windowSize.y),
													new PositionComponent((float)(3.0/14.0), 0.1f),
													new PositionComponent(.01f, .01f)); 
		wasteCardStack.setTransactionManager(transactionManager);
		wasteCardStack.addListener(wasteCascadeCardStack);
		leftButtonHandler.addInputListener(wasteCardStack);

		transactionManager.setWasteStack(wasteCardStack);
		drawables.add(wasteCascadeCardStack);
		cascadeStacks.add(wasteCascadeCardStack);
		return wasteCardStack;
	}
	
	private void initFoundationStacks(Vector2i windowSize)
	{
		for (int i = 0; i < 4; ++i)
		{
			FoundationCardStack foundationCardStack = new FoundationCardStack();
			leftButtonHandler.addInputListener(foundationCardStack);
			
			CascadeCardStack cascade = new CascadeCardStack(foundationCardStack,
											new PositionComponent(windowSize.x, windowSize.y),
											new PositionComponent((float)((2 * i + 7)/14.0), 0.1f),
											new PositionComponent(.001f, .001f),
											true); 
			foundationCardStack.setTransactionManager(transactionManager);
			
			foundationCardStack.addListener(cascade);
			drawables.add(cascade);
			cascadeStacks.add(cascade);
			transactionManager.addFoundation(foundationCardStack);
		}
	}
	
	@Override
	public void enterState(RenderWindow renderWindow)
	{
		leftButtonHandler = new MouseInput(Button.LEFT, renderWindow);
		rightButtonHandler = new MouseInput(Button.RIGHT, renderWindow);
		inputController.addInputHandler(leftButtonHandler);
		inputController.addInputHandler(rightButtonHandler);
		
		rightButtonHandler.addInputListener(transactionManager);
		inputController.addInputHandler(leftButtonHandler);
		initalizeDeck();
		shuffleCards();
		initTableauStacks(renderWindow.getSize());
		WasteCardStack wasteCardStack = initWasteStack(renderWindow.getSize());
		initStockCardStack(renderWindow.getSize(), wasteCardStack);
		initFoundationStacks(renderWindow.getSize());
		
		initHUD(renderWindow.getSize());
	}

	private void initHUD(Vector2i windowSize)
	{
		scoreHUD = new ScoreHUD(		
				new PositionComponent(windowSize.x, windowSize.y),
				new PositionComponent((float)((.5)/14.0), 0.90f),
					scoreCounter);
		
		timeCounterHUD = new TimeCounterHUD(
				new PositionComponent(windowSize.x, windowSize.y),
				new PositionComponent((float)((12)/14.0), 0.90f));

		drawables.add(timeCounterHUD);
		drawables.add(scoreHUD);
		
	}

	private void shuffleCards()
	{
		long seed = System.nanoTime();
		Collections.shuffle(fullDeck, new Random(seed));
		SoundManager.getInstance().playCardsShuffle();
	}

	private void initalizeDeck()
	{
		for (Suit suit : Suit.values())
		{
			for (Rank rank : Rank.values())
			{
				CardSolitaire card = new CardSolitaire(rank, suit);
				fullDeck.add(card);
			}
		}
	}

	@Override
	public void update(float updateDelta)
	{
		inputController.handleEvent(updateDelta);
		if (transactionManager.updateTransactions())
		{
			scoreCounter.startCounting();
		}

		if (!gameWon && checkVictory())
		{
			EndGameState endGameState = new EndGameState(scoreCounter, cascadeStacks);
			GameMachine.getInstance().switchState(endGameState);
			gameWon = true;
		}
		if (scoreCounter.isCounting())
		{
			timeCounterHUD.update(updateDelta);
			scoreCounter.update(updateDelta);
		}
	}

	private boolean checkVictory()
	{
		int cardCount = 0;
		for (TableauCardStack tableauCardStack : tableaus)
		{
			cardCount += tableauCardStack.getCards().size();
		}
		return cardCount == 0;
	}

	@Override
	public void draw(RenderTarget renderTarget)
	{
		for (Drawable drawable: drawables)
		{
			drawable.draw(renderTarget);
		}
	}

	@Override
	public void handleEvent(Event event, RenderWindow renderWindow)
	{
	    if (event.type == Type.RESIZED)
	    {
	        // update the view to the new size of the window
			FloatRect visibleArea = new FloatRect(0, 0, event.asSizeEvent().size.x, event.asSizeEvent().size.y);
	        renderWindow.setView(new View(visibleArea));
	        cascadeStacks.stream().forEach(cascade -> cascade.readjustToSize(visibleArea));
	        scoreHUD.resizeEvent(renderWindow.getSize());
	        timeCounterHUD.resizeEvent(renderWindow.getSize());
	    }
		if (event.type == Event.Type.KEY_PRESSED)
		{
			if (event.asKeyEvent().key == Keyboard.Key.F2)
			{
				GameMachine.getInstance().switchState(new MainGameState());
				
			}
			else if (event.asKeyEvent().key == Keyboard.Key.RETURN /*|| event.asKeyEvent().key == Keyboard.Key.ESCAPE*/)
			{
				
				PauseState pauseState = new PauseState();
				GameMachine.getInstance().addState(pauseState);
			}
		}

	}
	
}
