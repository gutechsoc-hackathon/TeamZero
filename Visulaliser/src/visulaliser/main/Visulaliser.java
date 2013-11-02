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
		Node mNode = new Node(10, 10, "a", 0);
		JFrame frame = new JFrame("visualiser");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(mNode);
		frame.pack();
		frame.setVisible(true);
	}
}
