package question2;

public class Rectangle extends ClosedFigure {
    // Attributes
    private double x;
    private double y;
    private double width;
    private double height;
    
    // Constructor
    public Rectangle(double x, double y, double width, double height) {
        super(4, 2 * (width + height));
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }
    
    // Getters
    public double getX() {
        return x;
    }
    
    public double getY() {
        return y;
    }
    
    public double getWidth() {
        return width;
    }
    
    public double getHeight() {
        return height;
    }
    
    public String toString() {
        return "Rectangle(" + x + "," + y + "," + width + "," + height + ")";
    }
}