package br.com.guigasgame.solitaire.score;

import java.util.List;

public interface ScoreRepository
{
	public ScorePositionModel addScore(ScoreModel scoreModel);
	public List<ScoreModel> getTop(int topNumber);
}
