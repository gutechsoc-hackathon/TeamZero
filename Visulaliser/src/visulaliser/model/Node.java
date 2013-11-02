package visulaliser.model;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.HashMap;
public class Node extends Component{
    
    private ID mNodeID;
    private HashMap<String, Message> mMessages;
    int mY;
    int mX;
    private String mName;
    private String mSignalQuality;
    
    public Node(double x, double y){
        
    }
    
    
    public ID getNodeID() {
        return mNodeID;
    }

    public int getX() {
        return mX;
    }

    public int getY() {
        return mY;
    }

    public String getName() {
        return mName;
    }

    public String getSignalQuality() {
        return mSignalQuality;
    }

    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.fillOval(mX, mY, 4, 4);
    }
    
    
}
