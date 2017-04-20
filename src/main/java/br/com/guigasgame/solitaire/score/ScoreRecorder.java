package br.com.guigasgame.solitaire.score;

import java.util.ArrayList;
import java.util.List;

public class ScoreRecorder implements ScoreRepository
{
	List<ScoreRepository> repositories;

	public ScoreRecorder()
	{
		repositories = new ArrayList<>();
		repositories.add(new XmlScoreRepository());
		repositories.add(new SerializerScoreRepository());
	}

	@Override
	public int addScore(ScoreModel scoreModel)
	{
		for (int i = 1; i < repositories.size(); i++)
		{
			repositories.get(i).addScore(scoreModel);
		}
		if (repositories.size() > 0)
			return repositories.get(0).addScore(scoreModel);
		return -1;
	}

	@Override
	public List<ScoreModel> getTop(int topNumber)
	{
		if (repositories.size() > 0)
			return repositories.get(0).getTop(topNumber);
		return null;
	}
	
}
