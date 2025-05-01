package question3;

public class Door {

    // Instance variable to track if the door is open
    private boolean isOpen;

    // Constructor initializes the door as closed
    public Door() {
        this.isOpen = false;
    }

    // Returns if the door is open
    public boolean isOpen() {
        return isOpen;
    }

    // Opens the door
    public void open() {
        if (!isOpen) {
            isOpen = true;
        }
    }

    // Closes the door
    public void close() {
        if (isOpen) {
            isOpen = false;
        }
    }
}
