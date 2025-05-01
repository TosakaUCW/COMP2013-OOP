package question7;

import java.util.ArrayList;

public class Car {

    private String name;
    private ArrayList<Door> doors;

    // Constructor for car with a name and number of doors
    public Car(String name, int numberOfDoors) {
        if (numberOfDoors < 1) {
            throw new BadCarException("A car must have at least one door!");
        }
        this.name = name;
        this.doors = new ArrayList<>();
        for (int i = 0; i < numberOfDoors; i++) {
            doors.add(new Door()); // Initially all doors are closed
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
        if (doorNumber < 1 || doorNumber > doors.size()) {
            throw new BadDoorException("Door " + doorNumber + " does not exist!");
        }
        doors.set(doorNumber - 1, new Door());
    }

    // Replace all doors with new ones
    public void replaceAllDoors() {
        for (int i = 0; i < doors.size(); i++) {
            doors.set(i, new Door());
        }
    }

    public void replaceManyDoors(int numOfDoorsToReplace) {
        int doorsToReplace = Math.min(numOfDoorsToReplace, doors.size());
        for (int i = 0; i < doorsToReplace; i++) {
            doors.set(i, new Door());
        }
        if (numOfDoorsToReplace > doors.size()) {
            // If trying to replace more doors than available, throw the exception
            throw new ArrayIndexOutOfBoundsException("Index " + doors.size() + " out of bounds for length " + doors.size());
        }
    }

    // Opens a specific door by its number (starting from 1)
    public void openOneDoor(int doorNumber) {
        if (doorNumber < 1 || doorNumber > doors.size()) {
            throw new BadDoorException("Door " + doorNumber + " does not exist!");
        }
        doors.get(doorNumber - 1).open();
    }

    // Adds two new doors to the car, keeping the existing doors intact
    public void expandCar() {
        doors.add(new Door()); // Add new door 1
        doors.add(new Door()); // Add new door 2
    }
}
