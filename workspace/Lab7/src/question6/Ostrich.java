package question6;

// The class Ostrich derives from the class Bird.
public class Ostrich extends Bird {
	// Constructor
	public Ostrich(String name) {
		super(name, 10);
	}
	
	// The Ostrich class must implement the abstract method canFly.
	// The canFly method returns false because ostriches cannot fly.
	public boolean canFly() {
		return false;
	}

	public static void testOstrich() {
		Ostrich o = new Ostrich("Ossie");
		// The getName method is inherited from Bird, which inherits it
		// from Animal.
		// The getLegs method is inherited from Bird, which overrides
		// the abstract getLegs method inherited by Bird from Animal.
		// The getNumOfEggs method is inherited from Bird.
		// The canFly method is from Ostrich, which overrides the abstract// canFly
		// method inherited from Bird, which inherits it from
		// Animal.System.out.println(o.getName() == "Ossie");
		System.out.println(o.getLegs() == 2);
		System.out.println(o.getNumOfEggs() == 10);
		System.out.println(o.canFly() == false);
	}
}