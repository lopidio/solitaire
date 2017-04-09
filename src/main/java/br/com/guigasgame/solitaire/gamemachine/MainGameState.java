package br.com.guigasgame.solitaire.gamemachine;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.jsfml.graphics.RenderTarget;
import org.jsfml.graphics.RenderWindow;
import org.jsfml.system.Vector2i;
import org.jsfml.window.Mouse.Button;

import br.com.guigasgame.solitaire.card.Rank;
import br.com.guigasgame.solitaire.card.Suit;
import br.com.guigasgame.solitaire.drawable.CascadeCardStack;
import br.com.guigasgame.solitaire.drawable.Drawable;
import br.com.guigasgame.solitaire.input.InputController;
import br.com.guigasgame.solitaire.input.MouseInput;
import br.com.guigasgame.solitaire.position.PositionComponent;
import br.com.guigasgame.solitaire.solitaire.card.CardManager;
import br.com.guigasgame.solitaire.solitaire.card.CardSolitaire;
import br.com.guigasgame.solitaire.solitaire.stack.StockCardStack;
import br.com.guigasgame.solitaire.solitaire.stack.TableauCardStack;
import br.com.guigasgame.solitaire.solitaire.stack.WasteCardStack;
import br.com.guigasgame.solitaire.transaction.CardTransactionManager;

public class MainGameState implements GameState
{
	
	private List<CardSolitaire> fullDeck;
	private List<Drawable> drawables;
	private InputController inputController;
	private MouseInput rightButtonHandler;
	private MouseInput leftButtonHandler;
	private CardTransactionManager transactionManager;
	
	public MainGameState()
	{
		inputController = new InputController();
		fullDeck = new ArrayList<>();		
		drawables = new ArrayList<>();
		transactionManager = new CardTransactionManager();
	}
	
	private void initializeTableauStacks(Vector2i windowSize)
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
														new PositionComponent(
																	(windowSize.x/14) * (2*i + 1), 
																	(int) (windowSize.y*0.4)),
														new PositionComponent(.03f, .25f)); 
			
			tableauCardStack.setTransactionManager(transactionManager);
			tableauCardStack.addListener(cascadeCardStack);

			leftButtonHandler.addInputListener(tableauCardStack);
			rightButtonHandler.addInputListener(tableauCardStack);

			drawables.add(cascadeCardStack);
		}
	}

	private void initStockCardStack(Vector2i windowSize, WasteCardStack wasteCardStack)
	{
		List<CardManager> cardManagers = new ArrayList<>();
		fullDeck.stream().forEach(card -> cardManagers.add(new CardManager(card)));

		
		StockCardStack stockCardStack = new StockCardStack(cardManagers, wasteCardStack);
		CascadeCardStack cascadeCardStack = new CascadeCardStack(stockCardStack, 
				new PositionComponent(
							(windowSize.x/14) * (2*0 + 1), 
							(int) (windowSize.y*0.1)), new PositionComponent(.01f, .01f), true); 
		stockCardStack.setTransactionManager(transactionManager);
		stockCardStack.addListener(cascadeCardStack);

		leftButtonHandler.addInputListener(stockCardStack);
		rightButtonHandler.addInputListener(stockCardStack);

		drawables.add(cascadeCardStack);
	}

	private WasteCardStack initWasteStack(Vector2i windowSize)
	{
		WasteCardStack wasteCardStack = new WasteCardStack();
		CascadeCardStack wasteCascadeCardStack = new CascadeCardStack(wasteCardStack, 
				new PositionComponent(
							(windowSize.x/14) * (2*1 + 1), 
							(int) (windowSize.y*0.1)), new PositionComponent(.01f, .01f)); 
		wasteCardStack.setTransactionManager(transactionManager);
		wasteCardStack.addListener(wasteCascadeCardStack);
		leftButtonHandler.addInputListener(wasteCardStack);
		rightButtonHandler.addInputListener(wasteCardStack);

		drawables.add(wasteCascadeCardStack);
		return wasteCardStack;
	}
	
	@Override
	public void enterState(RenderWindow renderWindow)
	{
		leftButtonHandler = new MouseInput(Button.LEFT, renderWindow);
		rightButtonHandler = new MouseInput(Button.RIGHT, renderWindow);
		inputController.addInputHandler(leftButtonHandler);
		inputController.addInputHandler(rightButtonHandler);
		initalizeDeck();
		shuffleCards();
		initializeTableauStacks(renderWindow.getSize());
		WasteCardStack wasteCardStack = initWasteStack(renderWindow.getSize());
		initStockCardStack(renderWindow.getSize(), wasteCardStack);
	}

	private void shuffleCards()
	{
		long seed = System.nanoTime();
		Collections.shuffle(fullDeck, new Random(seed));		
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
		transactionManager.updateTransactions();
	}

	@Override
	public void draw(RenderTarget renderTarget)
	{
		for (Drawable drawable: drawables)
		{
			drawable.draw(renderTarget);
		}
	}

}
