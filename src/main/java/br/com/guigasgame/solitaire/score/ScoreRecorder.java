package br.com.guigasgame.solitaire.score;

public class ScoreRecorder
{
	private ScoreRepository local;
	private ScoreRepository online;

	public ScoreRecorder()
	{
		local = new SerializerScoreRepository();
		online = new AwsApiGatewayScoreRepository();
	}

	public ScoreRepository getLocal()
	{
		return local;
	}

	public ScoreRepository getOnline()
	{
		return online;
	}
	
}
