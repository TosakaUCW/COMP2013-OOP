package question1;

public class Dog extends Animal {
	// Attributes
	private String breed;
	
	// Constructor
	public Dog(String name, double weight) {
		super(name, weight);
		this.breed = "unknown";
	}
	
	public String getBreed() {
		return breed;
	}
	
	public void setBreed(String breed) {
		this.breed = breed;
	}
	
	public void feed() {
		setWeight(getWeight() + 2.0);
	}
}