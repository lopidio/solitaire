package br.com.guigasgame.solitaire.solitaire.score;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Score implements Comparable<Score>
{
	@XmlElement
	final private int score;
	@XmlElement
	final private int transactionCounter;
	@XmlElement
	final private float totalTime;

	//Do not use. JaxB purposes
	public Score()
	{
		this(0, 0, 0);
	}

	public Score(int score, int transactionCounter, float totalTime)
	{
		super();
		this.score = score;
		this.transactionCounter = transactionCounter;
		this.totalTime = totalTime;
	}

	public int getScore()
	{
		return score;
	}

	public int getTransactionCounter()
	{
		return transactionCounter;
	}

	public float getTotalTime()
	{
		return totalTime;
	}

	@Override
	public int compareTo(Score other)
	{
		if (other.score != score )
		{
			return score - other.score;
		}
		if (other.totalTime != totalTime )
		{
			return (int) (other.totalTime - totalTime);
		}
		if (other.transactionCounter != transactionCounter )
		{
			return other.transactionCounter - transactionCounter;
		}
		return 0;
	}

	@Override
	public String toString()
	{
		return "Score: " + score + "; time: " + totalTime + "; moves: " + transactionCounter;
	}
}
