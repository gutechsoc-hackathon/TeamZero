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
    private HashMap<String, Message> mMessages;
    private int mX;
    private int mY;
    private static int mMaxX;
    private static int mMaxY;
    private static Random randomGenerator = new Random();
    private float mScale=1.0f;
    public Person(){
        changePosition();
    }
    
    public static ArrayList<Person> personGen(int noPeople, int MaxX,int MaxY){
        ArrayList<Person> lis = new ArrayList<Person>();
        mMaxX = MaxX;
        mMaxY = MaxY;
        for(int i = 0;i < noPeople; i++){
            Person p = new Person();
            lis.add(p);
        }
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
    
    public int getY(){
        return mY;
    }
}