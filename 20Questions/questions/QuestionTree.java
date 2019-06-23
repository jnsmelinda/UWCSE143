package questions;

import java.io.PrintStream;
import java.util.Scanner;

public class QuestionTree {
    private QuestionNode root;
    private Scanner console;

    public QuestionTree(){
        root = new QuestionNode("computer", null, null);
        console = new Scanner(System.in);
    }

    public void read(Scanner input) {
        root = new QuestionNode();
        read(root, input);
    }

    private void read(QuestionNode node, Scanner input) {
        if (input.hasNextLine()) {
            if (input.nextLine().startsWith("Q:")) {
                node.data = input.nextLine();
                node.yesNode = new QuestionNode();
                node.noNode = new QuestionNode();
                read(node.yesNode, input);
                read(node.noNode, input);
            }
            else {
                node.data = input.nextLine();
            }
        }
    }

    public void askQuestions() {
        askQuestions(root, null);
    }

    private void askQuestions(QuestionNode node, QuestionNode parent) {
        if (node.yesNode == null || node.noNode == null) {
            if (yesTo("Would your object happen to be a " + node.data + "?")) {
                    System.out.println("Great, I got it right");
            }
            else {
                addNewQuestion(node, parent);
            }
        }
        else {
            if (yesTo(node.data)) {
                askQuestions(node.yesNode, node);
            } else {
                askQuestions(node.noNode, node);
            }
        }
    }

    private void addNewQuestion(QuestionNode node, QuestionNode parent) {
        System.out.println("What is the name of your object?");
        QuestionNode answer = new QuestionNode(console.nextLine(), null, null);
        System.out.println("Please give me a yes/no question that distinguishes between your object and mine:");
        QuestionNode question = new QuestionNode(console.nextLine(), null, null);

        if (yesTo("And what is the answer for your question?")) {
            question.yesNode = answer;
            question.noNode = node;
        }
        else {
            question.yesNode = node;
            question.noNode = answer;
        }

        if (parent == null) {
            root = question;
        }
        else {
            if (parent.yesNode == node) {
                parent.yesNode = question;
            } else {
                parent.noNode = question;
            }
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

    public void write(PrintStream printStream) {
        write(printStream, root);
    }

    public void write(PrintStream printStream, QuestionNode subtree) {
        if (subtree.yesNode == null || subtree.noNode == null) {
            printStream.println("A:");
            printStream.println(subtree.data);
        }
        else {
            printStream.println("Q:");
            printStream.println(subtree.data);
            write(printStream, subtree.yesNode);
            write(printStream, subtree.noNode);
        }
    }

    public void printPreorder() {
        System.out.print("preorder:");
        printPreorder(root);
        System.out.println();
    }

    // post: prints in preorder the tree with given root
    private void printPreorder(QuestionNode subtree) {
        if (subtree != null) {
            System.out.print(" " + subtree.data);
            printPreorder(subtree.yesNode);
            printPreorder(subtree.noNode);
        }
    }
}
