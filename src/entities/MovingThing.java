package entities;

/**
 * Class for all moving things in the game.
 * @author chris
 *
 */
public abstract class MovingThing {
	private int height;
	private int width;
	private int mass;
	private int[] position;
	private double[] velocity;
	private double maxVelocity;
	private double accelConstant;
	//private Image sprite;
	
	public double getAccelConstant() {
		return accelConstant;
	}

	public void setAccelConstant(double accelConstant) {
		this.accelConstant = accelConstant;
	}

	public double getMaxVelocity() {
		return maxVelocity;
	}

	public void setMaxVelocity(double maxVelocity) {
		this.maxVelocity = maxVelocity;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getMass() {
		return mass;
	}

	public void setMass(int mass) {
		this.mass = mass;
	}

	public int[] getPosition() {
		return position;
	}
	
	public int getPositionX() {
		return position[0];
	}
	
	public int getPositionY() {
		return position[1];
	}

	public void setPosition(int[] position) {
		this.position = position;
	}
	
	public void setXPosition(int x){
		this.position[0] = x;
	}
	
	public void setYPosition(int y){
		this.position[1] = y;
	}
	
	public void updatePosition(){
		this.position[0] += this.velocity[0];
		this.position[1] += this.velocity[1];
	}
	
	public void incrementPosition(int x, int y){
		this.position[0] += x;
		this.position[1] += y;
	}

	public double[] getVelocity() {
		return velocity;
	}

	public void setVelocity(double[] velocity) {
		this.velocity = velocity;
	}
	
	public double getLatVelocity(){
		return this.velocity[0];
	}
	
	public void setLatVelocity(double velX){
		this.velocity[0] = velX;
	}
	
	public double getVertVelocity(){
		return this.velocity[1];
	}
	
	public void setVertVelocity(double velY){
		this.velocity[1] = velY;
	}
	
	public void incrementVelocity(double x, double y){
		this.velocity[0] += x;
		this.velocity[1] += y;
	}
	
	public void scaleVelocity(double x, double y){
		this.velocity[0] *= x;
		this.velocity[1] *= y;
	}
}
