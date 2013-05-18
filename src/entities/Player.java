package entities;

import destruction.Weapon;

/**
 * This will be the hero. Our hero.
 * @author Chris Laverdiere
 */
public class Player extends Lifeform{
	private int ammo;

	public Player(int height, int width, int mass, int[] position, double maxVelocity, String name, Weapon weapon) {
		super(height, width, mass, 100, position, new double[]{0, 0}, maxVelocity, 1.15, name, weapon);
		this.ammo = weapon.getCapacity();
	}

	public String toString(){
		return this.getName() + ", measuring " + this.getHeight() + " by " + this.getWidth() + 
				" px, \n  stands fearlessly at X: " + this.getPosition()[0] + ", Y: " + this.getPosition()[1] + 
				", holding his trademark " + this.getWeapon().getName() + " (" +  getAmmo() + "/" + getWeapon().getCapacity() + ").";
	}
	
	public int getAmmo(){
		return ammo;
	}
	
	public void setAmmo(int ammo){
		this.ammo = ammo;
	}
	
	public static void main(String[] args){
		Player duke = new Player(300, 90, 220, new int[]{10, 10}, 2, "Duke", new Weapon("Pistol", 30));
	}
	
}
