package visulaliser.model;
public class ID {
    private static int nextID = 0;    
    
    public final int ID;
    
    private ID(){
        ID = nextID;
        ++nextID;
    
    }
    
    public static ID generateID(){
        return new ID();        
    }
    
}
