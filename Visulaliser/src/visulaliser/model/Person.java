package visulaliser.model;
import java.util.HashMap;
import java.math.*;
import java.util.Random;
public class Person {
    private ID mID;
    private ID mNodeID;
    private HashMap<String, Message> mMessages;
    private int mX;
    private int mY;
    private static Random randomGenerator = new Random();

    public void changePosition(){
        mX = randomGenerator.nextInt(200);
        mY = randomGenerator.nextInt(200);                       
    }
    
    public int getX(){
        return mX;
    }
    
    public int getY(){
        return mY;
    }
}