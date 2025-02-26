package question2;

public class Student {
	private int ID;
	
	public Student(int ID) {
		// if ID is negative, set it to 0
		if (ID < 0) ID = 0;
        this.ID = ID;
    }
	
	public int getID() {
        return ID;
    }

	public static void testStudent() {
		// test Student class
		Student s1 = new Student(9999999);
		System.out.println(s1.getID() == 9999999);
		
		// test setName and getName
		Student s2 = new Student(-9999999);
		System.out.println(s2.getID() == 0);
		
		// test getGrade and setGrade
		Student s3 = new Student(0);
		System.out.println(s3.getID() == 0);
	}
}
