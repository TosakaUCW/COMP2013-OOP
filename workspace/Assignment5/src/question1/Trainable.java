package question1;

public interface Trainable {

    int learn(int amount) throws ExceedKnowledgeLimit, NotEnoughKnowledge;
}
