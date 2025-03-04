package question2;

public class Student {
	private int ID;
	private boolean sleeping;
	
	Student(int ID) {
		this.ID = ID;
		// When a student is created, it is initially awake (not sleeping)
		this.sleeping = false;
	}
	
	public int getID() {
		return this.ID;
	}
	
	// The isSleeping method indicates as a result
	// whether the student is currently sleeping or not.
	public boolean isSleeping() {
		return this.sleeping;
	}
	
	public void fallAsleep() {
		// If the student is already sleeping, do nothing
		if (this.sleeping) {
			return;
		}
		this.sleeping = true;
	}
	
	public void wakeUp() {
		// If the student is already awake, do nothing
		if (!this.sleeping) {
			return;
		}
		this.sleeping = false;
	}

	public static void testStudent() {
		Student s = new Student(1234567890);

		System.out.println(s.getID() == 1234567890);
		System.out.println(s.isSleeping() == false);
		s.fallAsleep();
		System.out.println(s.isSleeping() == true);
		s.fallAsleep(); // should do nothing because the student is already sleeping
		System.out.println(s.isSleeping() == true);
		s.wakeUp();
		System.out.println(s.isSleeping() == false);
		s.wakeUp(); // should do nothing because the student is already awake
		System.out.println(s.isSleeping() == false);
	}
}