package br.com.guigasgame.solitaire.drawable;


import org.jsfml.graphics.Color;
import org.jsfml.graphics.FloatRect;
import org.jsfml.graphics.IntRect;
import org.jsfml.graphics.RenderTarget;
import org.jsfml.graphics.Sprite;
import org.jsfml.graphics.Texture;
import org.jsfml.system.Vector2f;
import org.jsfml.system.Vector2i;

import br.com.guigasgame.solitaire.card.Card;
import br.com.guigasgame.solitaire.card.Rank;
import br.com.guigasgame.solitaire.card.Suit;
import br.com.guigasgame.solitaire.position.PositionComponent;
import br.com.guigasgame.solitaire.resourcemanager.TextureResourceManager;
import br.com.guigasgame.solitaire.solitaire.card.CardSolitaire;

public class CardSprite implements CardDrawable
{
	private IntRect revealedRect;
	private IntRect coverRect;
	private Sprite sprite;
	private Texture texture;
	private CardSolitaire card;
	private boolean priorityDrawing;
	private Vector2f destinyPosition;
	private float slowFactor;

	public CardSprite(Card card)
	{
		super();
		this.card = (CardSolitaire) card;
		
		texture = TextureResourceManager.getInstance().getResource("assets/cardsSpriteSet.jpg");
		sprite = new Sprite(texture);
		
		int width = texture.getSize().x / Rank.values().length;
		int height = texture.getSize().y / (Suit.values().length + 1);
		int revealedX = width*(card.getRank().getValue() - 1);
		int revealedY = height*(card.getSuit().getValue() - 1);
		
		int coverX = width*(Rank.six.getValue() - 1);
		int coverY = height*(Suit.values().length);
		
		revealedRect = new IntRect(new Vector2i(revealedX, revealedY), new Vector2i(width, height));
		coverRect = new IntRect(new Vector2i(coverX, coverY), new Vector2i(width, height));
		sprite.setOrigin(revealedRect.width / 2, revealedRect.height / 2);
		slowFactor = 1;
		updateColor();
		updateTexture();
	}

	public void draw(RenderTarget renderTarget)
	{
		checkSmoothRepositioning();
		renderTarget.draw(sprite);
	}

	private void checkSmoothRepositioning()
	{
		if (null != destinyPosition)
		{
			Vector2f sub = Vector2f.sub(sprite.getPosition(), destinyPosition);
			if (sub.x*sub.x + sub.y * sub.y >= 1)
			{
				Vector2f newPosition = new Vector2f((destinyPosition.x + sprite.getPosition().x*slowFactor)/(1 + slowFactor), 
													(destinyPosition.y + sprite.getPosition().y*slowFactor)/(1 + slowFactor));
				sprite.setPosition(newPosition);
			}
			else
				destinyPosition = null;
		}
	}

	public void setPosition(PositionComponent positionComponent)
	{
		sprite.setPosition(positionComponent.getX(), positionComponent.getY());
	}

	private void updateTexture()
	{
		if (card.isRevealed())
		{
			sprite.setTextureRect(revealedRect);
		}
		else
		{
			sprite.setTextureRect(coverRect);
		}
	}

	private void updateColor()
	{
		if (card.isSelected())
			sprite.setColor(new Color(128, 128, 128));
		else
			sprite.setColor(Color.WHITE);
	}

	public boolean contains(int x, int y)
	{
		return sprite.getGlobalBounds().contains(x, y);
	}

	public FloatRect getSize()
	{
		return sprite.getLocalBounds();
	}

	public void moveTo(PositionComponent position)
	{
		moveTo(position, 4);
	}

	@Override
	public CardSolitaire getCard()
	{
		return card;
	}

	@Override
	public boolean isPriorityDrawing()
	{
		return priorityDrawing;
	}

	@Override
	public void setPriorityDrawing(boolean priorityDrawing)
	{
		this.priorityDrawing = priorityDrawing;
	}

	@Override
	public void reveal()
	{
		updateTexture();
	}

	@Override
	public void select()
	{
		updateColor();
	}

	@Override
	public void unselect()
	{
		updateColor();
	}

	@Override
	public void unreveal()
	{
		updateTexture();
	}

	@Override
	public void moveTo(PositionComponent newPosition, float slowFactor)
	{
		this.slowFactor = slowFactor;
		this.destinyPosition = new Vector2f(newPosition.getX(), newPosition.getY());
	}

}
