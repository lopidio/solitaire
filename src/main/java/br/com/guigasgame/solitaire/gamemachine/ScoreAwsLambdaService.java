package br.com.guigasgame.solitaire.gamemachine;

import java.util.List;

import com.amazonaws.services.lambda.invoke.LambdaFunction;

import br.com.guigasgame.solitaire.solitaire.score.ScoreModel;

public interface ScoreAwsLambdaService
{
	@LambdaFunction(functionName = "getTop")
	List<ScoreModel> getTop(int topNum);

	@LambdaFunction(functionName = "solitaireAddScore")
	int addScore(ScoreModel input);
}
