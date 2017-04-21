package br.com.guigasgame.solitaire.score;

import java.util.List;

import com.amazonaws.SdkClientException;
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
				.withCredentials(new AWSStaticCredentialsProvider(credentials))
				.build();
		lambdaScoreService = LambdaInvokerFactory.builder()
				 .lambdaClient(solitaire)
				 .build(LambdaScoreService.class);
	}
	
	@Override
	public ScorePositionModel addScore(ScoreModel scoreModel)
	{
		try
		{
			String scoreId = lambdaScoreService.addScore(scoreModel);
			try
			{
				return lambdaScoreService.getPositionOfScore(scoreId);
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
			return lambdaScoreService.getTop(topNumber);
		}
		catch(SdkClientException exc)
		{
			System.out.println("Erro ao registrar score na nuvem");
			exc.printStackTrace();
		}
		return null;
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
