package questions;

public class QuestionNode {
    public QuestionNode yesNode, noNode, question;
    public String text;

    public QuestionNode(String text) {
        this(text, null, null, null);
    }

    public QuestionNode(String text, QuestionNode yesNode, QuestionNode noNode, QuestionNode question) {
        this.text = text;
        this.yesNode = yesNode;
        this.noNode = noNode;
        this.question = question;
    }

}
