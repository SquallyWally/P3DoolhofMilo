package Doolhof;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.JFrame;

public class End {
	
	private static JFrame frame2;
	private Launcher launch;
	
	public End() {
		JLabel endMessage = new JLabel("YOU WIN");
		JButton again = new JButton("PLAY AGAIN");
		JButton cancel = new JButton("CANCEL");
		JPanel panel = new JPanel();
		
		
		again.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				launch = new Launcher();
				frame2.dispose();
			}
		});
		
		cancel.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				frame2.dispose();
			}
		});
		
		panel.add(endMessage);
		panel.add(again);
		panel.add(cancel);
		
		frame2 = new JFrame();
		
		frame2.setTitle("End screen");
		frame2.setSize(150, 300);

		frame2.add(panel);
		
		//Zet alles perfect middel op de scherm
		frame2.setLocationRelativeTo(null);
		frame2.setVisible(true);
		frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}