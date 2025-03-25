package question8;

// The class Bird derives from the class Animal.
// The class must be abstract because it does not have any code for
// the canFly method (see below).
public abstract class Bird extends Animal implements Flyer{
	private int numOfEggs;
	
	// Constructor
	public Bird(String name, int numOfEggs) {
		super(name);
		this.numOfEggs = numOfEggs;
	}
	
	// The Bird class must implement the abstract method getLegs.
	// The getLegs method returns the number of legs of a bird.
	public int getLegs() {
		return 2;
	}
	
	// The Bird class must implement the abstract method canFly.
	// The canFly method returns true because birds can fly.
	public boolean canFly() {
		return true;
	}
	
	public int getNumOfEggs() {
		return numOfEggs;
	}
	
	public static void testBird() {
		// Bird b = new Bird("Twitter", 3); // This does not work!
	}
}