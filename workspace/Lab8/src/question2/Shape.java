package question2;

// The Shape class must be abstract because the area and resize
// methods are abstract.
public abstract class Shape {
	double x, y;
	
	// The constructor initializes the x and y coordinates.
	public Shape(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	// The getX method returns the x coordinate.
	public double getX() {
		return x;
	}
	
	// The getY method returns the y coordinate.
	public double getY() {
		return y;
	}
	
	public void move(double dx, double dy) {
		this.x += dx;
		this.y += dy;
	}
	
	// The area method is abstract, so it must be implemented
	// in the subclasses.
	public abstract double area();
	
	// The resize method is abstract, so it must be implemented
	// in the subclasses.
	public abstract void resize(double factor);
	
	

	// The testShape method is empty because we cannot create objects
	// from the Shape class, since it is abstract.
	public static void testShape() {
	}
}