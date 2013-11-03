
package visulaliser.main;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.util.ArrayList;
import visulaliser.model.Message;
import visulaliser.model.Node;
import visulaliser.model.Person;
import visulaliser.model.Splitter;


public class Simulator extends Component implements ComponentListener{
    private String mPath;
    private int mIterations;
    private ArrayList<Node> mNodes = new ArrayList<Node>();
    private ArrayList<Person> mPeople = new ArrayList<Person>();
    private int nodes=0;
    private int mHieght;
    private int mWidth;
    private int mxRange;
    private int myRange;
    
    public Simulator(String path, int iterations,int nodecount, int people, int noMessages){
        mPath = path;
        mIterations = iterations;
        mWidth = Visulaliser.WIDTH;
        mHieght = Visulaliser.HIEGHT;
        nodes = nodecount;
        addComponentListener(this);
        initialise(nodes,people,noMessages);
    }

    public boolean initialise(int nodecount,int people, int noMessages){
        Splitter newSplitter=new Splitter();
        try{
        mNodes=newSplitter.networkParse(mPath,nodecount);
        mxRange=newSplitter.getXrange();
        myRange=newSplitter.getYrange();
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
    public void update(Graphics g) {
    	super.update(g);
    	System.out.println("Update");
    }
    
    @Override
    public void paint(Graphics g){
    	super.paint(g);
    	System.out.println("paint");
    	int ownWidth = getWidth();
    	int ownHeight=getHeight();
    	
    	g.clearRect(0, 0, ownWidth, ownHeight);
    	
    	float scale = 1.0f;
    	if(ownWidth<=ownHeight){
    		scale = (float) ownWidth / (float) mxRange;
    	}
    	else{
    		scale=(float) ownHeight/ (float) myRange;
    		
    	}
    	
        for(int i = 0; i < mNodes.size(); i++){
        	Node aNode=mNodes.get(i);
        	aNode.setScale(scale);
            aNode.paint(g);
            }
        for (int i = 0; i < mPeople.size(); i++ ){
        	Person aPerson=mPeople.get(i);
        	aPerson.setScale(scale);
            aPerson.paint(g);
        }
        
    }
    
    public void run(){
        for (int i = 0; i < mIterations; ++i) {
        	iterate();
        	try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
        }
    }
    
    public void iterate() {
    	System.out.println("Iterating...");
    	for (int i = 0; i < mPeople.size(); i++){
    		mPeople.get(i).changePosition();            
    	}
    	
    	ArrayList<Person> tempPeople = mPeople;
    	for(int i = 0; i < mNodes.size();i++) {
    		Node node = mNodes.get(i);
    		node.clearPeople();

    		for (int u = tempPeople.size() - 1; u >= 0; u--) {
    			Person person = tempPeople.get(u);
    			if (node.contains(person)){
    				node.add(person);
    				tempPeople.remove(u);
    			}
    		}
    	}
    	
//    	this.invalidate();
//    	this.repaint();
    	paint(getGraphics());
    }


	@Override
	public void componentHidden(ComponentEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void componentMoved(ComponentEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void componentResized(ComponentEvent arg0) {
		this.invalidate();
	}

	@Override
	public void componentShown(ComponentEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}

