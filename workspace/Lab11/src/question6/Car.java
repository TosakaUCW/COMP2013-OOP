package question6;

public class Car {

    private String name;
    private Door[] doors;

    // Constructor for car with a name and number of doors
    public Car(String name, int numberOfDoors) {
        if (numberOfDoors < 1) {
            throw new BadCarException("A car must have at least one door!");
        }
        this.name = name;
        this.doors = new Door[numberOfDoors];
        for (int i = 0; i < numberOfDoors; i++) {
            doors[i] = new Door(); // Initially all doors are closed
        }
    }

    // Lists all doors and their states
    public void listDoors() {
        for (Door door : doors) {
            System.out.println(name + ": door is " + (door.isOpen() ? "open" : "closed"));
        }
    }

    // Counts the number of open doors
    public int countOpenDoors() {
        int openCount = 0;
        for (Door door : doors) {
            if (door.isOpen()) {
                openCount++;
            }
        }
        return openCount;
    }

    // Change all doors: open closed doors, close open doors
    public void changeAllDoors() {
        for (Door door : doors) {
            if (door.isOpen()) {
                door.close(); // Close if it's open
            } else {
                door.open(); // Open if it's closed
            }
        }
    }

    // Replace a specific door with a new one
    public void replaceDoor(int doorNumber) {
        if (doorNumber < 1 || doorNumber > doors.length) {
            throw new BadDoorException("Door " + doorNumber + " does not exist!");
        }
        doors[doorNumber - 1] = new Door(); // Replace the specified door with a new one
    }

    // Replace all doors with new ones
    public void replaceAllDoors() {
        for (int i = 0; i < doors.length; i++) {
            doors[i] = new Door(); // Replace each door with a new one
        }
    }

    public void replaceManyDoors(int numOfDoorsToReplace) {
        int doorsToReplace = Math.min(numOfDoorsToReplace, doors.length);
        for (int i = 0; i < doorsToReplace; i++) {
            doors[i] = new Door(); // Replace each door with a new one
        }
        if (numOfDoorsToReplace > doors.length) {
            // If trying to replace more doors than available, throw the exception
            throw new ArrayIndexOutOfBoundsException("Index " + doors.length + " out of bounds for length " + doors.length);
        }
    }

    // Opens a specific door by its number (starting from 1)
    public void openOneDoor(int doorNumber) {
        if (doorNumber < 1 || doorNumber > doors.length) {
            throw new BadDoorException("Door " + doorNumber + " does not exist!");
        }
        doors[doorNumber - 1].open();
    }

    // Adds two new doors to the car, keeping the existing doors intact
    public void expandCar() {
        // Create a new array with 2 more spaces than the current array
        Door[] newDoors = new Door[doors.length + 2];

        // Copy existing doors to the new array
        for (int i = 0; i < doors.length; i++) {
            newDoors[i] = doors[i];
        }

        // Add two new doors to the end of the new array
        newDoors[doors.length] = new Door(); // New door 1
        newDoors[doors.length + 1] = new Door(); // New door 2

        // Update the original doors array to the new expanded array
        doors = newDoors;
    }
}
