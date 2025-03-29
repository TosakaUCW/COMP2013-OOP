package question3;

public class GasCar extends Car {
	// attributes
	private double gasLevel;
	
	// constructor
	public GasCar(String brand) {
		super(brand);
		this.gasLevel = 0;
	}
	
	// methods
	public void getSupply() {
		gasLevel = 1;
	}
	
	public boolean start() {
		// tries to start the car. If the gas level is no more than zero, the car fails to start with an error message
		// “Error: No gas!”. Otherwise, the car starts with a speed of 60, and this operation decreases the gas level by 0.2. Then
		// it prints a message “<brand> starts!”. For example, if the car’s brand is “BMW”, then it prints “BMW starts!”.
		
		if (gasLevel <= 0) {
			System.out.println("Error: No gas!");
			return false;
		} else {
			setSpeed(60);
			gasLevel -= 0.2;
			System.out.println(getBrand() + " starts!");
			return true;
		}
	}
	
	public static void testGasCar() {
		// Create a new GasCar instance
		GasCar car = new GasCar("BMW");
		// Test the constructor
		System.out.println(car.getBrand() == "BMW");
		System.out.println(car.getSpeed() == 0);
		System.out.println(car.gasLevel == 0);

		// Test getSupply() by refueling
		car.getSupply();
		System.out.println(car.gasLevel == 1);

		// Test start() when gas is available
		car.start();
		System.out.println(car.getSpeed() == 60);
		System.out.println(car.gasLevel == 0.8);

		// Test start() when gas is empty
		car.gasLevel = 0;
		car.stop();
		car.start();
		System.out.println(car.gasLevel == 0);
		System.out.println(car.getSpeed() == 0);
	}
}
