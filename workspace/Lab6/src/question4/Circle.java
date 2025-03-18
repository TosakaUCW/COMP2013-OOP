package question4;
// The Circle class derives from the Shape class.
public class Circle extends Shape {
	// Attributes
	private double radius;
	
	// Constructor
	public Circle(double x, double y, double radius) {
		super(x, y);
		this.radius = radius;
	}
	
	// Methods
	public double area() {
		return Math.PI * radius * radius;
	}
	
	public static void testCircle() {
		Circle c = new Circle(1.2, 3.4, 4.0);
		// getX and getY are inherited from Shape.
		// area comes from Circle itself.
		System.out.println(c.getX() == 1.2);
		System.out.println(c.getY() == 3.4);
		System.out.println(c.area() == Math.PI * 16.0);
		
	}
}

