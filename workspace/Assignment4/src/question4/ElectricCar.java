package question4;

public class ElectricCar extends Car {
	// attributes
	private double chargeLevel;
	
	// constructor
	public ElectricCar(String brand) {
		super(brand);
		this.chargeLevel = 0;
	}
	
	// methods
	public void getSupply() {
		chargeLevel = 1;
	}
	
	public boolean start() {
		// start(): tries to start the car. If the charge level is no more than zero, the car fails to start with an error message
		// “Error: Empty battery!”. Otherwise, the car starts with a speed of 80, and this operation decreases the charge level
		// by 0.1. Then it prints a message “<brand> starts!”.
		
		if (chargeLevel <= 0) {
			System.out.println("Error: Empty battery!");
			return false;
		} else {
			setSpeed(80);
			chargeLevel -= 0.1;
			System.out.println(getBrand() + " starts!");
			return true;
		}
	}
	
	public static void testElectricCar() {
		// Create a new ElectricCar instance
		ElectricCar car = new ElectricCar("BYD");
		// Test the constructor
		System.out.println(car.getBrand() == "BYD");
		System.out.println(car.getSpeed() == 0);
		System.out.println(car.chargeLevel == 0);

		// Test getSupply() by recharging
		car.getSupply();
		System.out.println(car.chargeLevel == 1);

		// Test start() when battery is available
		car.start();
		System.out.println(car.getSpeed() == 80);
		System.out.println(car.chargeLevel == 0.9);

		// Test start() when battery is empty
		car.chargeLevel = 0;
		car.stop();
		car.start();
		System.out.println(car.chargeLevel == 0);
		System.out.println(car.getSpeed() == 0);
	}
}
