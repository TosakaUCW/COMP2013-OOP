package question5;

public class Student {
	private int ID;
	private String name;
	private char grade;
	
	public Student(int ID, String name) {
		// if ID is negative, set it to 0
		if (ID < 0) ID = 0;
        this.ID = ID;
        this.name = name;
		// grade is initialized to 'A'
        this.grade = 'A';
    }

    public Student(int ID, String name, char grade) {
		// if ID is negative, set it to 0
		if (ID < 0) ID = 0;
        this.ID = ID;
        this.name = name;
        this.grade = grade;
    }
	
	public int getID() {
        return ID;
    }
	
	public String getName() {
        return name;
    }
	
	public void setName(String name) {
        this.name = name;
    }
	
	public char getGrade() {
        return grade;
    }
	
	public void setGrade(char grade) {
        this.grade = grade;
    }

	public static void testStudent() {
		// test Student class
		Student s1 = new Student(9999999, "Philippe");
		System.out.println(s1.getID() == 9999999);
		
		// test setName and getName
		System.out.println(s1.getName() == "Philippe");
		s1.setName("Meunier");
		System.out.println(s1.getName() == "Meunier");

		// test getGrade and setGrade
		System.out.println(s1.getGrade() == 'A');
		s1.setGrade('F');
		System.out.println(s1.getGrade() == 'F');
		
		// test goToSleep and wakeUp
		Student s2 = new Student(-9999999, "Unknown");
		System.out.println(s2.getID() == 0);
		Student s3 = new Student(0, "Unknown");
		System.out.println(s3.getID() == 0);

		// test the constructor with the grade
		Student s4 = new Student(9999999, "Philippe", 'B');
		System.out.println(s4.getID() == 9999999);
		System.out.println(s4.getName() == "Philippe");
		System.out.println(s4.getGrade() == 'B');

		// test the constructor with the grade when the ID is negative
		Student s5 = new Student(-9999999, "Unknown", 'C');
		System.out.println(s5.getID() == 0);
		Student s6 = new Student(0, "Unknown", 'C');
		System.out.println(s6.getID() == 0);
	}
}
