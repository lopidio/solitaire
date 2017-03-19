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
	private IntRect revealedRect;
	private IntRect coverRect;
	private Sprite sprite;
	private Texture texture;
	private boolean revealed;

	public CardSprite(Card card)
	{
		super();
		
		revealed = false;
		texture = TextureResourceManager.getInstance().getResource("asserts/cardsSpriteSet.jpg");
		sprite = new Sprite(texture);
		
		int width = texture.getSize().x / Rank.values().length;
		int height = texture.getSize().y / (Suit.values().length + 1);
		int x = width*(card.getRank().getValue() - 1);
		int y = height*(card.getSuit().getValue() - 1);
		
		int coverX = width*(Rank.six.getValue() - 1);
		int coverY = height*(Suit.values().length);
		
		revealedRect = new IntRect(new Vector2i(x, y), new Vector2i(width, height));
		coverRect = new IntRect(new Vector2i(coverX, coverY), new Vector2i(width, height));
		sprite.setTextureRect(coverRect);
		sprite.setOrigin(revealedRect.width / 2, revealedRect.height / 2);
	}

	public Sprite getSprite()
	{
		return sprite;
	}
	
	public void draw(RenderTarget renderTarget)
	{
		renderTarget.draw(sprite);
	}

	public void setPosition(PositionComponent positionComponent)
	{
		sprite.setPosition(positionComponent.getPosition());
	}

	public PositionComponent getPosition()
	{
		return new PositionComponent(sprite.getPosition());
	}

	public boolean isRevealed()
	{
		return revealed;
	}

	public void flip()
	{
		revealed = !revealed;
		if (isRevealed())
		{
			sprite.setTextureRect(revealedRect);
		}
		else
		{
			sprite.setTextureRect(coverRect);
		}
	}
	
	
}
