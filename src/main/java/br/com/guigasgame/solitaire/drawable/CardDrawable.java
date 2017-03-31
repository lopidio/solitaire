package br.com.guigasgame.solitaire.drawable;


import org.jsfml.graphics.Color;
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
import br.com.guigasgame.solitaire.solitaire.card.CardSolitaire;
import br.com.guigasgame.solitaire.solitaire.card.CardSolitaireListener;

public class CardDrawable implements Drawable, CardSolitaireListener
{
	private IntRect revealedRect;
	private IntRect coverRect;
	private Sprite sprite;
	private Texture texture;
	private boolean revealed;
	private boolean selected;

	public CardDrawable(Card card)
	{
		super();
		
		selected = false;
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

	public void draw(RenderTarget renderTarget)
	{
		renderTarget.draw(sprite);
	}

	public void setPosition(PositionComponent positionComponent)
	{
		sprite.setPosition(positionComponent.getX(), positionComponent.getY());
	}

	private void updateTexture()
	{
		if (revealed)
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
		if (selected)
			sprite.setColor(new Color(128, 128, 128));
		else
			sprite.setColor(Color.WHITE);
	}

	@Override
	public void selectAction(CardSolitaire card)
	{
		selected = card.isSelected();
		updateColor();
	}

	@Override
	public void revealAction(CardSolitaire card)
	{
		revealed = card.isRevealed();
		updateTexture();
	}

	public boolean contains(int x, int y)
	{
		return sprite.getGlobalBounds().contains(x, y);
	}
	
	
}
