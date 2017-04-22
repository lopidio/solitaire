package br.com.guigasgame.solitaire.drawable;

import org.jsfml.graphics.Color;
import org.jsfml.graphics.Font;
import org.jsfml.graphics.RenderTarget;
import org.jsfml.graphics.Text;
import org.jsfml.system.Vector2i;

import br.com.guigasgame.solitaire.position.PositionComponent;
import br.com.guigasgame.solitaire.resourcemanager.FontResourceManager;
import br.com.guigasgame.solitaire.score.ScoreCounter;

public class TransactionCounterHUD implements Drawable
{
	
	private ScoreCounter scoreCounter;
	private Text text;
	private Font font;
	private PositionComponent proportion;

	public TransactionCounterHUD(PositionComponent windowSize, PositionComponent proportion, ScoreCounter scoreCounter)
	{
		super();
		this.scoreCounter = scoreCounter;
		font = FontResourceManager.getInstance().getResource("assets/GOUDYSTO.TTF");
		PositionComponent center = new PositionComponent(windowSize.getX() * proportion.getX(), windowSize.getY()* proportion.getY());
		this.proportion = proportion;
		text = new Text();
		text.setColor(new Color(128,  128, 128));
		text.setFont(font);
		text.setCharacterSize(20);
		text.setPosition(center.getX(), center.getY());
	}

	@Override
	public void draw(RenderTarget renderTarget)
	{
		text.setString(String.valueOf(scoreCounter.getTransactionCounter()));
		renderTarget.draw(text);
	}

	public void resizeEvent(Vector2i windowSize)
	{
		PositionComponent center = new PositionComponent(windowSize.x * proportion.getX(), windowSize.y* proportion.getY());
		text.setPosition(center.getX(), center.getY());
	}
}
