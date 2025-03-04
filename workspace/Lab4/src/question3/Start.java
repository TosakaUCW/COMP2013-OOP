package question3;

public class Start {
	public static String check(Student someStudent) {
		if (someStudent.isSleeping()) {
			return "sweet dreams";
		} else {
			return "need coffee";
		}
	}

	public static void main(String[] args) {
		Student.testStudent();
		Chicken.testChicken(); // now also testing the Chicken class!

		// Test the 'check' method using a Student.
		// We need to test both branches of the 'if' statement.
		Student s = new Student(1234567890);
		System.out.println(check(s) == "need coffee");
		s.fallAsleep();
		System.out.println(check(s) == "sweet dreams");
	}
}