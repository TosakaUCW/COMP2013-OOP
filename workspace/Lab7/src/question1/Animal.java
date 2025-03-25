package question1;

// The Animal class must be abstract because its two methods getLegs
// and canFly (below) are abstract.
public abstract class Animal {
	// Attributes
	private String name;
	
	// Constructor
	public Animal(String name) {
		this.name = name;
	}
	
	// Abstract methods
	public abstract int getLegs();
	
	public abstract boolean canFly();
	
	// Concrete method
	public String getName() {
		return name;
	}

	public static void testAnimal() {
		// Animal a = new Animal("Unknown"); // This does not work!
	}
}