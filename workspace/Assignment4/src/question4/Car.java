package question4;

public abstract class Car implements Movable {
	// attributes
    private String brand;
    private double speed;
    
    // constructor
    public Car(String brand) {
        this.brand = brand;
        this.speed = 0;
    }
    
    // methods
    public String getBrand() {
        return brand;
    }
    
    public double getSpeed() {
        return speed;
    }
    
    public void setSpeed(double speed) {
        this.speed = speed;
    }
    
    public abstract void getSupply();
    
    public void stop() {
        speed = 0;
    }
}
