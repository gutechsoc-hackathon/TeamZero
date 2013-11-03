package visulaliser.model;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import uk.me.jstott.jcoord.LatLng;
import uk.me.jstott.jcoord.UTMRef;
import visulaliser.model.painter.BasicPainter;
import visulaliser.model.painter.Painter;

public class Splitter
{
	//constructor
	int xRange;
	int yRange;
	int rRange; //range of R values
	
	Painter mPainter = new BasicPainter();
	
	public Splitter() { }
	
	public Splitter(Painter painter){
		mPainter = painter;
				
	}
    public ArrayList<Node> networkParse(String filename,int lines) //returns an arraylist of nodes from "lines" number of lines from file
    {
        //Input file which needs to be parsed
        String fileToParse = filename; //change this
        BufferedReader fileReader = null;
         
        //Delimiter used in CSV file
        final String DELIMITER = ",";

        //New Arraylist for storing the nodes
        ArrayList<Node> mNetwork= new ArrayList<Node>();
        try
        {
            String line = "";
            //Create the file reader
            fileReader = new BufferedReader(new FileReader(fileToParse));
            
            int[] max = {Integer.MIN_VALUE, Integer.MIN_VALUE};
            int[] min = {Integer.MAX_VALUE, Integer.MAX_VALUE};
            int maxSig = Integer.MIN_VALUE;
            int minSig = Integer.MAX_VALUE;
            
            //Read the file line by line
            int lineCounter=0;
            while (lineCounter<lines) 
            {	
            	//in case we try to read more lines than there are line is unreadable
            
            	line = fileReader.readLine();
            	if (line == null)
            		break;
            	
            	lineCounter+=1;
                //Get all tokens available in line
                String[] tokens = line.split(DELIMITER);
                //Some data is not used for populating the node
                if (tokens.length<12 || tokens.length>12){
                	continue;
                }
                
               
                int longX;
                int latY;
                int mSignalQuality;
                
                try{
                double longitude = Double.parseDouble(tokens[7]);
                double latitude = Double.parseDouble(tokens[6]);
                
                LatLng latLng = new LatLng(latitude, longitude);
                UTMRef utm = latLng.toUTMRef();
                longX = (int) utm.getEasting();
                latY = (int) utm.getNorthing();
                // String mNodeID=tokens[0];
                mSignalQuality = Integer.parseInt(tokens[11]); 
                }catch(NumberFormatException e){
                	continue;
                }
                String mName=tokens[3];   //ssid
                               
                Node mNewNode= new Node(longX, latY, mName, mSignalQuality, mPainter);
                mNetwork.add(mNewNode);
                if (longX > max[0])
                	max[0] = longX;
                else if (longX < min[0])
                	min[0] = longX;

                if (latY > max[1])
                	max[1] = latY;
                else if (latY < min[1])
                	min[1] = latY;
                
                if (mSignalQuality > maxSig)
                	maxSig = mSignalQuality;
                else if(mSignalQuality< minSig)
                	minSig = mSignalQuality;
            }
            
            //augmentation of coordinates
            int i;
            for(i=0;i<mNetwork.size();i++){
            	Node node = mNetwork.get(i);
            	node.setX(node.getX() - min[0]);
            	node.setY(max[1]-node.getY());
            	node.setRadius((int)((float) node.getRadius()*((float)node.getSignalQuality()/(float)(maxSig-minSig)))); //improve speed 
            }
            setXrange(max[0]-min[0]);
            setYrange(max[1]-min[1]);
            setRrange(maxSig-minSig);
            
        } 
        catch (Exception e) {
            e.printStackTrace();
            return null;
        } 
        finally
        {
            try {
                fileReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return mNetwork; //lost in parentheses - return might never be executed
    }
    public void setXrange(int range){
    	this.xRange=range;
    	
    }
    public void setYrange(int range){
    	this.yRange=range;
    	
    }
    public void setRrange(int range){
    	rRange=range;
    }
    public int getXrange(){
    	return this.xRange;
    }
    public int getYrange(){
    	return this.yRange;
    }
	    //method overloading - lines++
        public ArrayList<Node> networkParse(String filename) //returns an arraylist of nodes, reads whole file
        {
            //Input file which needs to be parsed
            String fileToParse = filename; //change this
            BufferedReader fileReader = null;
             
            //Delimiter used in CSV file
            final String DELIMITER = ",";

            //New Arraylist for storing the nodes
            ArrayList<Node> mNetwork= new ArrayList<Node>();
            try
            {
                String line = "";
                //Create the file reader
                fileReader = new BufferedReader(new FileReader(fileToParse));
                
                int[] max = {Integer.MIN_VALUE, Integer.MIN_VALUE};
                int[] min = {Integer.MAX_VALUE, Integer.MAX_VALUE};
                int maxSig = Integer.MIN_VALUE;
                int minSig = Integer.MAX_VALUE;
                
                //Read the file line by line
                while ((line = fileReader.readLine())!=null) 
                {	
                	//in case we try to read more lines than there are line is unreadable
                	
                	
                    //Get all tokens available in line
                    String[] tokens = line.split(DELIMITER);
                    //Some data is not used for populating the node
                    if (tokens.length<12 || tokens.length>12){
                    	continue;
                    }
                    
                   
                    int longX;
                    int latY;
                    int mSignalQuality;
                    
                    try{
                        double longitude = Double.parseDouble(tokens[7]);
                        double latitude = Double.parseDouble(tokens[6]);
                        
                        LatLng latLng = new LatLng(latitude, longitude);
                        UTMRef utm = latLng.toUTMRef();
                        longX = (int) utm.getEasting();
                        latY = (int) utm.getNorthing();
                        // String mNodeID=tokens[0];
                        mSignalQuality = Integer.parseInt(tokens[11]); 
                        }catch(NumberFormatException e){
                        	continue;
                        }
                    
                    String mName=tokens[3];   //ssid
                                   
                    Node mNewNode= new Node(longX, latY, mName, mSignalQuality, mPainter);
                    mNetwork.add(mNewNode);
                    if (longX > max[0])
                    	max[0] = longX;
                    else if (longX < min[0])
                    	min[0] = longX;

                    if (latY > max[1])
                    	max[1] = latY;
                    else if (latY < min[1])
                    	min[1] = latY;
                    
                    if (mSignalQuality > maxSig)
                    	maxSig = mSignalQuality;
                    else if(mSignalQuality< minSig)
                    	minSig = mSignalQuality;
                }
                
                
                //augmentation of coordinates
                int i;
                for(i=0;i<mNetwork.size();i++){
                	Node node = mNetwork.get(i);
                	node.setX(node.getX() - min[0]);
                	node.setY(node.getY() - min[1]);
                	node.setRadius((int)((float) node.getRadius()*((float)node.getSignalQuality()/(float)(maxSig-minSig)))); //improve speed 
                }
                setXrange(max[0]-min[0]);
                setYrange(max[1]-min[1]);
                setRrange(maxSig-minSig);
                
                
            } 
            catch (Exception e) {
                e.printStackTrace();
                return null;
            } 
            finally
            {
                try {
                    fileReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        return mNetwork;
    }
}