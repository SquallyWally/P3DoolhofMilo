package Doolhof;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Doolhof {
	private JFrame frame;
	public void close(){
		SwingUtilities.updateComponentTreeUI(frame);
	}

	public Doolhof(boolean hard) {
		frame = new JFrame();
		frame.setTitle("Doolhof spel");
		frame.setSize(777, 860);
		frame.add(new myWorld(hard));

		//Zet alles perfect middel op de scherm
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}