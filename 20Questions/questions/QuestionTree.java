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
        askQuestions(root);
    }

    private void askQuestions(QuestionNode subtree) {
        if (subtree.yesNode == null || subtree.noNode == null) {
            if (yesTo("Would your object happen to be a " + subtree.data + "?")) {
                    System.out.println("Great, I got it right");
            }
            else {
                addNewQuestion(subtree);
            }
        }
        else {
            if (yesTo(subtree.data)) {
                askQuestions(subtree.yesNode);
            } else {
                askQuestions(subtree.noNode);
            }
        }
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

    private QuestionNode addNewQuestion(QuestionNode subtree) {
        System.out.println("What is the name of your object?");
        String object = console.nextLine();
        System.out.println("Please give me a yes/no question that\ndistinguishes between your object\n" +
                "and mine--> ");
        String question = console.nextLine();
        String peviousObject = subtree.data;
        if (yesTo("And what is the answer for your object?")) {
            subtree.noNode = new QuestionNode(object, null, null);
        }
        else {
            subtree.noNode = new QuestionNode(object, null, null);
        }
        subtree.data = question;

        return subtree;
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
