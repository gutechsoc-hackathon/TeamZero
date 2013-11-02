package visulaliser.model;

import java.util.HashMap;

public class Node {

    private ID mNodeID;
    private HashMap<String, Message> mMessages;
    double mY;
    double mX;
    private String mName;
    private String mSignalQuality;

    Node(double x, double y) {
    }

    public ID getNodeID() {
        return mNodeID;
    }

    public double getX() {
        return mX;
    }

    public double getY() {
        return mY;
    }

    public String getName() {
        return mName;
    }

    public String getSignalQuality() {
        return mSignalQuality;
    }
}
