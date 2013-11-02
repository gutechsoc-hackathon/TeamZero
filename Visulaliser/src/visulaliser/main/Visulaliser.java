package visulaliser.main;

import javax.swing.*;
import visulaliser.model.*;

public class Visulaliser {

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
		Simulator sim = new Simulator("C:\\glasgowhack.csv",10);
		JFrame frame = new JFrame("visulaliser");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(sim);
		frame.pack();
		frame.setVisible(true);
	}
}
