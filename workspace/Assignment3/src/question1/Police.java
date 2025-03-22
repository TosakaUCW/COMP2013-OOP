package question1;

public class Police {
	// Attributes
    private int ID;
    private String name;
    
    // Constructor
    public Police(String name, int ID) {
        this.ID = ID;
        this.name = name;
    }
    
    public int getID() {
        return ID;
    }
    
    public String getName() {
        return name;
    }
}
