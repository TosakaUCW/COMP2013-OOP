package question4;

public interface Trainable {

    int learn(int amount) throws ExceedKnowledgeLimit, NotEnoughKnowledge;
}
