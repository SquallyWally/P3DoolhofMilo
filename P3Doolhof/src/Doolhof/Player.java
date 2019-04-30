package Doolhof;

import java.awt.*;
import java.util.Random;
import java.awt.event.*;

import javax.swing.ImageIcon;

public class Player implements KeyListener {
    public String keyColour = "v";
    private int blokX;
    private int blokY;
    private Reset reset;
    private Image player;
    private boolean hard;
    private Wereld wereld;
    private End gameEnd;

    public Player(boolean hard, Wereld wereld) {
        this.wereld = wereld;
        //this.hard = hard;
        Random rnd = new Random();
        int rndInt = rnd.nextInt(10);

        if (rndInt == 9) {
            ImageIcon image = new ImageIcon("images/wot.jpg");

            player = image.getImage().getScaledInstance(64, 64, Image.SCALE_DEFAULT);
        } else {
            ImageIcon image = new ImageIcon("images/banaan.png");
            player = image.getImage();
        }

        blokY = 1;
        blokX = 1;

        for (int y = 0; y < 13; y++) { // Store world from txt in RAM
            for (int x = 0; x < 12; x++) {
                wereld.plain[x][y] = wereld.getWereld(x, y);
            }
        }
    }

    public Image getPlayer() { // Return player image
        return player;
    }

    public int getBX() { // Get x co�rd
        return blokX;
    }

    public int getBY() { // Get y co�rd
        return blokY;
    }

    public void setKeyColour(String colour) { // Set colour of carrying key
        this.keyColour = colour;
    }

    public String getKeyColour() { // Return colour of current key
        return keyColour;
    }

