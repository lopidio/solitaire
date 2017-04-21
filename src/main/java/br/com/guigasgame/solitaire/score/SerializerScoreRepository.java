package br.com.guigasgame.solitaire.score;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SerializerScoreRepository implements ScoreRepository
{
	private final String FILE_NAME = "records";

	private List<ScoreModel> scores;

	public SerializerScoreRepository()
	{
		scores = new ArrayList<>();
		loadFile();
	}
	
	public static void main(String[] args)
	{
		try
		{
			SerializerScoreRepository serializerScoreRepository = new SerializerScoreRepository();
			List<ScoreModel> scores = serializerScoreRepository.scores;
			for (int i = 0; i < scores.size(); i++)
			{
				ScoreModel scoreModel = scores.get(i);
				System.out.println(scoreModel);
				
			}
		}
		catch (Exception e)
		{

			e.printStackTrace();

		}
	}

	@Override
	public ScorePositionModel addScore(ScoreModel scoreModel)
	{
		scores.add(scoreModel);
		Collections.sort(scores);
		try
		{
			FileOutputStream fileOut = new FileOutputStream(FILE_NAME);
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(scores);
			out.close();
			fileOut.close();
			System.out.printf("Serialized data is saved in: " + FILE_NAME);
			return new ScorePositionModel(scores.size() - scores.indexOf(scoreModel), scores.size());
		}
		catch (IOException i)
		{
			i.printStackTrace();
		}
		return new ScorePositionModel();
	}

	private boolean loadFile()
	{
		try
		{
			FileInputStream fileIn = new FileInputStream(FILE_NAME);
			ObjectInputStream in = new ObjectInputStream(fileIn);
			@SuppressWarnings("unchecked")
			List<ScoreModel> scores = (List<ScoreModel>) in.readObject();
			this.scores = scores;
			in.close();
			fileIn.close();
		}
		catch (IOException | ClassNotFoundException exception)
		{
			exception.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public List<ScoreModel> getTop(int topNumber)
	{
		List<ScoreModel> retorno = new ArrayList<>();
		for (int i = 0; i < topNumber && i < scores.size(); i++)
		{
			ScoreModel scoreModel = scores.get(i);
			retorno.add(scoreModel);
		}
		return retorno;
	}

}
