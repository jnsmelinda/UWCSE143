import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(new File("sentence2.txt"));
        List<String> grammar = new ArrayList<>();
        while (input.hasNextLine()) {
            String next = input.nextLine().trim();
            if (next.length() > 0) {
                grammar.add(next);
            }
        }

        GrammarSolver solver = new GrammarSolver(Collections.unmodifiableList(grammar));
        System.out.println(solver);
        Arrays.stream(solver.generate("E", 10)).forEach(System.out::println);
    }
}