    public void act(int blokX, int blokY) { // Move player relative to current position
        this.blokX += blokX;
        this.blokY += blokY;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // TODO Auto-generated method stub
        int keyCode = e.getKeyCode();


        if (keyCode == KeyEvent.VK_SPACE) {
            reset = new Reset(hard);
            //reset.gameReset();
        }

        if (keyCode == KeyEvent.VK_W) { // If w is pressed
            if (!wereld.plain[getBX()][getBY() - 1].equals("w")) { // Is there no wall (aka free to move)?
                if (wereld.plain[getBX()][getBY() - 1].equals("j")) { // if moving on red key?
                    wereld.replaceObject(getBX(), getBY() - 1, wereld.getKeyChar(getKeyColour())); // Replace with current key
                    setKeyColour("red"); // Set carrying key to red
                    act(0, -1); // Move
                } else if (wereld.plain[getBX()][getBY() - 1].equals("k")) {
                    wereld.replaceObject(getBX(), getBY() - 1, wereld.getKeyChar(getKeyColour()));
                    setKeyColour("blue");
                    act(0, -1);
                } else if (wereld.plain[getBX()][getBY() - 1].equals("l")) {
                    wereld.replaceObject(getBX(), getBY() - 1, wereld.getKeyChar(getKeyColour()));
                    setKeyColour("green");
                    act(0, -1);
                } else if (wereld.plain[getBX()][getBY() - 1].equals("b")) { // If moving on red barricade
                    if (getKeyColour().equals("red")) { // If carrying matching key
                        wereld.removeObject(getBX(), getBY() - 1); // Remove barrier
                        act(0, -1); // Move
                    }
                } else if (wereld.plain[getBX()][getBY() - 1].equals("n")) {
                    if (getKeyColour().equals("blue")) {
                        wereld.removeObject(getBX(), getBY() - 1);
                        act(0, -1);
                    }
                } else if (wereld.plain[getBX()][getBY() - 1].equals("m")) {
                    if (getKeyColour().equals("green")) {
                        wereld.removeObject(getBX(), getBY() - 1);
                        act(0, -1);
                    }
                } else if (wereld.getWereld(getBX(), getBY() - 1).equals("e")) {
                    gameEnd = new End();
                } else {
                    act(0, -1);
                }
            }
        } // Previous if-statements repeat three more times for all directions

        if (keyCode == KeyEvent.VK_S) {
            if (!wereld.plain[getBX()][getBY() + 1].equals("w")) { // Is there no wall (aka free to move)?
                if (wereld.plain[getBX()][getBY() + 1].equals("j")) { // if moving on red key?
                    wereld.replaceObject(getBX(), getBY() + 1, wereld.getKeyChar(getKeyColour())); // Replace with current key
                    setKeyColour("red"); // Set carrying key to red
                    act(0, 1); // Move
                } else if (wereld.plain[getBX()][getBY() + 1].equals("k")) {
                    wereld.replaceObject(getBX(), getBY() + 1, wereld.getKeyChar(getKeyColour()));
                    setKeyColour("blue");
                    act(0, 1);
                } else if (wereld.plain[getBX()][getBY() + 1].equals("l")) {
                    wereld.replaceObject(getBX(), getBY() + 1, wereld.getKeyChar(getKeyColour()));
                    setKeyColour("green");
                    act(0, 1);
                } else if (wereld.plain[getBX()][getBY() + 1].equals("b")) { // If moving on red barricade
                    if (getKeyColour().equals("red")) { // If carrying matching key
                        wereld.removeObject(getBX(), getBY() + 1); // Remove barrier
                        act(0, 1); // Move
                    }
                } else if (wereld.plain[getBX()][getBY() + 1].equals("n")) {
                    if (getKeyColour().equals("blue")) {
                        wereld.removeObject(getBX(), getBY() + 1);
                        act(0, 1);
                    }
                } else if (wereld.plain[getBX()][getBY() + 1].equals("m")) {
                    if (getKeyColour().equals("green")) {
                        wereld.removeObject(getBX(), getBY() + 1);
                        act(0, 1);
                    }
                } else {
                    act(0, 1);
                }
            }
        }

        if (keyCode == KeyEvent.VK_A) {
            if (!wereld.plain[getBX() - 1][getBY()].equals("w")) {
                if (wereld.plain[getBX() - 1][getBY()].equals("j")) {
                    wereld.replaceObject(getBX() - 1, getBY(), wereld.getKeyChar(getKeyColour()));
                    setKeyColour("red");
                    act(-1, 0);
                } else if (wereld.plain[getBX() - 1][getBY()].equals("k")) {
                    wereld.replaceObject(getBX() - 1, getBY(), wereld.getKeyChar(getKeyColour()));
                    setKeyColour("blue");
                    act(-1, 0);
                } else if (wereld.plain[getBX() - 1][getBY()].equals("l")) {
                    wereld.replaceObject(getBX() - 1, getBY(), wereld.getKeyChar(getKeyColour()));
                    setKeyColour("green");
                    act(-1, 0);
                } else if (wereld.plain[getBX() - 1][getBY()].equals("b")) {
                    if (getKeyColour().equals("red")) {
                        wereld.removeObject(getBX() - 1, getBY());
                        act(-1, 0);
                    }
                } else if (wereld.plain[getBX() - 1][getBY()].equals("n")) {
                    if (getKeyColour().equals("blue")) {
                        wereld.removeObject(getBX() - 1, getBY());
                        act(-1, 0);
                    }
                } else if (wereld.plain[getBX() - 1][getBY()].equals("m")) {
                    if (getKeyColour().equals("green")) {
                        wereld.removeObject(getBX() - 1, getBY());
                        act(-1, 0);
                    }
                } else {
                    act(-1, 0);
                }
            }
        }

        if (keyCode == KeyEvent.VK_D) {
            if (!wereld.plain[getBX() + 1][getBY()].equals("w")) {
                if (wereld.plain[getBX() + 1][getBY()].equals("j")) {
                    wereld.replaceObject(getBX() + 1, getBY(), wereld.getKeyChar(getKeyColour()));
                    setKeyColour("red");
                    act(1, 0);
                } else if (wereld.plain[getBX() + 1][getBY()].equals("k")) {
                    wereld.replaceObject(getBX() + 1, getBY(), wereld.getKeyChar(getKeyColour()));
                    setKeyColour("blue");
                    act(1, 0);
                } else if (wereld.plain[getBX() + 1][getBY()].equals("l")) {
                    wereld.replaceObject(getBX() + 1, getBY(), wereld.getKeyChar(getKeyColour()));
                    setKeyColour("green");
                    act(1, 0);
                } else if (wereld.plain[getBX() + 1][getBY()].equals("b")) {
                    if (getKeyColour().equals("red")) {
                        wereld.removeObject(getBX() + 1, getBY());
                        act(1, 0);
                    }
                } else if (wereld.plain[getBX() + 1][getBY()].equals("n")) {
                    if (getKeyColour().equals("blue")) {
                        wereld.removeObject(getBX() + 1, getBY());
                        act(1, 0);
                    }
                } else if (wereld.plain[getBX() + 1][getBY()].equals("m")) {
                    if (getKeyColour().equals("green")) {
                        wereld.removeObject(getBX() + 1, getBY());
                        act(1, 0);
                    }
                } else {
                    act(1, 0);
                }
            }
        }
    }

    /*
    * DONT REMOVE THEM
    * */
    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub
    }
}
	
	