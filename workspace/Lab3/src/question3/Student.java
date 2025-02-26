package question3;

public class Student {
	private int ID;
	private String name;
	
	public Student(int ID, String name) {
		// if ID is negative, set it to 0
		if (ID < 0) ID = 0;
        this.ID = ID;
        this.name = name;
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

	public static void testStudent() {
		// test Student class
		Student s1 = new Student(9999999, "Philippe");
		System.out.println(s1.getID() == 9999999);
		
		// test setName and getName
		System.out.println(s1.getName() == "Philippe");
		s1.setName("Meunier");
		System.out.println(s1.getName() == "Meunier");
		
		// test getGrade and setGrade
		Student s2 = new Student(-9999999, "Unknown");
		System.out.println(s2.getID() == 0);
		Student s3 = new Student(0, "Unknown");
		System.out.println(s3.getID() == 0);
	}
}
