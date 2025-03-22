package question2;

public class Circle extends ClosedFigure {
    // Attributes
    private double x;
    private double y;
    private double radius;
    
    // Constructor
    public Circle(double x, double y, double radius) {
        super(1, 2 * Math.PI * radius);
        this.x = x;
        this.y = y;
        this.radius = radius;
    }
    
    // Getters
    public double getX() {
        return x;
    }
    
    public double getY() {
        return y;
    }
    
    public double getRadius() {
        return radius;
    }
    
    public boolean isInscribed(Object o) {
        if (o instanceof Rectangle) {
            Rectangle r = (Rectangle) o;
            if (r.getX() == x - radius && r.getX() + r.getWidth() == x + radius) {
                return true;
            }
            if (r.getY() == y - radius && r.getY() + r.getHeight() == y + radius) {
                return true;
            }
            return false;
        } else if (o instanceof Square) {
            Square s = (Square) o;
            if (s.getX() == x - radius && s.getX() + s.getSide() == x + radius) {
                return true;
            }
            if (s.getY() == y - radius && s.getY() + s.getSide() == y + radius) {
                return true;
            }
            return false;
        } else if (o instanceof Circle) {
            Circle c = (Circle) o;
            if (c.getX() == x && c.getY() == y && c.getRadius() == radius) {
                return true;
            }
            return false;
        }
        return false;
    }
    
    public String toString() {
        return "Circle(" + x + "," + y + "," + radius + ")";
    }
}

