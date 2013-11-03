package visulaliser.model;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
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
    public Person(){
        mID = ID.generateID();
        changePosition();
    }
    
    public static ArrayList<Person> personGen(int numberOfPeople, int MaxX,int MaxY, int messageCount){
        ArrayList<Person> people = new ArrayList<Person>();
        mMaxX = MaxX;
        mMaxY = MaxY;
        for(int i = 0;i < numberOfPeople; i++){
            Person p = new Person();
            people.add(p);
        }
        int person1;
        int person2;
		for (int i = 0; i < messageCount; i++) {
	        person1 = randomGenerator.nextInt(numberOfPeople);
	        person2 = randomGenerator.nextInt(numberOfPeople);
			
			Person pers1 = people.get(person1);
			Person pers2 = people.get(person2);
			Message mess1 = new Message(pers1.mID, pers2.mID);
			pers1.mMessages.put(mess1.getID(), mess1);
		}
        return people;
    }
    
    public void changePosition(){
        mX = randomGenerator.nextInt(mMaxX);
        mY = randomGenerator.nextInt(mMaxY);                       
    }
    
    public int getX(){
        return mX;
    }
    
    public void setScale(float scale){
    	mScale=scale;
    }
    @Override
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.red);

        int x= (int) (mX*mScale);
        int y= (int) (mY*mScale);
        g2d.fillOval(x, y, 3, 3);
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