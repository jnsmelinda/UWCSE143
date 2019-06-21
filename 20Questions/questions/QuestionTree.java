package questions;

import java.io.PrintStream;
import java.util.Scanner;

public class QuestionTree {
    private QuestionNode root;
    private Scanner console;

    public QuestionTree(){
        root = new QuestionNode(null, "computer", null, null);
        console = new Scanner(System.in);
    }

    public void read(Scanner input) {
        while (input.hasNextLine()) {
            read(root);
        }
    }

    private void read(QuestionNode root) {

    }

    public void askQuestions() {
        root = askQuestions(root);
    }

    private QuestionNode askQuestions(QuestionNode subtree) {
        if (subtree.yesNode == null || subtree.noNode == null) {
            if (yesTo("Would your object happen to be a " + subtree.object + "?")) {
                System.out.println("Great, I got it right");
            }
            else {
                addNewQuestion(subtree);
            }
        }
        else {
            if (yesTo(subtree.question)) {
                askQuestions(subtree.yesNode);
            } else if (!yesTo(subtree.question)) {
                askQuestions(subtree.noNode);
            }
        }
        return subtree;
    }

    public void write(PrintStream printStream) {

    }

    private void addNewQuestion(QuestionNode subtree) {
        System.out.println("What is the name of your object?");
        String object = console.nextLine();
        System.out.println("Please give me a yes/no question that\ndistinguishes between your object\n" +
                "and mine--> ");
        String question = console.nextLine();
        if (yesTo("And what is the answer for your object?")) {
            subtree.yesNode = new QuestionNode(question, object, null, null);
        }
        else {
            subtree.noNode = new QuestionNode(question, object, null, null);
        }
    }

    public boolean yesTo(String prompt) {
        System.out.print(prompt + " (y/n)? ");
        String response = console.nextLine().trim().toLowerCase();
        while (!response.equals("y") && !response.equals("n")) {
            System.out.println("Please answer y or n.");
            System.out.print(prompt + " (y/n)? ");
            response = console.nextLine().trim().toLowerCase();
        }

        return response.equals("y");
    }
}
