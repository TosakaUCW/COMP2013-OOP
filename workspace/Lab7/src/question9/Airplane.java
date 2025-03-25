package question9;

public class Airplane implements Flyer {

	public static void testAirplane() {
		Airplane a = new Airplane("Aircar");
		System.out.println(a.getName() == "Aircar");
		System.out.println(a.canFly() == true);
		System.out.println(a.isDangerous() == false);
	}
}