package question3;

public class Student {
	// Attributes
	private String name;
	private Cat pet;
	
	// Constructor
	public Student(String name, Cat pet) {
		this.name = name;
		this.pet = pet;
	}
	
	// Method
	public String getName() {
		return name;
	}
	
	public Cat getPet() {
		return pet;
	}

	public static void testStudent() {
		System.out.println("Test constructor");
		Cat c = new Cat("Meow", 2.0);
		Student s = new Student("Philippe", c);
		System.out.println("name: " + (s.getName() == "Philippe"));
		System.out.println("pet: " + (s.getPet() == c));
	}
}