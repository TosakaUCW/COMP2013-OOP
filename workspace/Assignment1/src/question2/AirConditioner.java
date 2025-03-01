package question2;

public class AirConditioner {
    private boolean powerOn;
    private int mode;
    private int temperature;
    
    // constructor
    public AirConditioner() {
        powerOn = false;
        mode = 0;
        temperature = 16;
    }
    
    // getters
    public boolean getPower() {
        return powerOn;
    }
    
    public int getMode() {
        return mode;
    }
    
    public int getTemperature() {
        return temperature;
    }
    
    // setters
    
    // turnOn is a public method that sets the powerOn variable to true.
    public void turnOn() {
        powerOn = true;
    }
    
    // turnOff is a public method that sets the powerOn variable to false.
    public void turnOff() {
        powerOn = false;
    }
    
    // setMode is a public method that sets the mode variable to the input mode
    public void setMode(int mode) {
        // If the AC is power off, this function should print "Please turn on the AC first." and return.
        if (!powerOn) {
            System.out.println("Please turn on the AC first.");
            return;
        }
        
        // If the code is invalid, setMode should print "Invalid mode." and return.
        if (mode < 0 || mode > 2) {
            System.out.println("Invalid mode.");
            return;
        }
        
        // If the code is valid, set the mode variable to the input mode.
        this.mode = mode;
    }
    
    // setTemperature is a public method that sets the temperature variable to the
    public void setTemperature(int temperature) {
        // If the AC is power off, this function should print "Please turn on the AC first." and return.
        if (!powerOn) {
            System.out.println("Please turn on the AC first.");
            return;
        }
        
        // If the AC is power on but is on the dry mode, setTemperature should 
        // print "Cannot set the temperature in the dry mode." and return.
        if (mode == 2) {
            System.out.println("Cannot set the temperature in the dry mode.");
            return;
        }
        
        // The valid range of temperature is from 16 to 30 degrees. If temp is invalid, 
        // setTemperature should print "Invalid temperature." and return.
        if (temperature < 16 || temperature > 30) {
            System.out.println("Invalid temperature.");
            return;
        }
        
        this.temperature = temperature;
    }   
    
    // testAirConditioner is a public static method that tests all the code in the
    // AirConditioner class.
    public static void testAirConditioner() {
        AirConditioner ac = new AirConditioner();
        // test the constructor
        System.out.println(ac.getPower() == false);
        System.out.println(ac.getMode() == 0);
        System.out.println(ac.getTemperature() == 16);
        // test the power functions
        ac.turnOn();
        System.out.println(ac.getPower() == true);
        ac.turnOff();
        System.out.println(ac.getPower() == false);
        // test the mode functions
        ac.setMode(1);
        System.out.println(ac.getMode() == 0);
        ac.turnOn();
        ac.setMode(5);
        System.out.println(ac.getMode() == 0);
        ac.setMode(2);
        System.out.println(ac.getMode() == 2);
        // test the temperature functions
        ac.turnOff();
        ac.setTemperature(20);
        System.out.println(ac.getTemperature() == 16);
        ac.turnOn();
        ac.setTemperature(20);
        System.out.println(ac.getTemperature() == 16);
        ac.setMode(1);
        ac.setTemperature(31);
        System.out.println(ac.getTemperature() == 16);
        ac.setTemperature(20);
        System.out.println(ac.getTemperature() == 20);
    }
}
