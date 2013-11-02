package visulaliser.model;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.HashMap;
public class Node extends Component{
    
    private ID mNodeID;
    private HashMap<String, Message> mMessages;
    private int mY;
    private int mX;
    private String mName;
    private int mSignalQuality;
    
    public Node(int x, int y, String name, int signalQuality){
        mX = x;
        mY = y;
        mName = name;
        mSignalQuality = signalQuality;
    }
    
    
    public ID getNodeID() {
        return mNodeID;
    }

    public int getX() {
        return mX;
    }
    
    public void setX(int x) {
    	mX = x;
    }

    public int getY() {
        return mY;
    }
    
    public void setY(int y) {
    	mY = y;
    }

    public String getName() {
        return mName;
    }

    public int getSignalQuality() {
        return mSignalQuality;
    }

    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.fillOval(mX, mY, 4, 4);
    }
    //@override
    
    public String toString(){
    	String s="";
    	s+="ID: "+"something goes here"+", SigQual: "+mSignalQuality+", Name: "+mName.toString();
    	return s;
    }
    
    
}
