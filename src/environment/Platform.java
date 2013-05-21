package environment;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public abstract class Platform extends NonMovingThing{

	public Platform(int height, int width, int[] position, String spriteLoc){
		this.setHeight(height);
		this.setWidth(width);
		this.setPosition(position);
		this.setSpriteLoc(spriteLoc);
		try {
			this.setSprite(new Image(spriteLoc));
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}
}
