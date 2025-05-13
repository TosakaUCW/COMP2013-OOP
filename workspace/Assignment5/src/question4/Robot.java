package question4;

public class Robot extends Agent {

    // Constructor: Takes capacity and knowledge as arguments
    public Robot(int capacity, int knowledge) throws BadInitialSetting {
        super(capacity, knowledge);  // Calls the parent class constructor to initialize capacity and knowledge
    }

    // Override the learn method, since Robot cannot learn or forget knowledge
    @Override
    public int learn(int amount) {
        // Robot's knowledge stays unchanged, so we just return the current knowledge
        return getKnowledge();
    }

    // Override canTalk method, as Robot cannot talk
    @Override
    public boolean canTalk() {
        return false;  // Robot is not able to talk
    }

    public static void testRobot() {
        /*test case for constructors */
        try {
            Robot r1 = new Robot(50, 60);
        } catch (BadInitialSetting e) {
            System.out.println(e.getMessage().equals("Knowledge cannot greater than capacity!"));
        }

        try {
            Robot r2 = new Robot(50, -10);
        } catch (BadInitialSetting e) {
            System.out.println(e.getMessage().equals("Capacity or knowledge cannot be negative!"));
        }

        /* test case for learn, canTalk and getKnowledge methods	*/
        try {
            Robot r3 = new Robot(100, 50);
            System.out.println(r3.canTalk() == false);
            System.out.println(r3.getKnowledge() == 50);
            r3.learn(20);
            System.out.println(r3.getKnowledge() == 50);
        } catch (BadInitialSetting e) {
            System.out.println("BUG! THIS MUST NEVER HAPPEN!");
        }
    }
}
