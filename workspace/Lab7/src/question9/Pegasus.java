package question9;

// The class Pegasus derives from the class Bird.
public class Pegasus extends Bird {
	// Constructor
	public Pegasus(String name) {
		super(name, 0);
	}
	
	// The Pegasus class must implement the abstract method canFly.
	// The canFly method returns true because Pegasus can fly.
	public boolean canFly() {
		return true;
	}
	
	// The getLegs method returns the number of legs of a Pegasus.
	public int getLegs() {
		return 4;
	}
	
	public int getNumOfEggs() {
		System.out.println("Pegasi do not lay eggs!");
		return 0;
	}
	
	public boolean isDangerous() {
		return false;
	}
	
	public static void TestPegasus() {
		Pegasus p = new Pegasus("Peggie");
		// The getName method is inherited from Bird, which inherits it
		// from Animal.
		// The getLegs method is from Pegasus, which overrides the getLegs// method
		// inherited from Bird, which overrides the abstract
		// getLegs method inherited by Bird from Animal.
		// The getNumOfEggs method is from Pegasus, which overrides the
		// getNumOfEggs method inherited from Bird.
		// The canFly method is from Pegasus, which overrides the abstract// canFly
		// method inherited from Bird, which inherits it from
		// Animal.System.out.println(p.getName() == "Peggie");
		System.out.println(p.getLegs() == 4);
		System.out.println(p.getNumOfEggs() == 0); // Message printed here.System.out.println(p.canFly() == true);
		System.out.println(p.isDangerous() == false);
	}
}