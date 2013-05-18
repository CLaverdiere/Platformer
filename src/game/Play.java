package game;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;
import org.newdawn.slick.Image;
import org.lwjgl.opengl.Display;

import entities.*;
import destruction.*;
import environment.*;

public class Play extends BasicGameState{
	int state;
	MovingThing[] entities;
	NonMovingThing[] environment;
	
	public Play(int state){
		this.state = state;
	}
	
	public void init(GameContainer gc, StateBasedGame sbj) throws SlickException{
		entities = new MovingThing[16];
		environment = new NonMovingThing[16];
		addEntity(new Player(200, 65, 220, new int[]{100, 300}, 5, "Duke", new Weapon("Pistol", 30)));
		addEnvironmentalThing(new Platform(50, 150, new int[]{320, 400}));
		addEnvironmentalThing(new Platform(20, 180, new int[]{580, 300}));
		addEnvironmentalThing(new Platform(30, 100, new int[]{350, 300}));
		addEnvironmentalThing(new Platform(30, 30, new int[]{50, 400}));
		addEnvironmentalThing(new Platform(20, 150, new int[]{50, 550}));
	}
	
	public void render(GameContainer gc, StateBasedGame sbj, Graphics g) throws SlickException{
		
		// Draw control info
		String desc = "Controls: WASD\n" +
				"You can also jump more than once in air.\n" +
				"It's more fun that way. " +
				"Also, this is super glitchy.\n" +
				"Anyway, enjoy my first attempt at a platformer, ever.";
		g.drawString(desc, 20, 30);
		
		// Draw entities
		for (int i = 0; i < entities.length; i++){
			if (entities[i] != null){
				g.drawRect(entities[i].getPosition()[0], entities[i].getPosition()[1], entities[i].getWidth(), entities[i].getHeight());
			}
		}
		// Draw platforms/walls and such
		for (int i = 0; i < environment.length; i++){
			if (environment[i] != null){
				g.drawRect(environment[i].getPosition()[0], environment[i].getPosition()[1], environment[i].getWidth(), environment[i].getHeight());
			}
		}
	}
	
	public void update(GameContainer gc, StateBasedGame sbj, int delta) throws SlickException{
		// PLAYER CONTROLS //
		Input input = gc.getInput();
		Player player = getPlayer();
		
		// PLAYER VARS
		int playerPosX = player.getPosition()[0];
		int playerPosY = player.getPosition()[1];
		int playerWidth = player.getWidth();
		int playerHeight = player.getHeight();
		int playerRightSide = playerPosX + playerWidth;
		int playerFeet = playerPosY + playerHeight;
		
		// ACCELERATING LEFT/RIGHT MOVEMENT //
		if (input.isKeyDown(Input.KEY_D) && input.isKeyDown(Input.KEY_A)){
			player.walk(0);
		}
		else if (input.isKeyDown(Input.KEY_A)){
			// Make sure player isn't hitting object.
			player.walk(-1);
		}
		else if (input.isKeyDown(Input.KEY_D)){
			// Make sure player isn't hitting object.
			player.walk(1);
		}
		// Reset movement to zero when no buttons pushed
		else {
			player.walk(0);
		}
		
		// PLAYER JUMPING
		// As a note, the player should only be able to jump if they
		//     are on the ground, but I'm having too much fun ignoring
		//     that rule... so it's staying for now.
		if (input.isKeyPressed(Input.KEY_W)){
			player.jump();
		}
		
		// ADDING NEW ENTITIES //
		// This doesn't really work right now, it only makes a very specific enemy... once.
		if (input.isKeyPressed(Input.KEY_B)){
			addEntity(new Enemy(200, 70, 180, new int[]{30, 100}, 2, "Demon", new Weapon("Machine Gun", 0)));
		}
		
		// PLATFORM DETECTION
		boolean foundPlatform = false;
		for (int i = 0; i < getEnvironment().length; i++){
			if (getEnvironment()[i] != null){
				
				// Object Variables
				int objPosX = getEnvironment()[i].getPosition()[0];
				int objPosY = getEnvironment()[i].getPosition()[1];
				int objWidth = getEnvironment()[i].getWidth();
				int objHeight = getEnvironment()[i].getHeight();
				int objRightSide = objPosX + objWidth;
				int objBottom = objPosY + objHeight;
				
				
				// Determine if player is in width of block.
				if (playerPosX - objPosX <= objWidth && playerPosX - objPosX + playerWidth >= 0 ){
					
					// Determine if player is hitting head
					if (playerPosY - objBottom < player.getVertVelocity() * -1 && playerPosY - objBottom > 0){
						player.setVertVelocity(0);
					}
					
					// Determine if player is jumping onto a platform
					else if (playerFeet >= objPosY && objBottom >= playerPosY){
						foundPlatform = true;
						if (!player.isOnPlatform()){
							if (!player.isJumping()){
								player.setYPosition(objPosY - playerHeight);
								player.setOnPlatform(true);
							}
						}
					}
				}
				
				
				// Determine if player is walking into a platform
				//   Checks if player is hitting either side of object
				if (Math.abs(playerRightSide - objPosX) < player.getLatVelocity() 
						|| Math.abs(playerPosX - objRightSide) < Math.abs(player.getLatVelocity())){
					if (playerFeet > objPosY && !(playerPosY > objPosY)){
						double oldVel = player.getLatVelocity();
						player.setAllowedToWalk(false);
						player.moveOutOfWall(-1 * oldVel);
						player.setAllowedToWalk(true);
					}
				}
			}
		}
		
		// Used to make player fall again once they step off the platform.
		if (foundPlatform == false){
			player.setOnPlatform(false);
		}
		
		// After all is said and done, update positions and velocities.
		player.updateVelocity(delta);
		player.updatePosition();
	}
	
	public int getID(){
		return this.state;
	}
	
	public MovingThing[] getEntities(){
		return entities;
	}
	
	public NonMovingThing[] getEnvironment(){
		return environment;
	}
	
	public void addEntity(MovingThing entity){
		// Find first null in entity list
		for (int i = 0; i < getEntities().length; i++){
			if (getEntities()[i] == null){
				entities[i] = entity;
				return;
			}
		}
	}
	
	// Oh god these are bad names
	public void addEnvironmentalThing(NonMovingThing thing){
		// Find first null in environment list
		for (int i = 0; i < getEnvironment().length; i++){
			if (getEnvironment()[i] == null){
				environment[i] = thing;
				return;
			}
		}
	}
	
	public Player getPlayer(){
		return (Player) getEntities()[0];
	}
	
	
}
