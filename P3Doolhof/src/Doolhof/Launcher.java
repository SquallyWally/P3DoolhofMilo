package Doolhof;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Launcher {
	private static JFrame home;
	private static Doolhof doolhof;
	
	public Launcher() {
		JLabel label = new JLabel("Choose difficulty");
		JButton ez = new JButton("Normal");
		JButton gitgud = new JButton("Hard");
		JPanel panel = new JPanel();
				
		ez.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				doolhof = new Doolhof(false);
				doolhof.close();
				home.dispose();
			}
		});
				
		gitgud.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				doolhof = new Doolhof(true);
				doolhof.close();
				home.dispose();
			}
		});
				
		panel.add(label);
		panel.add(ez);
		panel.add(gitgud);
				
		home = new JFrame();
	  //home.add(new ImageIcon("C:\\Users\\Dennis\\Desktop\\Doolhogg\\images\\banaan.png"));
		home.setTitle("Doolhof spel Launcher");
		home.setSize(150, 300);

		home.add(panel);
				
		//Zet alles perfect middel op de scherm
		home.setLocationRelativeTo(null);
		home.setVisible(true);
		home.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args){
		new Launcher();
	}
}