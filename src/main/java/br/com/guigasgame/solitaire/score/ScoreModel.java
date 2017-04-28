package br.com.guigasgame.solitaire.score;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="score")
public class ScoreModel implements Comparable<ScoreModel>, Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@XmlElement
	final private int score;
	@XmlElement
	final private int transactionCounter;
	@XmlElement
	final private float totalTime;
	@XmlElement
	final private Date date;
	@XmlElement
	final private String name;

	//Do not use. JaxB purposes
	public ScoreModel()
	{
		this(0, 0, 0, "");
	}

	public ScoreModel(int score, int transactionCounter, float totalTime, String name)
	{
		super();
		this.score = score;
		this.transactionCounter = transactionCounter;
		this.totalTime = totalTime;
		this.name = name;
		date = new Date();
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

	public Date getDate()
	{
		return date;
	}
	
	public String getName()
	{
		return name;
	}

	@Override
	public int compareTo(ScoreModel other)
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
	public boolean equals(Object obj)
	{
		if (obj == null)
		{
			return false;
		}
		if (!ScoreModel.class.isAssignableFrom(obj.getClass()))
		{
			return false;
		}
		final ScoreModel other = (ScoreModel) obj;
		if (this.compareTo(other) == 0)
		{
			return name.equals(other.name);
		}
		return false;
	}

	@Override
	public String toString()
	{
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		return "Name: " + name + "; Score: " + score + "; time: " + totalTime + "; moves: " + transactionCounter + "; at: " + dateFormat.format(date);
	}
}
