package Doolhof;

import java.awt.event.*;

public class ActionList extends KeyAdapter {

	public Player p;
	
	public  ActionList(Player player){
		p = player;
	}
	
	public void keyPressed(KeyEvent e){
		p.keyPressed(e);
	}
	
	public void keyReleased(KeyEvent e){}
}
