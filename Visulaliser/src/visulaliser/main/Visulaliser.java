package visulaliser.main;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import visulaliser.model.*;
public class Visulaliser {
    BufferedImage image = new BufferedImage(800,600,BufferedImage.TYPE_INT_ARGB);
    public static void CreateAndShow(){
        Node mNode = new Node(10,10,"a","a",234);
        Simulator s = new Simulator("",1);
        JFrame frame = new JFrame("visualiser");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(mNode);
        frame.getContentPane().add(s);
        frame.pack();
        frame.setVisible(true);
        }
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                // load data
               
                // run sim
                CreateAndShow();
    }
        });
}}
