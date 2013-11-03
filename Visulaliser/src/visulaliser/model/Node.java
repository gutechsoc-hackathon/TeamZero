package visulaliser.model;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
public class Node extends Component{
    
    private ID mNodeID;
    private HashMap<ID, Message> mMessages;
    private int mY;
    private int mX;
    private String mName;

    private int mSignalQuality;
    private ArrayList<Person> mPeople;
    private int mRadius;
    private float mScale=1.0f;

    public Node(int x, int y, String name, int quality){
        mNodeID = ID.generateID();
        mX = x;
        mY = y;
        mName = name;
        mSignalQuality = quality;
        mRadius = 4;
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
    
    public ArrayList getPeople(){
return mPeople;}
    public int getRadius(){
    	return this.mRadius;
    }
    
    public HashMap<ID, Message> getMessages(){
    return mMessages;
    }
    
    public void checkPersonMessages(Person P){
        Set<ID> keys = P.getMessages().keySet();
        for (ID key : keys) {
            if(!mMessages.containsKey(key)){
                mMessages.put(key, P.getMessages().get(key));
            }
        }
    }
    
    public int getSignalQuality() {
        return mSignalQuality;
    }
    public void setScale(float scale){
    	mScale=scale;
    }
    public void setRadius(int radius){
    	mRadius=radius;
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        int x= (int) (mX*mScale);
        int y= (int) (mY*mScale);
        g2d.drawOval(x, y, mRadius, mRadius);
    }
    //@override
    
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
