package visulaliser.model;
import java.util.HashMap;
public class Person {
    private ID mID;
    private ID mNodeID;
    private HashMap<String, Message> mMessages;
    private int mX;
    private int mY;

    
    public int getX(){
        return mX;
    }
    
    public int getY(){
        return mY;
    }
}