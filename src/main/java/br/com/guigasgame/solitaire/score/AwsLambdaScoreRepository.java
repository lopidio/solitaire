package br.com.guigasgame.solitaire.score;

import java.util.List;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.lambda.AWSLambda;
import com.amazonaws.services.lambda.AWSLambdaClientBuilder;
import com.amazonaws.services.lambda.invoke.LambdaInvokerFactory;

public class AwsLambdaScoreRepository implements ScoreRepository
{

	private LambdaScoreService lambdaScoreService;
	
	public AwsLambdaScoreRepository()
	{
		BasicAWSCredentials awsCreds = new BasicAWSCredentials("AKIAJBIK6GMSOL3JIOZA", "MqyhvgKOxY58o5QWU5hhz0xOkYXq/VikQAX4p1Av");

		AWSLambda solitaire = AWSLambdaClientBuilder.standard().withRegion(Regions.US_WEST_2)
				.withCredentials(new AWSStaticCredentialsProvider(awsCreds))
				.build();
		lambdaScoreService = LambdaInvokerFactory.builder()
				 .lambdaClient(solitaire)
				 .build(LambdaScoreService.class);
	}
	
	@Override
	public int addScore(ScoreModel scoreModel)
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
			
//			AmazonS3 client = AmazonS3ClientBuilder.standard()//.withRegion(Regions.US_WEST_2)
//						        .withCredentials(new AWSStaticCredentialsProvider(awsCreds))
//						        .build();
	

			ScoreModel score = new ScoreModel(200, 132, (float) 112.4, "Guilherme Moraes");
			System.out.println("Position: " + new AwsLambdaScoreRepository().addScore(score));
		}
		catch (Exception e)
		{

			e.printStackTrace();

		}
	}
	

}
