
package visulaliser.main;

import java.util.ArrayList;
import visulaliser.model.Node;
import visulaliser.model.Person;


public class Simulator {
    private String mPath;
    private int mIterations;
    private ArrayList<Node> mNodes = new ArrayList<Node>();
    private ArrayList<Person> mPeople = new ArrayList<Person>();
    
    public Simulator(String path, int iterations){
        mPath = path;
        mIterations = iterations;
        
            
    }
    public boolean initialise(){
        
        return false;
    }
    
    public void run(){
        
    }
    
    public void iterate(){
        for (int i = 0; i < mPeople.size(); i++){
            mPeople.get(i).changePosition();            
        }
        ArrayList<Person> tempPeople = mPeople;
        for(int i = 0; i < mNodes.size();i++) {
            Node node = mNodes.get(i);
            node.clearPeople();
            
            for (int u = tempPeople.size(); u >= 0; u--) {
                Person person = tempPeople.get(i);
                if (node.contains(person)){
                    node.add(person);
                    tempPeople.remove(u);
                }
            }
            
            // do messages
            
            
        }
        
    }
}
