
package visulaliser.main;

import java.awt.Component;
import java.awt.Graphics;
import java.util.ArrayList;
import visulaliser.model.Message;
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
    public Simulator(String path, int iterations,int nodecount, int people, int noMessages){
        mPath = path;
        mIterations = iterations;
        mWidth = Visulaliser.WIDTH;
        mHieght = Visulaliser.HIEGHT;
        nodes = nodecount;
        initialise(nodes,people,noMessages);
    }

    public boolean initialise(int nodecount,int people, int noMessages){
        Splitter newSplitter=new Splitter();
        try{
        mNodes=newSplitter.networkParse(mPath,nodecount);
        }catch(Exception e){
        	return false;
        }
        mPeople = Person.personGen(people, mWidth, mHieght, noMessages);
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
            
            for (int j = 0; j < node.getPeople().size(); j++){
                ArrayList<Person> peapJ = node.getPeople();
                Person perJ = peapJ.get(j);
             for (int k = 0; k < node.getMessages().size(); k++){
                 Message mess = node.getMessages().get(k);   
                 boolean hasMessageP = false;
                 
                 for (int l = 0; l < perJ.getMessages().size(); l++){
                     if (mess == perJ.getMessages().get(l)){
                         break;                      
                     }
                     else if (l == perJ.getMessages().size() - 1){
                     mPeople.mess.add(mess);
                     }
                        
                     }
                 }
             }
             }
        }
        
    }

