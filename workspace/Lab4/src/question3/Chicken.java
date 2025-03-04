package question3;
public class Chicken {
	private double weight;
	private	boolean sleeping;
	
	Chicken (double weight) {
		this.weight = weight;
		// When a chicken is created, it is initially sleeping (not awake)
		this.sleeping = true;
	}
	
	public double getWeight() {
		return this.weight;
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
	
	public static void testChicken() {
		Chicken c = new Chicken(2.3);

		System.out.println(c.getWeight() == 2.3);
		System.out.println(c.isSleeping() == true);
		c.wakeUp();
		System.out.println(c.isSleeping() == false);
		c.wakeUp(); // should do nothing because the chicken is already awake
		System.out.println(c.isSleeping() == false);
		c.fallAsleep();
		System.out.println(c.isSleeping() == true);
		c.fallAsleep(); // should do nothing because the chicken is already sleeping
		System.out.println(c.isSleeping() == true);
	}
}