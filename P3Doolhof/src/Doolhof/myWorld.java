package Doolhof;

import java.awt.event.*;

import javax.swing.*;

import java.awt.*;

public class myWorld extends JComponent implements ActionListener {
	private Timer timer;
	private Wereld wereld;
	private Player player;
	private Launcher launcher;
	private Reset reset;
	private End gameEnd;
	private String message = "";
	private boolean hard;

	private boolean win = false;
	//private Font font = new Font("Serif",  Font.BOLD, 48); 

	public myWorld(boolean hard) {
		this.hard = hard;
		wereld = new Wereld(hard);
		player = new Player(hard, wereld);

		addKeyListener(new ActionList(player));
		setFocusable(true);

		timer = new Timer(25, this);
		timer.start();

		for (int y = 0; y < 13; y++) { // Store world from txt in RAM
			for (int x = 0; x < 12; x++) {
				wereld.plain[x][y] = wereld.getWereld(x, y);
			}
		}
	}

	public void actionPerformed(ActionEvent event) {
		repaint();
	}


	public void paintComponent(Graphics graphic) {
		/* e = end
		 * v = vloer
		 * w = wall
		 * b = barRed
		 * n = barBlue
		 * m = barGreen
		 * j = keyRed
		 * k = keyBlue
		 * l = keyGreen
		 */

		for (int y = 0; y < 13; y++) { // Draw world from RAM
			for (int x = 0; x < 12; x++) {
				if (wereld.plain[x][y].equals("e")) {
					graphic.drawImage(wereld.getEnd(), x * 64, y * 64, null);
				}

				if (wereld.plain[x][y].equals("v")) {
					graphic.drawImage(wereld.getVloer(), x * 64, y * 64, null);
				}

				if (wereld.plain[x][y].equals("w")) {
					graphic.drawImage(wereld.getWall(), x * 64, y * 64, null);
				}

				if (wereld.plain[x][y].equals("b")) {
					new Barricade(graphic, "red", x, y);
				}
				if (wereld.plain[x][y].equals("n")) {
					new Barricade(graphic, "blue", x, y);
				}
				if (wereld.plain[x][y].equals("m")) {
					new Barricade(graphic, "green", x, y);
				}

				if (wereld.plain[x][y].equals("j")) {
					new Key(graphic, "red", x, y);
				}
				if (wereld.plain[x][y].equals("k")) {
					new Key(graphic, "blue", x, y);
				}
				if (wereld.plain[x][y].equals("l")) {
					new Key(graphic, "green", x, y);
				}
			}
			graphic.drawImage(player.getPlayer(), player.getBX() * 64, player.getBY() * 64, null);
		}
	}
}

