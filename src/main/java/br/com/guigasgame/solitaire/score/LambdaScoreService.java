package br.com.guigasgame.solitaire.score;

import java.util.List;

import com.amazonaws.services.lambda.invoke.LambdaFunction;

public interface LambdaScoreService
{
	@LambdaFunction(functionName = "solitaireGetTop")
	List<ScoreModel> getTop(int topNum);

	@LambdaFunction(functionName = "solitaireAddScore")
	String addScore(ScoreModel input);

	@LambdaFunction(functionName = "solitaireGetPositionOfScore")
	ScorePositionModel getPositionOfScore(String scoreId);
}
