package br.com.guigasgame.solitaire.score;

import java.util.List;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.SystemPropertiesCredentialsProvider;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.lambda.AWSLambda;
import com.amazonaws.services.lambda.AWSLambdaClientBuilder;
import com.amazonaws.services.lambda.invoke.LambdaInvokerFactory;

public class AwsLambdaScoreRepository implements ScoreRepository
{

	private LambdaScoreService lambdaScoreService;
	
	public AwsLambdaScoreRepository()
	{
		AWSCredentials credentials = new SystemPropertiesCredentialsProvider().getCredentials();
		
		
		AWSLambda solitaire = AWSLambdaClientBuilder.standard().withRegion(Regions.US_WEST_2)
//				.withCredentials(new AWSStaticCredentialsProvider(awsCreds))
				.withCredentials(new AWSStaticCredentialsProvider(credentials))
				.build();
		lambdaScoreService = LambdaInvokerFactory.builder()
				 .lambdaClient(solitaire)
				 .build(LambdaScoreService.class);
	}
	
	@Override
	public ScorePositionModel addScore(ScoreModel scoreModel)
	{
		String scoreId = lambdaScoreService.addScore(scoreModel);
		return lambdaScoreService.getPositionOfScore(scoreId);
	}

	@Override
	public List<ScoreModel> getTop(int topNumber)
	{
		return lambdaScoreService.getTop(topNumber);
	}

	public static void main(String[] args)
	{
		try
		{
			List<ScoreModel> position = new AwsLambdaScoreRepository().getTop(10);
			position.stream().forEachOrdered(p -> System.out.println(p));
		}
		catch (Exception e)
		{

			e.printStackTrace();

		}
	}
	

}
