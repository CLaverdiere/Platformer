package entities;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import destruction.Weapon;

/**
 * Represents any sort of AI, such as enemies, allies, moon-bears, etc.
 * @author Chris Laverdiere
 */
public class Lifeform extends MovingThing {
	private String name;
	private Weapon weapon;
	private int health;
	private int hops;
	private boolean onPlatform;
	private boolean isAllowedToWalk;
	private boolean isInWall;
	private boolean isJumping;
	
	public Lifeform(int height, int width, int mass, int hops, int[] position, double[] velocity, double maxVelocity, double accelConstant, String name, Weapon weapon, String spriteLoc){
		this.setHeight(height);
		this.setWidth(width);
		this.setMass(mass);
		this.setPosition(position);
		this.setVelocity(velocity);
		this.setMaxVelocity(maxVelocity);
		this.setAccelConstant(accelConstant);
		this.hops = hops;
		this.name = name;
		this.weapon = weapon;
		this.setOnPlatform(true);
		this.setAllowedToWalk(true);
		this.setInWall(false);
		this.setSpriteLoc(spriteLoc);
		try {
			this.setSprite(new Image(spriteLoc));
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}
	
	public void walk(double init) {
		if (this.isAllowedToWalk){
			if (this.getVelocity()[0] == 0 
					// Dirty way to check if the initiated velocity is the opposite sign of the current velocity.
					|| (this.getVelocity()[0] <= 0 && init >= 0) 
					|| (this.getVelocity()[0] >= 0 && init <= 0)){
				this.setVelocity(new double[]{init, this.getVertVelocity()});
			}
			// Accelerate until the maximum velocity is reached
			else if (Math.abs(this.getVelocity()[0]) < this.getMaxVelocity()){
				this.scaleVelocity(this.getAccelConstant(), 1);
			}
		}
	}
	
	public void jump(){
		// Break out of object floor and then update velocity.
		this.incrementPosition(0, -50);
		this.setJumping(true);
		this.setOnPlatform(false);
		this.setVertVelocity(this.getHops() * -.15);
	}
	
	public boolean isJumping() {
		return isJumping;
	}

	public void setJumping(boolean isJumping) {
		this.isJumping = isJumping;
	}

	public void updateVelocity(int delta){
		// EFFECTS DUE TO GRAVITY
		if (this.isOnPlatform() == false){
			this.setVertVelocity(this.getVertVelocity() + .05 * delta);
		}
		
		// JUMPING changes
		if (this.getVertVelocity() >= 0){
			this.setJumping(false);
		}
	}
	
	public boolean isOnPlatform() {
		return onPlatform;
	}

	public void setOnPlatform(boolean onPlatform) {
		this.onPlatform = onPlatform;
		if (onPlatform == true){
			this.setVelocity(new double[]{this.getVelocity()[0], 0});
		}
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public int getHops() {
		return hops;
	}

	public void setHops(int hops) {
		this.hops = hops;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Weapon getWeapon() {
		return weapon;
	}

	public void setWeapon(Weapon weapon) {
		this.weapon = weapon;
	}

	public boolean isAllowedToWalk() {
		return isAllowedToWalk;
	}

	public void setAllowedToWalk(boolean isAllowedToWalk) {
		this.isAllowedToWalk= isAllowedToWalk;
		this.setLatVelocity(0.0);
	}

	public boolean isInWall() {
		return isInWall;
	}

	public void setInWall(boolean isInWall) {
		this.isInWall = isInWall;
	}
	
	// Direction should take 1 or -1 for right or left.
	public void moveOutOfWall(double dir){
		// Move out to right side
		if (dir > 0.0){
			this.setPosition(new int[] {this.getPosition()[0] + (int) Math.ceil(dir) + 5, this.getPosition()[1]});
		}
		// Move out to left side
		else if (dir < 0.0){
			this.setPosition(new int[] {this.getPosition()[0] - (int) Math.floor(dir) - 5, this.getPosition()[1]});
		}
	}
	
}
