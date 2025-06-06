package question4;
import java.util.ArrayList;

public class ManyShapes {
	// Attributes
	private ArrayList<Shape> allShapes;
	
	// Constructor
	public ManyShapes() {
		allShapes = new ArrayList<Shape>();
	}
	
	// Methods
	public void addShape(Shape s) {
		allShapes.add(s);
	}
	
	public void listAllShapes() {
		for (Shape s : allShapes) {
			System.out.println(s);
		}
	}
	
	public static void testManyShapes() {
		ManyShapes m = new ManyShapes();
		m.addShape(new Circle(1.2, 3.4, 4.0));         // Upcast from Circle to Shape.
		m.addShape(new Rectangle(1.2, 3.4, 4.0, 5.0)); // Upcast from Rectangle to Shape.
		m.addShape(new Shape(1.2, 3.4));
		m.listAllShapes();
	}
}