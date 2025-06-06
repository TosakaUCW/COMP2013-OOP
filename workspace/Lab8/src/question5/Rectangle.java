package question5;

// The Rectangle class derives from the Shape class.
public class Rectangle extends Shape {
    double width, height;
    
    // The constructor initializes the x and y coordinates, width, and height.
    public Rectangle(double x, double y, double width, double height) {
        super(x, y);
        this.width = width;
        this.height = height;
    }
    
    // The area method returns the area of the rectangle.
    @Override
    public double area() {
        return width * height;
    }
    
    // The resize method changes the width and height of the rectangle
    @Override
    public void resize(double newSize) {
        this.width = newSize;
        this.height = newSize;
    }

    // The Rectangle class is not abstract (it has code for all methods) so
    // we can test it.
    public static void testRectangle() {
        Rectangle r = new Rectangle(1.2, 3.4, 4.0, 5.0);
        // getX, getY, and move are inherited from Shape.
        // area and resize come from Rectangle itself.
        System.out.println(r.getX() == 1.2);
        System.out.println(r.getY() == 3.4);
        System.out.println(r.area() == 20.0);
        // Move the rectangle. The area does not change.
        r.move(7.8, 9.0);
        System.out.println(r.getX() == 9.0);
        System.out.println(r.getY() == 12.4);
        System.out.println(r.area() == 20.0);
        // Resize the rectangle. The area changes but not the position.
        r.resize(12.0);
        System.out.println(r.getX() == 9.0);
        System.out.println(r.getY() == 12.4);
        System.out.println(r.area() == 144.0);
    }
}