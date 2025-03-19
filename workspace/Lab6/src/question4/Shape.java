package question4;
public class Shape {
	// Attributes
	private double x;
	private double y;
	
	// Constructor
	public Shape(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	// Getters
	public double getX() {
		return x;
	}
	
	public double getY() {
		return y;
	}
	
	// Methods
	public double area() {
		System.out.println("An unknown shape has an unknown area!");
		return -1.0;
	}
	
	public String toString() {
		return "Shape area is " + area();
	}
	
	public static void testShape() {
		Shape s = new Shape(1.2, 3.4);
		System.out.println(s.getX() == 1.2);
		System.out.println(s.getY() == 3.4);
		System.out.println(s.area() == -1.0); // Will print an error message too.
		System.out.println(s.toString().equals("Shape area is -1.0"));
	}
}