package question7;

// The Square class derives from the Rectangle class.
public class Square extends Rectangle {
    // The constructor initializes the x and y coordinates and the side length.
    public Square(double x, double y, double size) {
        super(x, y, size, size);
    }
    
    @Override
    public void resize(double width, double height) throws CannotResizeException {
        if (width != height) {
            throw new CannotResizeException("Cannot resize a square into a rectangle!");
        }
        super.resize(width, height);
    }
 
    public static void testSquare() {
        Square s = new Square(1.2, 3.4, 5.0);
        // getX, getY, and move are inherited from Shape.
        // area and resize are inherited from Rectangle.
        System.out.println(s.getX() == 1.2);
        System.out.println(s.getY() == 3.4);
        System.out.println(s.area() == 25.0);
        // Move the square. The area does not change.
        s.move(7.8, 9.0);
        System.out.println(s.getX() == 9.0);
        System.out.println(s.getY() == 12.4);
        System.out.println(s.area() == 25.0);
        // Resize the square. The area changes but not the position.
        s.resize(12.0);
        System.out.println(s.getX() == 9.0);
        System.out.println(s.getY() == 12.4);
        System.out.println(s.area() == 144.0);
        // Resize the square again with different width and length!
        try {
            s.resize(10.0, 15.0);
            System.out.println(s.getX() == 9.0); // Unreachable.
            System.out.println(s.getY() == 12.4);
            System.out.println(s.area() == 150.0);
        } catch (CannotResizeException ex) {
            System.out.println(ex.getMessage() == "Cannot resize a square into a rectangle!");
        }
        // The area and position do not change.
        System.out.println(s.getX() == 9.0);
        System.out.println(s.getY() == 12.4);
        System.out.println(s.area() == 144.0);
        // Resize the square again with equal width and length.
        // The area changes but not the position.
        try {
            s.resize(10.0, 10.0);
        } catch (CannotResizeException ex) {
            System.out.println("BUG! This must never happen!");
        }
        System.out.println(s.getX() == 9.0);
        System.out.println(s.getY() == 12.4);
        System.out.println(s.area() == 100.0);
    }

}
