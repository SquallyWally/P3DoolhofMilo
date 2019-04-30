package Doolhof;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Key {
	private String colour;
	private String keyChar;
	private int x;
	private int y;
	private Image image;
	private String imgPath = "images/";
	
	public String getColour() {
		return this.colour;
	}
	
	public String getChar() {
		return this.keyChar;
	}
	
	public Image getImage() {
		return this.image;
	}
	
	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}
	
	public Key(Graphics graphic, String colour, int x, int y) {
		this.colour = colour;
		this.x = x;
		this.y = y;
		
		if (this.colour.equals("red")) {
			ImageIcon temp = new ImageIcon(imgPath+ "keyRed.png");
			this.image = temp.getImage();
			//this.keyChar = "j";
		} else if (this.colour.equals("blue")) {
			ImageIcon temp = new ImageIcon(imgPath+ "keyBlue.png");
			this.image = temp.getImage();
			//this.keyChar = "k";
		} else if (this.colour.equals("green")) {
			ImageIcon temp = new ImageIcon(imgPath+ "keyGreen.png");
			this.image = temp.getImage();
			//this.keyChar = "l";
		} else {
			ImageIcon temp = new ImageIcon(imgPath+ "key.png");
			this.image = temp.getImage();
		}
		
		graphic.drawImage(this.image, x*64, y*64, null);
	  //wereld.replaceObject(x, y, wereld.getKeyChar(this.keyChar));
	}
}