package visulaliser.model;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Splitter
{
	//constructor
	
	public Splitter(){
		
	}
    public ArrayList<Node> networkParse(String filename) //returns an arraylist of nodes from file
    {
        //Input file which needs to be parsed
        String fileToParse = "C:\\Users\\Walnutmonster\\Desktop\\hack (1)\\glasgowhack.csv";
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
            
            //Read the file line by line
            while ((line = fileReader.readLine()) != null) 
            {
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
                longX = (int) (Double.parseDouble(tokens[6]) * 1E6);
                latY = (int) (Double.parseDouble(tokens[6]) * 1E6);
                // String mNodeID=tokens[0];
                mSignalQuality = Integer.parseInt(tokens[10]); 
                }catch(NumberFormatException e){
                	continue;
                }
                String mName=tokens[3];   //ssid
                               
                Node mNewNode= new Node(longX, latY, mName, mSignalQuality);
                mNetwork.add(mNewNode);
                if (longX > max[0])
                	max[0] = longX;
                else if (longX < min[0])
                	min[0] = longX;

                if (latY > max[1])
                	max[1] = longX;
                else if (latY < min[1])
                	min[1] = longX;
                
            }
            
            //augmentation of coordinates
            int i;
            for(i=0;i<mNetwork.size();i++){
            	Node node = mNetwork.get(i);
            	node.setX(node.getX() - min[0]);
            	node.setY(node.getY() - min[1]);
            }
            
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