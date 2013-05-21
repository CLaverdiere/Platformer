package environment;

import org.newdawn.slick.Image;

public class NonMovingThing {
	private int height;
	private int width;
	private int[] position;
	private String spriteLoc;
	private Image sprite;
	
	public int[] getPosition() {
		return position;
	}
	public void setPosition(int[] position) {
		this.position = position;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public String getSpriteLoc() {
		return spriteLoc;
	}
	public void setSpriteLoc(String spriteLoc) {
		this.spriteLoc = spriteLoc;
	}
	public Image getSprite(){
		return this.sprite;
	}
	public void setSprite(Image sprite){
		this.sprite = sprite;
	}
}
