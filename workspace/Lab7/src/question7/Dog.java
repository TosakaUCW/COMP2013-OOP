package question7;

// The class Dog derives from the class Animal.
public class Dog extends Animal {
	// Constructor
	public Dog(String name) {
		super(name);
	}
	
	// The Dog class must implement the abstract methods getLegs and canFly.
	// The getLegs method returns the number of legs of a dog.
	public int getLegs() {
		return 4;
	}
	
	// The canFly method returns false because dogs cannot fly.
	public boolean canFly() {
		return false;
	}
	
	public static void testDog() {
		Dog d = new Dog("Nice Doggy");
		// The getName method is inherited from Animal.
		// The getLegs and canFly methods come from Dog itself.
		System.out.println(d.getName() == "Nice Doggy");
		System.out.println(d.getLegs() == 4);
		System.out.println(d.canFly() == false);
	}
}