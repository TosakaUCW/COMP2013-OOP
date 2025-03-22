package question2;

public class Square extends Rectangle {
	// Attributes
    private double x;
    private double y;
    private double side;
    
    // Constructor
    public Square(double x, double y, double side) {
        super(x, y, side, side);
        this.x = x;
        this.y = y;
        this.side = side;
    }
    
    // Getters
    public double getSide() {
        return side;
    }
    
    public String toString() {
        return "Square(" + x + "," + y + "," + side + ")";
    }
}
