package destruction;

import entities.MovingThing;

/**
 * Like it sounds, this is probably going to represent some sort of bullet, or rocket.
 * Highly likely to do some sort of damage on impact.
 * @author chris
 */
public class Projectile extends MovingThing {

	public Projectile(int height, int width, int mass, int[] position, double[] velocity){
		this.setHeight(height);
		this.setWidth(width);
		this.setMass(mass);
		this.setPosition(position);
		this.setVelocity(velocity);
	}

	public void moveLaterally(double init) {
		//bullet speed should be affected by mass
	}
	
	public void moveVertically(double init){
		
	}

}
