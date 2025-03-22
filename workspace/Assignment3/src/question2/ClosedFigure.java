package question2;

public class ClosedFigure {
    // Attributes
    private int nEdges;
    private double perimeter;
    
    // Constructor
    public ClosedFigure(int nEdges, double perimeter) {
        this.nEdges = nEdges;
        this.perimeter = perimeter;
    }
    
    // Getters
    public int getNEdges() {
        return nEdges;
    }
    
    public double perimeter() {
        return perimeter;
    }
}