package br.com.guigasgame.solitaire.drawable;

import org.jsfml.graphics.IntRect;
import org.jsfml.graphics.RenderTarget;
import org.jsfml.graphics.Sprite;
import org.jsfml.graphics.Texture;
import org.jsfml.system.Vector2i;

import br.com.guigasgame.solitaire.card.Card;
import br.com.guigasgame.solitaire.card.Rank;
import br.com.guigasgame.solitaire.card.Suit;
import br.com.guigasgame.solitaire.position.PositionComponent;
import br.com.guigasgame.solitaire.resourcemanager.TextureResourceManager;

public class CardSprite implements Drawable
{
	private IntRect frameRect;
	private Sprite sprite;
	private Texture texture;

	public CardSprite(Card card)
	{
		super();
		
		texture = TextureResourceManager.getInstance().getResource("asserts/cardsSpriteSet.jpg");
		sprite = new Sprite(texture);
		
		int width = texture.getSize().x / Rank.values().length;
		int height = texture.getSize().y / Suit.values().length;
		int x = width*(card.getRank().getValue() - 1);
		int y = height*(card.getSuit().getValue() - 1);
		
		frameRect = new IntRect(new Vector2i(x, y), new Vector2i(width, height));
		sprite.setTextureRect(frameRect);
		sprite.setOrigin(frameRect.width / 2, frameRect.height / 2);
	}

	public Sprite getSprite()
	{
		return sprite;
	}
	
	public void draw(RenderTarget renderTarget)
	{
		renderTarget.draw(sprite);
//		sprite.draw(renderTarget, null);
	}

	public void setPosition(PositionComponent positionComponent)
	{
		sprite.setPosition(positionComponent.getPosition());
	}

	public PositionComponent getPosition()
	{
		return new PositionComponent(sprite.getPosition());
	}
	
	
}
