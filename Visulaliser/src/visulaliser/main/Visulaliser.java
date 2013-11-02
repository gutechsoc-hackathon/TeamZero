package visulaliser.main;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import visulaliser.model.*;
import java.util.ArrayList;
public class Visulaliser {
    BufferedImage image = new BufferedImage(800,600,BufferedImage.TYPE_INT_ARGB);
    public static void Show(ArrayList<Node> aNodes){
        JFrame frame = new JFrame("visualiser");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        int i;
        for(i=0;i<aNodes.size();i++){
        	frame.getContentPane().add(aNodes.get(i));
        }
        frame.pack();
        frame.setVisible(true);
    	}
    
    
}
