package question9;

public class Airplane implements Flyer {
	private String name;
	
	// Constructor
	public Airplane(String name) {
		this.name = name;
	}
	
	// Concrete methods
	public String getName() {
		return name;
	}
	
	public boolean canFly() {
		return true;
	}
	
	public boolean isDangerous() {
		return false;
	}
	
	public static void testAirplane() {
		Airplane a = new Airplane("Aircar");
		System.out.println(a.getName() == "Aircar");
		System.out.println(a.canFly() == true);
		System.out.println(a.isDangerous() == false);
	}
}