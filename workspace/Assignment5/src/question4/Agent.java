package question4;

public class Agent implements Trainable {

    private int knowledge;
    private int capacity;

    // constructor
    public Agent(int capacity, int knowledge) throws BadInitialSetting {
        if (capacity < 0 || knowledge < 0) {
            throw new BadInitialSetting("Capacity or knowledge cannot be negative!");
        }
        if (knowledge > capacity) {
            throw new BadInitialSetting("Knowledge cannot greater than capacity!");
        }
        this.capacity = capacity;
        this.knowledge = knowledge;
    }

    @Override
    public int learn(int amount) throws ExceedKnowledgeLimit, NotEnoughKnowledge {
        if (amount >= 0) {
            if (knowledge + amount > capacity) {
                throw new ExceedKnowledgeLimit("Current knowledge is " + knowledge + ". Learn " + amount + " will exceed the capacity!");
            }
            knowledge += amount;
        } else {
            if (knowledge + amount < 0) {
                throw new NotEnoughKnowledge("Current knowledge is " + knowledge + ", not enough amount to forget!");
            }
            knowledge += amount;
        }
        return knowledge;
    }

    // get knowledge
    public int getKnowledge() {
        return knowledge;
    }

    public boolean canTalk() {
        return true;
    }

    public static void testAgent() {
        try {
            Agent agent = new Agent(100, 50);
            System.out.println("Initial knowledge: " + agent.getKnowledge());
            agent.learn(30);
            System.out.println("After learning 30: " + agent.getKnowledge());
            agent.learn(-20);
            System.out.println("After forgetting 20: " + agent.getKnowledge());
            agent.learn(60);  // Will throw exception
        } catch (ExceedKnowledgeLimit | NotEnoughKnowledge | BadInitialSetting e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
}
