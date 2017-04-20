package br.com.guigasgame.solitaire.score;

import java.util.List;

import com.amazonaws.services.lambda.invoke.LambdaFunction;

public interface ScoreAwsLambdaService
{
	@LambdaFunction(functionName = "getTop")
	List<ScoreModel> getTop(int topNum);

	@LambdaFunction(functionName = "solitaireAddScore")
	int addScore(ScoreModel input);
}
