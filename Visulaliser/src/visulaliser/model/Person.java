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
    private HashMap<ID, Message> mMessages;
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
    
    public static ArrayList<Person> personGen(int noPeople, int MaxX,int MaxY, int noMessages){
        ArrayList<Person> lis = new ArrayList<Person>();
        mMaxX = MaxX;
        mMaxY = MaxY;
        for(int i = 0;i < noPeople; i++){
            Person p = new Person();
            lis.add(p);
        }
        for(int i = 0; i < noMessages; i++){
        int pers1no = randomGenerator.nextInt(noPeople);
        int pers2no = randomGenerator.nextInt(noPeople);
        Person pers1 = lis.get(pers1no);
        Person pers2 = lis.get(pers2no);
        Message mess1 = new Message(pers1.mID,pers2.mID);
        lis.get(pers1no).mMessages.put(mess1.getID(), mess1);}
        return lis;
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