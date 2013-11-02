package visulaliser.model;

public class Message {

    private ID mToID;
    private ID mFromID;
    private String mMessage;
    private ID mNode0;
    private ID mMessageID;

    public Message(ID to, ID from) {
        mToID = to;
        mFromID = from;
        mMessageID = ID.generateID();
        
    }
}
