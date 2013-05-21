package environment;

public class Ground extends Platform{
	
	// Ground is the ground used in every level.
	public Ground(int[] position){
		super(35, 3000, position, "res/ground.png");
	}
	
	// Used to specify change in background
	public Ground(int[] position, String spriteLoc){
		super(35, 3000, position, spriteLoc);
	}

}
