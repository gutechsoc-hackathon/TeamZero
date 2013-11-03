package visulaliser.model;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Set;

import visulaliser.model.painter.Painter;
public class Person extends Component{
    private ID mID;
    private ID mNodeID;
    private HashMap<ID, Message> mMessages = new HashMap<ID, Message>();
    private int mX;
    private int mY;
    private static int mMaxX;
    private static int mMaxY;
    private static Random randomGenerator = new Random();
    private float mScale=1.0f;
    private static final int MAXSPEED = 10;
    private int mXSpeed;
    private int mYSpeed;
    
    private final Painter mPainter;
    
    
    public Person(ArrayList<Node> nodes, Painter painter){
        mID = ID.generateID();
        int nodeNo = randomGenerator.nextInt(nodes.size());
        mX =(int) ((int)  nodes.get(nodeNo).getX()  + (-20 + randomGenerator.nextInt(40))*randomGenerator.nextDouble());
        mY = (int) ((int) nodes.get(nodeNo).getY() + (-20 + randomGenerator.nextInt(40))*randomGenerator.nextDouble());
        mXSpeed = randomGenerator.nextInt(2 * MAXSPEED) - 10;
        mYSpeed = randomGenerator.nextInt(2 * MAXSPEED) - 10;
        
        mPainter = painter;
    }
    
    public static ArrayList<Person> personGen(int noPeople, int MaxX,int MaxY, int noMessages, ArrayList<Node> nodes, Painter painter){
        ArrayList<Person> people = new ArrayList<Person>();
        mMaxX = MaxX;
        mMaxY = MaxY;
        
        
        for(int i = 0;i < noPeople; i++){
            Person p = new Person(nodes, painter);
            people.add(p);
        }
        ArrayList<Message> lis = new ArrayList();
        for(int i = 0; i < noMessages; i++){
            int pers1no = randomGenerator.nextInt(people.size());
            int pers2no = randomGenerator.nextInt(people.size());
            Person pers1 = people.get(pers1no);
            Person pers2 = people.get(pers2no);
            Message mess1 = new Message(pers1.mID,pers2.mID);
            pers1.mMessages.put(mess1.getID(), mess1);}
        return people;
        
    }
    
    public void changePosition(){
        if (mX + mXSpeed > mMaxX || mX + mXSpeed < 0){
            mXSpeed = - mXSpeed;
            }
        if (mY + mYSpeed > mMaxY || mY + mYSpeed < 0){
            mYSpeed = - mYSpeed;
        }
        mX += mXSpeed;
        mY += mYSpeed ; 
        
        mXSpeed = randomGenerator.nextInt(2 * MAXSPEED) - 10;
        mYSpeed = randomGenerator.nextInt(2 * MAXSPEED) - 10;
    }
    
    public int getX(){
        return mX;
    }
    
    public void setScale(float scale){
    	mScale=scale;
    }
    
    public float getScale() {
    	return mScale;
    }
    
    @Override
    public void paint(Graphics g) {
        mPainter.paintPerson(g, this);
    }
    
    public void checkNodeMessages(Node n){
    Set<ID> keys = n.getMessages().keySet();
    for (ID key : keys) {
        if(!mMessages.containsKey(key)){
            mMessages.put(key, n.getMessages().get(key));
            }
        }
        
    } 
    
    public void addMess(Message mess){
    mMessages.put(mess.getID(),mess);
    }   
    
    public int getY(){
        return mY;
    }
    public HashMap<ID, Message> getMessages(){
    return mMessages;}
}