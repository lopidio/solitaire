package br.com.guigasgame.solitaire.score;

import java.util.List;

public class ScoreRecorder
{
	private ScoreRepository local;
	private ScoreRepository online;

	public ScoreRecorder()
	{
		local = new SerializerScoreRepository();
		online = new AwsApiGatewayScoreRepository();
	}

	public ScorePositionModel addScoreLocal(ScoreModel scoreModel)
	{
		return local.addScore(scoreModel);
	}

	public List<ScoreModel> getTopLocal(int topNumber)
	{
		return local.getTop(topNumber);
	}

	public ScorePositionModel addScoreOnline(ScoreModel scoreModel)
	{
		return online.addScore(scoreModel);
	}

	public List<ScoreModel> getTopOnline(int topNumber)
	{
		return online.getTop(topNumber);
	}
	
}
