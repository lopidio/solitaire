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

@XmlRootElement
public class RecordRank
{
	@XmlElement
	List<Score> scores;

	public RecordRank()
	{
		scores = new ArrayList<>();
	}

	public void addScore(Score score)
	{
		scores.add(score);
		Collections.sort(scores);
	}
	
	public static void main(String[] args)
	{
		try
		{

//			Client client = Client.create();
//			WebResource webResource = client.resource("http://localhost:1880/records");
//
//			ClientResponse response = webResource.accept("application/json").get(ClientResponse.class);
//
//			if (response.getStatus() != 200)
//			{
//				throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
//			}
//
//			String output = response.getEntity(String.class);
//
//			System.out.println("Output from Server .... \n");
//			System.out.println(output);

		}
		catch (Exception e)
		{

			e.printStackTrace();

		}
	}
	
	public void save()
	{
		for (Score score : scores)
		{
			System.out.println(score);
		}
		try
		{

			File file = new File("recordRank.xml");
			JAXBContext jaxbContext = JAXBContext.newInstance(RecordRank.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

			// output pretty printed
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

			jaxbMarshaller.marshal(this, file);
			jaxbMarshaller.marshal(this, System.out);

		}
		catch (JAXBException e)
		{
			e.printStackTrace();
		}
	}

	static public RecordRank loadFromFile()
	{
		try
		{

			File file = new File("recordRank.xml");
			JAXBContext jaxbContext = JAXBContext.newInstance(RecordRank.class);

			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			RecordRank recordRank = (RecordRank) jaxbUnmarshaller.unmarshal(file);
			System.out.println(recordRank);
			return recordRank;

		}
		catch (JAXBException e)
		{
			e.printStackTrace();
		}
		return null;
	}
}
