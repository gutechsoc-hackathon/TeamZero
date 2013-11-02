package visulaliser.model;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.HashMap;
public class Node extends Component{
    
    private ID mNodeID;
    private HashMap<String, Message> mMessages;
    int mY;
    int mX;
    private String mName;
    private String mSignalQuality;
    private ArrayList<Person> mPeople;
    private int mRadius;
    
    public Node(int x, int y, String name, String quality, int R){
        mX = x;
        mY = y;
        mName = name;
        mRadius = R;
        mSignalQuality = quality;
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

    @Override
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawOval(mX, mY, mRadius, mRadius);
    }
    
    public boolean contains(Person person) {
        if (Math.pow((person.getX() - mX),2) + Math.pow((person.getY() - mY),2) <= Math.pow(mRadius, 2) ){
        return true;
    }
        return false;
    }
    public void add(Person p){
        mPeople.add(p);
    }
    public void clearPeople() {
        mPeople.clear();
    }
    
}
