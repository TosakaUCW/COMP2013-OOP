package question8;

// The Circle class derives from the Shape class.
public class Circle extends Shape {
	double radius;
	
	// The constructor initializes the x and y coordinates and the radius.
	public Circle(double x, double y, double radius) throws BadRadiusException {
		super(x, y);
		if (radius < 0) {
			throw new BadRadiusException("Radius must be positive!");
		}
		this.radius = radius;
	}
	
	// The area method returns the area of the circle.
	@Override
	public double area() {
		return Math.PI * radius * radius;
	}
	
	// The resize method changes the radius of the circle.
	@Override
	public void resize(double newRadius) throws BadRadiusException {
		if (newRadius < 0) {
			throw new BadRadiusException("Radius must be positive!");
		}
		this.radius = newRadius;
	}

	// The Circle class is not abstract (it has code for all methods) so
	// we can test it.
	public static void testCircle() {
		// Create a circle with a positive radius.
		// No exception is thrown until we resize with a
		// negative radius.
		try {
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
			// Resize the circle with a negative radius.
			// An exception is thrown, caught, and tested.
			c.resize(-12.3);
			System.out.println(c.getX() == 9.0); // Unreachable.
			System.out.println(c.getY() == 12.4);
			System.out.println(c.area() == Math.PI * 64.0);
		} catch (BadRadiusException ex) {
			System.out.println(ex.getMessage() == "Radius must be positive!");
		}
		// Create a circle with a positive radius.
		// Resize the circle with a zero radius.
		// No exception is thrown.
		try {
			Circle c = new Circle(1.2, 3.4, 4.0);
			c.resize(0.0);
			// The area is now zero, the position does not change.
			System.out.println(c.getX() == 1.2);
			System.out.println(c.getY() == 3.4);
			System.out.println(c.area() == 0.0);
		} catch (BadRadiusException ex) {
			System.out.println("BUG! This must never happen!");
		}
		// Try to create a circle with a negative radius.
		// An exception is thrown, caught, and tested.
		try {
			Circle c2 = new Circle(1.2, 3.4, -5.6);
		} catch (BadRadiusException ex) {
			System.out.println(ex.getMessage() == "Radius must be positive!");
		}
		// Create a circle with a zero radius.
		// No exception is thrown.
		try {
			Circle c3 = new Circle(1.2, 3.4, 0.0);
			System.out.println(c3.getX() == 1.2);
			System.out.println(c3.getY() == 3.4);
			System.out.println(c3.area() == 0.0);
		} catch (BadRadiusException ex) {
			System.out.println("BUG! This must never happen!");
		}
	}
}