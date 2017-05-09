package br.com.guigasgame.solitaire.drawable;

import org.jsfml.graphics.Color;
import org.jsfml.graphics.Font;
import org.jsfml.graphics.RenderTarget;
import org.jsfml.graphics.Text;

import br.com.guigasgame.solitaire.position.PositionComponent;
import br.com.guigasgame.solitaire.resourcemanager.FontResourceManager;
import br.com.guigasgame.solitaire.score.ScorePositionModel;

public class PositionHUD implements Drawable
{
	private Text text;
	private Font font;

	public PositionHUD(String title, ScorePositionModel scorePositionModel, PositionComponent position)
	{
		super();
		font = FontResourceManager.getInstance().getResource("GOUDYSTO.TTF");
		text = new Text();
		text.setFont(font);
		text.setColor(Color.BLACK);
		text.setCharacterSize(22);
		text.setPosition(position.getX(), position.getY());
		text.setString(title + String.valueOf(scorePositionModel.getPosition() + 1) + "/" + String.valueOf(scorePositionModel.getTotal()));
		text.setOrigin(text.getLocalBounds().width/2, text.getLocalBounds().height/2);
	}
	
	@Override
	public void draw(RenderTarget renderTarget)
	{
		renderTarget.draw(text);
	}
}
