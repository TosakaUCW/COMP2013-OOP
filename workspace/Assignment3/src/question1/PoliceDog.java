package question1;

public class PoliceDog extends Dog{
	// Attributes
    private int weekHours;
    private static int totalHoursforAll;
    private int times;
    private Police trainer;
    
    // Constructor
    public PoliceDog(String name, double weight) {
        super(name, weight);
        this.weekHours = 0;
        this.times = 0;
        this.trainer = null;
    }
    
    public int getWeekHours() {
        if (times < 7) {
            System.out.println("No a week yet");
        }
        return weekHours;
    }
    
    public static int getTotalHours() {
        return totalHoursforAll;
    }
    
    public void setTrainer(Police trainer) {
        this.trainer = trainer;
    }
    
    public Police getTrainer() {
        return trainer;
    }
    
    public void train(int hours) {
        if (times == 7) {
            times = 0;
            weekHours = 0;
        }
        weekHours += hours;
        totalHoursforAll += hours;
        times++;
    }
}
