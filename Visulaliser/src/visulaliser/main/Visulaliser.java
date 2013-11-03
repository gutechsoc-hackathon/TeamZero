package visulaliser.main;

import javax.swing.*;
import visulaliser.model.*;

public class Visulaliser {
	
	// DO NOT CHANGE THIS
	public static final int MAX_NODES = 72670;
	
	public static final int WIDTH = 600;
	public static final int HIEGHT = 400;
	public static final int NODES = MAX_NODES;
	public static final int PEOPLE = 10;
	public static final int ITERATIONS = 10;
	public static final int MESSAGES = 10;
	
	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				// load data

				// run sim
				CreateAndShow();
			}
		});
	}
	
	public static void CreateAndShow() {
		Simulator sim = new Simulator("glasgowhack.csv",ITERATIONS,NODES,PEOPLE, MESSAGES);
        
		JFrame frame = new JFrame("Visulaliser");
		frame.setSize(WIDTH, HIEGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(sim);
		frame.setVisible(true);
		
		sim.initialise();
		sim.run();
	}
}
