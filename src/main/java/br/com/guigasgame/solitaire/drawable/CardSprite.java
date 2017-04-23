package br.com.guigasgame.solitaire.drawable;


import org.jsfml.graphics.Color;
import org.jsfml.graphics.FloatRect;
import org.jsfml.graphics.IntRect;
import org.jsfml.graphics.RenderTarget;
import org.jsfml.graphics.Sprite;
import org.jsfml.graphics.Texture;
import org.jsfml.system.Vector2f;
import org.jsfml.system.Vector2i;

import br.com.guigasgame.solitaire.card.Rank;
import br.com.guigasgame.solitaire.card.Suit;
import br.com.guigasgame.solitaire.config.ConfigFile;
import br.com.guigasgame.solitaire.position.PositionComponent;
import br.com.guigasgame.solitaire.resourcemanager.TextureResourceManager;
import br.com.guigasgame.solitaire.solitaire.card.CardSolitaire;
import br.com.guigasgame.solitaire.sound.SoundManager;

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
	private boolean animate;

	public CardSprite(CardSolitaire card)
	{
		super();
		this.card = card;
		animate = Boolean.parseBoolean(ConfigFile.getInstance().getValue("animationEnabled"));
		texture = TextureResourceManager.getInstance().getResource("cardsSpriteSet.jpg");
		sprite = new Sprite(texture);
		
		int width = texture.getSize().x / Rank.values().length;
		int height = texture.getSize().y / (Suit.values().length + 1);
		int revealedX = width*(card.getRank().getValue() - 1);
		int revealedY = height*(card.getSuit().getValue() - 1);
		
		int coverX = width*(Rank.four.getValue() - 1 + Integer.parseInt(ConfigFile.getInstance().getValue("cardCover")));
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
		return isNotMoving() && sprite.getGlobalBounds().contains(x, y);
	}

	@Override
	public boolean isNotMoving()
	{
		return null == destinyPosition;
	}

	public FloatRect getSize()
	{
		return sprite.getLocalBounds();
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
		SoundManager.getInstance().playCardFlip();
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
		SoundManager.getInstance().playCardFlip();
		updateTexture();
	}

	@Override
	public void moveTo(PositionComponent newPosition, float slowFactor)
	{
		this.slowFactor = slowFactor;
		this.destinyPosition = new Vector2f(newPosition.getX(), newPosition.getY());
	}
	
	public void slideToPosition(PositionComponent position)
	{
		SoundManager.getInstance().playCardMove();
		if (animate)
			moveTo(position, 4);
		else
			moveTo(position, 0);
	}


}
