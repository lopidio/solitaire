package br.com.guigasgame.solitaire.score;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.amazonaws.SdkClientException;

import br.com.guigasgame.solitaire.score.aws.SolitaireService;
import br.com.guigasgame.solitaire.score.aws.model.GetScoresRequest;
import br.com.guigasgame.solitaire.score.aws.model.GetScoresResult;
import br.com.guigasgame.solitaire.score.aws.model.GetScoresScoreidRequest;
import br.com.guigasgame.solitaire.score.aws.model.GetScoresScoreidResult;
import br.com.guigasgame.solitaire.score.aws.model.PostScoresRequest;
import br.com.guigasgame.solitaire.score.aws.model.PostScoresResult;
import br.com.guigasgame.solitaire.score.aws.model.ScoreListModel;
import br.com.guigasgame.solitaire.score.aws.model.ScoresItem;

public class AwsApiGatewayScoreRepository implements ScoreRepository
{

	SolitaireService client;
	
	public AwsApiGatewayScoreRepository()
	{
		client = SolitaireService.builder().build();
	}
	
	@Override
	public ScorePositionModel addScore(ScoreModel scoreModel)
	{
		try
		{
			br.com.guigasgame.solitaire.score.aws.model.ScoreModel awsScoreModel = new br.com.guigasgame.solitaire.score.aws.model.ScoreModel();
			awsScoreModel.setDate((int) scoreModel.getDate().getTime());
			awsScoreModel.setPlayerName(scoreModel.getName());
			awsScoreModel.setScore(scoreModel.getScore());
			awsScoreModel.setTotalTime((double) scoreModel.getTotalTime());
			awsScoreModel.setTransactionCounter(scoreModel.getTransactionCounter());
			PostScoresRequest postScoresRequest = new PostScoresRequest();
			postScoresRequest.setScoreModel(awsScoreModel);
			PostScoresResult postScores = client.postScores(postScoresRequest);
			try
			{
				GetScoresScoreidResult scoreIdResult = client.getScoresScoreid(new GetScoresScoreidRequest().scoreid(postScores.getScoreIdModel().getItemId()));
//				br.com.guigasgame.solitaire.score.aws.model.ScorePositionModel metadata = scoreidResult.getScorePositionModel();
				ScorePositionModel scorePositionModel = new ScorePositionModel();
				scorePositionModel.setPosition(scoreIdResult.getScorePositionModel().getIndex());
				scorePositionModel.setTotal(scoreIdResult.getScorePositionModel().getTotal());
				return scorePositionModel;
			}
			catch(SdkClientException exc)
			{
				System.out.println("Erro ao recuperar posição do score na nuvem");
				exc.printStackTrace();
			}
		}
		catch(SdkClientException exc)
		{
			System.out.println("Erro ao registrar score na nuvem");
			exc.printStackTrace();
		}
		return null;
	}

	@Override
	public List<ScoreModel> getTop(int topNumber)
	{
		try
		{
			GetScoresRequest getScoresRequest = new GetScoresRequest();
			getScoresRequest.setNum(String.valueOf(topNumber));
			GetScoresResult resultGetScores = client.getScores(getScoresRequest);
			ScoreListModel scoreListModel = resultGetScores.getScoreListModel();
			List<ScoresItem> scores = scoreListModel.getScores();
			
			List<ScoreModel> retorno = new ArrayList<>();
			for (ScoresItem scoresItem : scores)
			{
				long epoch = Long.parseLong(scoresItem.getAwsDate());
				ScoreModel scoreModel = new ScoreModel(scoresItem.getScore(), scoresItem.getTransactionCounter(),
						scoresItem.getTotalTime().floatValue(), new Date(epoch), scoresItem.getPlayerName());
				retorno.add(scoreModel);
			}
			
			return retorno;
		}
		catch(SdkClientException exc)
		{
			System.out.println("Erro ao capturar score da nuvem");
			exc.printStackTrace();
		}
		return null;
	}

	public static void main(String[] args)
	{
		try
		{
			AwsApiGatewayScoreRepository awsApiGatewayScoreRepository = new AwsApiGatewayScoreRepository();
			List<ScoreModel> top = awsApiGatewayScoreRepository.getTop(10);
			top.stream().forEach(score -> System.out.println(score.toString()));
		}
		catch (Exception e)
		{

			e.printStackTrace();

		}
	}
	

}
