package game;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

/**
 * A game project. More info can be found in the readme.
 * @author Chris Laverdiere
 */ public class Game extends StateBasedGame {
	public static final String gamename = "Working Title";
	public static final int menu = 0;
	public static final int play = 1;
	
	public Game(String gamename){
		super(gamename);
		this.addState(new Menu(menu));
		this.addState(new Play(play));
	}
	
	public void initStatesList(GameContainer gc) throws SlickException{
		this.getState(menu).init(gc, this);
		this.getState(play).init(gc, this);
		this.enterState(menu);
	}
	
	public static void main(String[] args) {
		AppGameContainer appgc;
		try{
			// Make the screen size dynamic somehow
			appgc = new AppGameContainer(new Game(gamename));
			appgc.setDisplayMode(800, 600, false);
			appgc.start();
		}catch(SlickException e){
			e.printStackTrace();
		}
	}

}
