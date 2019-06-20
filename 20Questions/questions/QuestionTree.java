package questions;

import java.io.PrintStream;
import java.util.Scanner;

public class QuestionTree {
    private QuestionNode root;
    private Scanner console;

    public QuestionTree(){
        root = new QuestionNode("computer", null, null, null);
    }

    public void read(Scanner scanner) {
    }

    public void askQuestions() {
    }

    public void write(PrintStream printStream) {

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

    private void printPreorder(QuestionNode root) {
        if (root != null) {
            System.out.print(" " + root.text);
            printPreorder(root.yesNode);
            printPreorder(root.noNode);
        }
    }
}
