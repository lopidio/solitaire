package br.com.guigasgame.solitaire.solitaire.score;

import java.util.List;

public interface ScoreRepository
{
	public int addScore(ScoreModel scoreModel);
	public List<ScoreModel> getTop(int topNumber);
}
