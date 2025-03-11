package question3;

public class Student {

	public static void testStudent() {
		System.out.println("Test constructor");
		Cat c = new Cat("Meow", 2.0);
		Student s = new Student("Philippe", c);
		System.out.println("name: " + (s.getName() == "Philippe"));
		System.out.println("pet: " + (s.getPet() == c));
	}
}