package br.com.guigasgame.solitaire.solitaire.score;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="recordRank")
public class XmlScoreRepository implements ScoreRepository
{
	private final String FILE_NAME = "recordRank.xml";
	
	@XmlElement
	private List<ScoreModel> scores;

	public XmlScoreRepository()
	{
		scores = new ArrayList<>();
	}
	

	@Override
	public int addScore(ScoreModel scoreModel)
	{
		loadScores();
		scores.add(scoreModel);
		Collections.sort(scores);
		try
		{
			File file = new File(FILE_NAME);
			JAXBContext jaxbContext = JAXBContext.newInstance(XmlScoreRepository.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
			// output pretty printed
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			jaxbMarshaller.marshal(this, file);
			return scores.size() - scores.indexOf(scoreModel);
		}
		catch (JAXBException e)
		{
			e.printStackTrace();
		}
		return -1;
	}


	public boolean loadScores()
	{
		try
		{
			File file = new File(FILE_NAME);
			JAXBContext jaxbContext = JAXBContext.newInstance(XmlScoreRepository.class);

			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			XmlScoreRepository me = (XmlScoreRepository) jaxbUnmarshaller.unmarshal(file);
			scores = me.scores;
			return true;
		}
		catch (JAXBException e)
		{
			e.printStackTrace();
		}
		return false;
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
	
	public static void main(String[] args)
	{
		try
		{
			XmlScoreRepository serializerScoreRepository = new XmlScoreRepository();
			serializerScoreRepository.loadScores();
			for (int i = 0; i < serializerScoreRepository.scores.size(); i++)
			{
				ScoreModel scoreModel = serializerScoreRepository.scores.get(i);
				System.out.println(scoreModel);
				
			}
		}
		catch (Exception e)
		{

			e.printStackTrace();

		}
	}

}
