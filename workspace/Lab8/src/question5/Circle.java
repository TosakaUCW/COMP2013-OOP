package question5;

// The Circle class derives from the Shape class.
public class Circle extends Shape {
	double radius;
	
	// The constructor initializes the x and y coordinates and the radius.
	public Circle(double x, double y, double radius) {
		super(x, y);
		this.radius = radius;
	}
	
	// The area method returns the area of the circle.
	@Override
	public double area() {
		return Math.PI * radius * radius;
	}
	
	// The resize method changes the radius of the circle.
	@Override
	public void resize(double newRadius) {
		this.radius = newRadius;
	}
	
	// The Circle class is not abstract (it has code for all methods) so
	// we can test it.
	public static void testCircle() {
		Circle c = new Circle(1.2, 3.4, 4.0);
		// getX, getY, and move are inherited from Shape.
		// area and resize come from Circle itself.
		System.out.println(c.getX() == 1.2);
		System.out.println(c.getY() == 3.4);
		System.out.println(c.area() == Math.PI * 16.0);
		// Move the circle. The area does not change.
		c.move(7.8, 9.0);
		System.out.println(c.getX() == 9.0);
		System.out.println(c.getY() == 12.4);
		System.out.println(c.area() == Math.PI * 16.0);
		// Resize the circle. The area changes but not the position.
		c.resize(8.0);
		System.out.println(c.getX() == 9.0);
		System.out.println(c.getY() == 12.4);
		System.out.println(c.area() == Math.PI * 64.0);
	}
}