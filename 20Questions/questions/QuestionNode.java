package questions;

public class QuestionNode {
    public QuestionNode yesNode;
    public QuestionNode noNode;
    public String data;

    public QuestionNode(){

    }

    public QuestionNode(String data, QuestionNode yesNode, QuestionNode noNode) {
        this.yesNode = yesNode;
        this.noNode = noNode;
        this.data = data;
    }
}
