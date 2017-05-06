package br.com.guigasgame.solitaire.gui;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import br.com.guigasgame.solitaire.score.ScoreModel;

public class ScoreTableTransformer
{

	public String[][] perform(List<ScoreModel> top)
	{
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

		String[][] methodReturn = new String[top.size()][getHeaders().length];
		for (int i = 0; i < top.size(); i++)
		{
			ScoreModel scoreModel = top.get(i);
			String[] line = new String[getHeaders().length];
			line[0] = "#" + String.valueOf(i + 1);
			line[1] = scoreModel.getName();
			line[2] = String.valueOf(scoreModel.getScore());
			line[3] = dateFormat.format(scoreModel.getDate());
			line[4] = String.valueOf(scoreModel.getTotalTime());
			line[5] = String.valueOf(scoreModel.getTransactionCounter());
			
			methodReturn[i] = line;
			
		}
		return methodReturn;
	}

	public String[] getHeaders()
	{
		return new String[] { "Position", "Name", "Score", "Date", "Time", "Moves" };
	}

}
