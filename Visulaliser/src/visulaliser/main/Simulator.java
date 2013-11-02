
package visulaliser.main;

import java.awt.Component;
import java.awt.Graphics;
import java.util.ArrayList;
import visulaliser.model.Node;
import visulaliser.model.Person;
import visulaliser.model.Splitter;


public class Simulator extends Component{
    private String mPath;
    private int mIterations;
    private ArrayList<Node> mNodes = new ArrayList<Node>();
    private ArrayList<Person> mPeople = new ArrayList<Person>();
    private int nodes=0;
    private int mHieght;
    private int mWidth;
    public Simulator(String path, int iterations,int nodecount, int people){
        mPath = path;
        mIterations = iterations;
        mWidth = Visulaliser.WIDTH;
        mHieght = Visulaliser.HIEGHT;
        nodes = nodecount;
        initialise(nodes,people);
    }

    public boolean initialise(int nodecount,int people){
        Splitter newSplitter=new Splitter();
        try{
        mNodes=newSplitter.networkParse(mPath,nodecount);
        }catch(Exception e){
        	return false;
        }
        mPeople = Person.personGen(people, mWidth, mHieght);
        return true;
    }
    
    public void setHieght(int h){
    mHieght = h;
    }
    public void setWidth(int w){
    mWidth = w;
    }
    @Override
    public void paint(Graphics g){
        for(int i = 0; i < mNodes.size(); i++){
            mNodes.get(i).paint(g);
            }
        for (int i = 0; i < mPeople.size(); i++ ){
            mPeople.get(i).paint(g);
        }
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
