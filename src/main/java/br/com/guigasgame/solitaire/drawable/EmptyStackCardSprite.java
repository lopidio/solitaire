package br.com.guigasgame.solitaire.drawable;

import org.jsfml.graphics.FloatRect;
import org.jsfml.graphics.IntRect;
import org.jsfml.graphics.RenderTarget;
import org.jsfml.graphics.Sprite;
import org.jsfml.graphics.Texture;
import org.jsfml.system.Vector2i;

import br.com.guigasgame.solitaire.card.Rank;
import br.com.guigasgame.solitaire.card.Suit;
import br.com.guigasgame.solitaire.position.PositionComponent;
import br.com.guigasgame.solitaire.resourcemanager.TextureResourceManager;
import br.com.guigasgame.solitaire.solitaire.card.CardSolitaire;

public class EmptyStackCardSprite implements CardDrawable
{
	private IntRect rect;
	private Sprite sprite;
	private Texture texture;

	public EmptyStackCardSprite()
	{
		super();
		
		texture = TextureResourceManager.getInstance().getResource("cardsSpriteSet.jpg");
		sprite = new Sprite(texture);
		
		int width = texture.getSize().x / Rank.values().length;
		int height = texture.getSize().y / (Suit.values().length + 1);
		
		int column = width*(Rank.three.getValue() - 1);
		int line = height*(Suit.values().length);
		
		rect = new IntRect(new Vector2i(column, line), new Vector2i(width, height));
		sprite.setOrigin(rect.width / 2, rect.height / 2);
		sprite.setTextureRect(rect);

	}

	public void draw(RenderTarget renderTarget)
	{
		renderTarget.draw(sprite);
	}

	public void setPosition(PositionComponent positionComponent)
	{
		sprite.setPosition(positionComponent.getX(), positionComponent.getY());
	}

	public boolean contains(int x, int y)
	{
		return sprite.getGlobalBounds().contains(x, y);
	}

	public FloatRect getSize()
	{
		return sprite.getLocalBounds();
	}

	public void slideToPosition(PositionComponent position)
	{
		sprite.setPosition(position.getX(), position.getY());
	}

	@Override
	public CardSolitaire getCard()
	{
		return null;
	}

	@Override
	public boolean isPriorityDrawing()
	{
		return false;
	}

	@Override
	public void setPriorityDrawing(boolean priorityDrawing)
	{
	}

	@Override
	public void reveal()
	{
	}

	@Override
	public void select()
	{
	}

	@Override
	public void unselect()
	{
	}

	@Override
	public void unreveal()
	{
		
	}

	@Override
	public void moveTo(PositionComponent newPosition, float slowFactor)
	{
		
	}

	@Override
	public boolean isNotMoving()
	{
		return true;
	}

}
