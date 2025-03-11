package question4;

public class Animal {

	public static void testAnimal() {
		System.out.println("Test constructor");
		Animal a = new Animal("Blob", 2.0);
		System.out.println("name: " + (a.getName() == "Blob"));
		System.out.println("weight: " + (a.getWeight() == 2.0));

		System.out.println("\nTest setWeight");
		a.setWeight(3.0);
		System.out.println("name: " + (a.getName() == "Blob"));
		System.out.println("weight: " + (a.getWeight() == 3.0));
	}
}