package question4;

public class ElectricCar extends Car {
	
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
