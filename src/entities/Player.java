package entities;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import destruction.Weapon;

/**
 * This will be the hero. Our hero.
 * @author Chris Laverdiere
 */
public class Player extends Lifeform{
	private int ammo;

	public Player(int height, int width, int mass, int[] position, double maxVelocity, String name, Weapon weapon) throws SlickException {
		super(height, width, mass, 100, position, new double[]{0, 0}, maxVelocity, 1.15, name, weapon, "res/guy.png");
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
		try{
		Player guy = new Player(300, 90, 220, new int[]{10, 10}, 2, "Duke", new Weapon("Pistol", 30));
		} catch(Exception e){
			e.printStackTrace();
		}
	}
	
}
