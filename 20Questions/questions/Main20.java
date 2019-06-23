package questions;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main20 {
    public static void main(String[] args) throws FileNotFoundException {
        QuestionTree tree = new QuestionTree();
        String file = "20Questions/question.txt";
        tree.read(new Scanner(new File(file)));
        tree.printPreorder();
        tree.write(System.out);
    }
}
