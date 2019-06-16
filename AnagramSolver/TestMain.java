import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TestMain {

    public static void main(String[] args) throws FileNotFoundException {

        Scanner input = new Scanner(new File("dict0.txt"));

        List<String> dictionary = new ArrayList<String>();
        while (input.hasNextLine()) {
            dictionary.add(input.nextLine());
        }

	    AnagramSolver solver = new AnagramSolver(dictionary);
        solver.print("georgebush", 0);
    }
}
