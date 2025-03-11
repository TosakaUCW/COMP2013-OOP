package question1;

public class Cat {
	// Attributes
	private String name;
	private double weight;

	// Constructor
	public Cat(String name, double weight) {
		this.name = name;
		this.weight = weight;
	}

	public String getName() {
		return name;
	}
	
	public double getWeight() {
		return weight;
	}
	
	public void feed() {
		weight += 1.0;
	}

	public static void testCat() {

		System.out.println("Test constructor");
		Cat c = new Cat("Meow", 2.0);
		System.out.println("name: " + (c.getName() == "Meow"));
		System.out.println("weight: " + (c.getWeight() == 2.0));

		System.out.println("\nTest feed");
		c.feed();
		// The name is still the same but the weight increased by 1.0:
		System.out.println("name: " + (c.getName() == "Meow"));
		System.out.println("weight: " + (c.getWeight() == 3.0));
	}
}