package question1;

public class Student {
	private int ID;
	
	public Student(int ID) {
        this.ID = ID;
    }
	
	public int getID() {
        return ID;
    }

	public static void testStudent() {
		// test Student class
		Student s = new Student(9999999);
		System.out.println(s.getID() == 9999999);
	}
}
