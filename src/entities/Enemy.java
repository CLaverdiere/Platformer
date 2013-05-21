package entities;

import destruction.Weapon;

/**
 * Represents any character that has reason to lay waste to character.
 * @author chris
 */
public class Enemy extends Lifeform{
	
	public Enemy(int height, int width, int mass, int[] position, double maxVelocity, String name, Weapon weapon) {
		super(height, width, mass, 100, position, new double[]{0, 0}, maxVelocity, 1.10, name, weapon, "res/enemy.png");
	}

	public String toString(){
		return "A " + this.getName() + ", measuring " + this.getHeight() + " by " + this.getWidth() + 
				" px, \n  awaits you at X: " + this.getPosition()[0] + ", Y: " + this.getPosition()[1] + 
				", holding a " + this.getWeapon().getName() + ".";
	}
	
	
}
