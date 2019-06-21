package questions;

public class QuestionNode {
    public QuestionNode yesNode;
    public QuestionNode noNode;
    public String question;
    public String object;

    public QuestionNode(String question, String object, QuestionNode yesNode, QuestionNode noNode) {
        this.yesNode = yesNode;
        this.noNode = noNode;
        this.question = question;
        this.object = object;
    }

}
