package question2;

public class Dog {
	// Attributes
	private String name;
	private String breed;
	private double weight;

	// Constructor
	public Dog(String name, double weight) {
		this.name = name;
		this.breed = "unknown";
		this.weight = weight;
	}

	public String getName() {
		return name;
	}
	
	public double getWeight() {
		return weight;
	}
	
	public String getBreed() {
		return breed;
	}
	
	public void setBreed(String breed) {
		this.breed = breed;
	}
	
	public void feed() {
		weight += 2.0;
	}	

	public static void testDog() {
		System.out.println("Test constructor");
		Dog d = new Dog("Woof", 2.0);
		System.out.println("name: " + (d.getName() == "Woof"));
		System.out.println("weight: " + (d.getWeight() == 2.0));
		System.out.println("breed: " + (d.getBreed() == "unknown"));

		System.out.println("\nTest setBreed");
		d.setBreed("Poodle");
		System.out.println("name: " + (d.getName() == "Woof"));
		System.out.println("weight: " + (d.getWeight() == 2.0));
		System.out.println("breed: " + (d.getBreed() == "Poodle"));

		System.out.println("\nTest feed");
		d.feed();
		System.out.println("name: " + (d.getName() == "Woof"));
		System.out.println("weight: " + (d.getWeight() == 4.0));
		System.out.println("breed: " + (d.getBreed() == "Poodle"));
	}
}