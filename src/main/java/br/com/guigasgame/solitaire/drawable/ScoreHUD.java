package br.com.guigasgame.solitaire.drawable;

import org.jsfml.graphics.Font;
import org.jsfml.graphics.RenderTarget;
import org.jsfml.graphics.Text;
import org.jsfml.system.Vector2i;

import br.com.guigasgame.solitaire.position.PositionComponent;
import br.com.guigasgame.solitaire.resourcemanager.FontResourceManager;
import br.com.guigasgame.solitaire.score.ScoreCounter;

public class ScoreHUD implements Drawable
{
	private ScoreCounter scoreCounter;
	private Text text;
	private Font font;
	private PositionComponent proportion;
	private float currentShownScore;

	public ScoreHUD(PositionComponent windowSize, PositionComponent proportion, ScoreCounter scoreCounter)
	{
		super();
		this.scoreCounter = scoreCounter;
		font = FontResourceManager.getInstance().getResource("assets/GOUDYSTO.TTF");
		PositionComponent center = new PositionComponent(windowSize.getX() * proportion.getX(), windowSize.getY()* proportion.getY());
		this.proportion = proportion;
		text = new Text();
		text.setFont(font);
		text.setCharacterSize(20);
		text.setPosition(center.getX(), center.getY());
	}

	@Override
	public void draw(RenderTarget renderTarget)
	{
		currentShownScore += (scoreCounter.getScore() - currentShownScore)*0.05;
		text.setString(String.valueOf(Math.round(currentShownScore)));
		renderTarget.draw(text);
	}

	public void resizeEvent(Vector2i windowSize)
	{
		PositionComponent center = new PositionComponent(windowSize.x * proportion.getX(), windowSize.y* proportion.getY());
		text.setPosition(center.getX(), center.getY());
	}

}
