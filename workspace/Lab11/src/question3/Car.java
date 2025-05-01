package question3;

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

    // Opens a specific door by its number (starting from 1)
    public void openOneDoor(int doorNumber) {
        if (doorNumber < 1 || doorNumber > doors.length) {
            throw new BadDoorException("Door " + doorNumber + " does not exist!");
        }
        doors[doorNumber - 1].open();
    }
}
