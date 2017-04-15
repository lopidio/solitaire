package br.com.guigasgame.solitaire.drawable;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.jsfml.graphics.RenderTarget;
import org.jsfml.system.Vector2f;
import org.jsfml.system.Vector2i;

import br.com.guigasgame.solitaire.card.Rank;
import br.com.guigasgame.solitaire.card.Suit;
import br.com.guigasgame.solitaire.position.PositionComponent;
import br.com.guigasgame.solitaire.solitaire.card.CardManager;
import br.com.guigasgame.solitaire.updatable.TimeUpdatable;

public class FinishGameAnimation implements TimeUpdatable, Drawable
{
	private List<CardManager> foundationCards;
	private List<CardManager> centerCards;
	private float timeCounter;
	private float visibleAreaDiagonal;
	private PositionComponent center;
	private List<Float> angles;
	private Random random;
	private boolean goingCenter;

	public FinishGameAnimation()
	{
		foundationCards = new ArrayList<>();
		centerCards = new ArrayList<>();
		initalizeAngles();
		random = new Random();
	}

	private void initalizeAngles()
	{
		angles = new ArrayList<>();
		double angleStep = Math.PI*2/(Rank.values().length*Suit.values().length);
		for (int i = Rank.values().length*Suit.values().length - 1; i >= 0; --i )
		{
			angles.add((float) (i*angleStep));
		}
	}

	@Override
	public void update(float deltaTime)
	{
		if (timeCounter > 0.01)
		{
			if (goingCenter)
				sendCardsToCenter();
			else// if (centerCards.size() > 0)
				sendCardsToCircle();
			timeCounter = 0;
		}
		else 
			timeCounter += deltaTime;
	}

	private void sendCardsToCenter()
	{
		if (foundationCards.size() > 0)
		{
			CardManager cardManager = foundationCards.get(foundationCards.size() - 1);
			cardManager.getDrawableCard().moveTo(center, random.nextInt(40) + 10);
			centerCards.add(foundationCards.remove(foundationCards.size() - 1));
		}
		else
		{
			if (checkChangeDirection())
			{
				goingCenter = false;
				initalizeAngles();
			}
		}
	}

	private void sendCardsToCircle()
	{
		if (centerCards.size() > 0)
		{
			double angle = angles.remove(random.nextInt(angles.size()));
			CardManager cardManager = centerCards.get(centerCards.size() - 1);
			PositionComponent newPosition = new PositionComponent(Vector2f.mul(new Vector2f((float)Math.sin(angle), (float)Math.cos(angle)),
																visibleAreaDiagonal));
			newPosition.add(center);
			cardManager.getDrawableCard().moveTo(newPosition, random.nextInt(40) + 10);
			foundationCards.add(centerCards.remove(centerCards.size() - 1));
		}
		else
		{
			if (checkChangeDirection())
				goingCenter = true;
		}
		
	}

	public boolean checkChangeDirection()
	{
		boolean flagInvert = true;
		for (CardManager card: foundationCards)
			if (!card.getDrawableCard().isNotMoving())
				flagInvert = false;
		return flagInvert;
	}

	@Override
	public void draw(RenderTarget renderTarget)
	{
		foundationCards.stream().forEach(card -> card.getDrawableCard().draw(renderTarget));
		centerCards.stream().forEach(card -> card.getDrawableCard().draw(renderTarget));
	}

	public void addCascade(List<CardManager> list)
	{
		foundationCards.addAll(list);
	}

	public void setSize(Vector2i windowSize)
	{
		visibleAreaDiagonal = (float) Math.sqrt(windowSize.x*windowSize.x + windowSize.y*windowSize.y)/4;
		center = new PositionComponent(windowSize.x/2, windowSize.y/2);
	}

}
