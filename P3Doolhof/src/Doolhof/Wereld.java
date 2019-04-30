package Doolhof;

import java.awt.Image;
import java.io.*;
import java.util.*;

import javax.swing.ImageIcon;

public class Wereld {
	
	private Scanner in;
	protected String Wereld[] = new String[13];
	
	public String[][] plain = new String[14][13];
	
	private String imgPath = "images/";

	private Image vloer;
	private Image wall;
	private Image barricade;
	private Image barRed;
	private Image barBlue;
	private Image barGreen;
	private Image end;
	private Image key;
	private Image keyRed;
	private Image keyBlue;
	private Image keyGreen;
	
	public Wereld(boolean hard) {
		ImageIcon image = new ImageIcon(imgPath+ "vloer.png");
		vloer = image.getImage();
		
		image = new ImageIcon(imgPath+ "wall.png");
		wall = image.getImage();
		
		image = new ImageIcon(imgPath+ "barricade.png");
		barricade = image.getImage();
		
		image = new ImageIcon(imgPath+ "barRed.png");
		barRed = image.getImage();
		
		image = new ImageIcon(imgPath+ "barBlue.png");
		barBlue = image.getImage();
		
		image = new ImageIcon(imgPath+ "barGreen.png");
		barGreen = image.getImage();
		
		image = new ImageIcon(imgPath+ "doorClosed.png");
		end = image.getImage();
		
		image = new ImageIcon(imgPath+ "key.png");
		key = image.getImage();
		
		image = new ImageIcon(imgPath+ "keyRed.png");
		keyRed = image.getImage();
		
		image = new ImageIcon(imgPath+ "keyBlue.png");
		keyBlue = image.getImage();
		
		image = new ImageIcon(imgPath+ "keyGreen.png");
		keyGreen = image.getImage();
		
		openFile(hard);
		readFile();
		closeFile();
	}

	public Image getVloer(){ // Return vloer image
		return vloer;
	}
	
	public Image getWall(){ // Return wall image
		return wall;
	}
	
	public Image getBar(String colour) { // Return coloured barricade image by colour
		if (colour.equals("red")) {
			return barRed;
		} else if (colour.equals("blue")) {
			return barBlue;
		} else if (colour.equals("green")) {
			return barGreen;
		} else {
			return barricade;
		}
	}
	
	public Image getKey(String colour){ // Return coloured key image by colour
		if (colour.equals("red")) {
			return keyRed;
		} else if (colour.equals("blue")) {
			return keyBlue;
		} else if (colour.equals("green")) {
			return keyGreen;
		} else {
			return key;
		}
	}
	
	public String getKeyChar(String colour) { // Return the matching char is world file/RAM by colour
		if (colour.equals("red")) {
			return "j";
		} else if (colour.equals("blue")) {
			return "k";
		} else if (colour.equals("green")) {
			return "l";
		} else if (colour.equals("v")) {
			return "v";
		} else {
			return "";
		}
	}
	
	public Image getEnd(){ // Return end image
		return end;
	}
	
	
	public String getWereld(int x , int y) {
		/*Y positie kijkt dan naar de 2de rij van de Wereld
		 * 
		 * Substring vergelijkt het*/
		 
		String index = Wereld[y].substring(x, x + 1 );
		return index;
	}
	
	public void removeObject(int x ,int y) { // Remove object at given coords by changing it to 'vloer'
		this.plain[x][y] = "v";
	}
	
	public void replaceObject(int x, int y, String obj) { // Replace an object at given coords by setting the char in the RAM world to a given char
		this.plain[x][y] = obj;
	}
	
	public void  openFile(boolean hard) { // Open file (normal or hard)
		try {
			if (hard) {
				in = new Scanner(new File(imgPath+ "HardMap.txt"));
			} else {
				in = new Scanner(new File(imgPath+ "Map.txt"));
			}
		} catch(Exception e) {
			System.out.println("Fout met laden van de wereld");
		}
	}

	public void readFile() {
		while(in.hasNext()){
			for(int i = 0 ; i < 13; i++){
				Wereld[i] = in.next();		
			}
		}
	}

	public void closeFile() {
		in.close();	
	}
}


