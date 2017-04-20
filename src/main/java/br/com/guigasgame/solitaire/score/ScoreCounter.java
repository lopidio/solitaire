package br.com.guigasgame.solitaire.score;

import br.com.guigasgame.solitaire.solitaire.stack.SolitaireCardStackType;
import br.com.guigasgame.solitaire.updatable.TimeUpdatable;

public class ScoreCounter implements TimeUpdatable
{
	private int score;
	private float scoreTimeCounter;
	private int prevScore;
	private int transactionCounter;
	private float totalTime;
	

	public ScoreCounter()
	{
		super();
		score = 0;
	}

	/*
			Waste to Foundation	10
			Tableau to Foundation	10

			Waste to Tableau	5
			Turn over Tableau card	5
			Foundation to Tableau	−15
			Recycle waste when playing by ones	−100 (minimum score is 0)
	 */
	/*
			Time can also play a factor in Windows Solitaire, if the Timed game option is selected. 
			For every 10 seconds of play, 2 points are taken away. 
			Bonus points are calculated with the formula of 700,000 / (seconds to finish) if the game takes more than 30 seconds. 
			If the game takes less than 30 seconds, no bonus points are awarded.
	 */
	public void registerTransaction(SolitaireCardStackType from, SolitaireCardStackType to)
	{
		++transactionCounter;
		if (to == SolitaireCardStackType.foundation)
			score += 10;
		else if (from == SolitaireCardStackType.waste && to == SolitaireCardStackType.tableau)
			score += 5;
		else if (from == SolitaireCardStackType.foundation && to == SolitaireCardStackType.tableau)
			score = Math.max(0, score - 15);
		else if (from == SolitaireCardStackType.waste && to == SolitaireCardStackType.stock)
			score = Math.max(0, score - 100);
	}

	public void registerCardRevelation()
	{
		score += 5;
	}

	public int getScore()
	{
		return score;
	}

	@Override
	public void update(float deltaTime)
	{
		scoreTimeCounter += deltaTime;
		totalTime += deltaTime;
		if (scoreTimeCounter >= 10)
		{
			scoreTimeCounter -= 10;
			score = Math.max(0, score - 2);
		}
		if (prevScore != score)
			System.out.println("Current score: " + score);
		prevScore = score;
	}

	public float getTotalTime()
	{
		return totalTime;
	}

	public int getTransactionCounter()
	{
		return transactionCounter;
	}
	

}
