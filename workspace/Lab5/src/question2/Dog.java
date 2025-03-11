package question2;

public class Dog {

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