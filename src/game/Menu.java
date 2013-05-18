package game;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;
import org.newdawn.slick.Image;
import org.lwjgl.opengl.Display;

public class Menu extends BasicGameState{
	int state;
	
	public Menu(int state){
		this.state = state;
	}
	
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException{
		
	}
	
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException{
		g.drawString("Working Title: pre-alpha v0.1", 50, 50);
		g.drawString("Chris Laverdiere: Mar 2013 -> ?", 50, 690);
		g.drawString("Mash spacebar to play.", 50, 100);
	}
	
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException{
		Input input = gc.getInput();
		if(input.isKeyDown(Input.KEY_SPACE)){
			sbg.enterState(1);
		}
	}
	
	public int getID(){
		return this.state;
	}
}
