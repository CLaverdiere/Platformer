package environment;

public class WoodenPlatform extends Platform{

	// Wooden platforms have fixed width. They are meant to be small.
	public WoodenPlatform(int[] position) {
		super(50, 200, position, "res/wood.png");
	}
	
	// Specify original spriteLoc
	public WoodenPlatform(int[] position, String spriteLoc){
		super(35, 3000, position, spriteLoc);
	}

}
