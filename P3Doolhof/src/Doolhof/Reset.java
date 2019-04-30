package Doolhof;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.JFrame;

public class Reset {
	
	private static JFrame frame2;
	private Doolhof doolhof;
	
	
	public Reset(boolean hard) {
		JLabel label = new JLabel("Menu");
		JButton reset = new JButton("Reset");
		JButton wissel = new JButton("Switch level"); // Nederlands want 'switch' is al iets
		JButton cancel = new JButton("Cancel");
		JPanel panel = new JPanel();
		
		reset.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				doolhof = new Doolhof(hard);
				doolhof.close();
				frame2.dispose();
			}		
		});
		
		wissel.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				doolhof = new Doolhof(!hard);
				doolhof.close();
				frame2.dispose();
			}		
		});
		
		cancel.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				frame2.dispose();
			}
		});
		
		//panel.add(label);
		panel.add(reset);
		panel.add(wissel);
		panel.add(cancel);
		
		frame2 = new JFrame();
		
		frame2.setTitle("Doolhof spel Menu");
		frame2.setSize(150, 300);

		frame2.add(panel);
		
		//Zet alles perfect middel op de scherm
		frame2.setLocationRelativeTo(null);
		frame2.setVisible(true);
		frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}