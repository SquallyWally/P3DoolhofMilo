package Doolhof;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Barricade {
	private String colour;
	private int x;
	private int y;
	private Image image;
	private String imgPath = "images/";
	
	public String getColour() {
		return this.colour;
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
	
	public Barricade(Graphics graphic, String colour, int x, int y) {
		this.colour = colour;
		this.x = x;
		this.y = y;
		
		if (this.colour.equals("red")) {
			ImageIcon temp = new ImageIcon(imgPath+ "barRed.png");
			this.image = temp.getImage();
		} else if (this.colour.equals("blue")) {
			ImageIcon temp = new ImageIcon(imgPath+ "barBlue.png");
			this.image = temp.getImage();
		} else if (this.colour.equals("green")) {
			ImageIcon temp = new ImageIcon(imgPath+ "barGreen.png");
			this.image = temp.getImage();
		} else {
			ImageIcon temp = new ImageIcon(imgPath+ "barricade.png");
			this.image = temp.getImage();
		}
		
		graphic.drawImage(this.image, x*64, y*64, null);
	}
}
