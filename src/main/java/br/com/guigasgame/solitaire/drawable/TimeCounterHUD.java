package br.com.guigasgame.solitaire.drawable;

import java.text.DecimalFormat;

import org.jsfml.graphics.Color;
import org.jsfml.graphics.Font;
import org.jsfml.graphics.RenderTarget;
import org.jsfml.graphics.Text;
import org.jsfml.system.Vector2i;

import br.com.guigasgame.solitaire.position.PositionComponent;
import br.com.guigasgame.solitaire.resourcemanager.FontResourceManager;
import br.com.guigasgame.solitaire.score.ScoreCounter;

public class TimeCounterHUD implements Drawable
{
	private Text text;
	private Font font;
	private PositionComponent proportion;
	private DecimalFormat decimalFormat;
	private ScoreCounter scoreCounter;

	public TimeCounterHUD(PositionComponent windowSize, PositionComponent proportion, ScoreCounter scoreCounter)
	{
		super();
		font = FontResourceManager.getInstance().getResource("GOUDYSTO.TTF");
		PositionComponent center = new PositionComponent(windowSize.getX() * proportion.getX(), windowSize.getY()* proportion.getY());
		this.proportion = proportion;
		text = new Text();
		text.setFont(font);
		text.setPosition(center.getX(), center.getY());
		text.setColor(Color.BLACK);
		text.setCharacterSize(20);
		decimalFormat = new DecimalFormat();
		decimalFormat.setMaximumFractionDigits(1);
		decimalFormat.setMinimumFractionDigits(1);
		this.scoreCounter = scoreCounter;
	}

	@Override
	public void draw(RenderTarget renderTarget)
	{
		text.setString(decimalFormat.format(scoreCounter.getTotalTime()));
		renderTarget.draw(text);
	}

	public void resizeEvent(Vector2i windowSize)
	{
		PositionComponent center = new PositionComponent(windowSize.x * proportion.getX(), windowSize.y* proportion.getY());
		text.setPosition(center.getX(), center.getY());
	}
}
