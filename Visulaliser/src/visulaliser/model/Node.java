package visulaliser.model;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import visulaliser.model.painter.Painter;
public class Node extends Component{
    
    public final ID mNodeID;
    private HashMap<ID, Message> mMessages;
    private int mY;
    private int mX;
    private String mName;

    private int mSignalQuality;
    private ArrayList<Person> mPeople;
    private int mRadius;
    private float mScale=1.0f;

    private final Painter mPainter;

    public Node(int x, int y, String name, int quality, Painter painter){
        mNodeID = ID.generateID();
        mX = x;
        mY = y;
        mName = name;
        mSignalQuality = quality;
        mRadius = 4;
        mMessages = new HashMap<ID, Message>();
        mPeople = new ArrayList<Person>();
        mPainter = painter;
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
    
    public ArrayList<Person> getPeople(){
        return mPeople;
    }
    
    public HashMap<ID, Message> getMessages(){
    	return mMessages;
    }
    
    public void checkPersonMessages(Person P){
        Set<ID> keys = P.getMessages().keySet();
        for (ID key : keys) {
            if(!mMessages.containsKey(key)){
                mMessages.put(key, P.getMessages().get(key));
                System.out.println("Node " + mNodeID.ID + " took a message");
            }
        }
    }
    
    public int getSignalQuality() {
        return mSignalQuality;
    }
    
    public void setScale(float scale){
    	mScale=scale;
    }
    
    public float getScale() {
    	return mScale;
	}


	public int getRadius(){
		return this.mRadius;
	}

    public void setRadius(int radius){
    	mRadius=radius;
    }
    
    @Override
    public void paint(Graphics g) {
        mPainter.paintNode(g, this);
    }
    
    public String toString(){
    	String s="";
    	s+="ID: "+"something goes here"+", SigQual: "+mSignalQuality+", Name: "+mName.toString();
    	return s;
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
