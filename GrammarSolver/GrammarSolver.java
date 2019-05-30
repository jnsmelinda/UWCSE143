import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class GrammarSolver {
    private static final Random RND = new Random();
    private SortedMap<String, List<String>> ruleMap = new TreeMap<>();

    public GrammarSolver(List<String> grammar) {
        if (grammar.isEmpty()) {
            throw new IllegalArgumentException("Empty grammar!");
        }

        for (String line : grammar) {
            String[] split = line.split("::=");
            String key = split[0];

            List<String> rules = Arrays.stream(split[1].split("[|]"))
                    .map(s -> s.replaceAll("\\s+"," "))
                    .map(String::trim)
                    .collect(Collectors.toList());

            if (ruleMap.containsKey(key)) {
                throw new IllegalArgumentException("There are two or more entries in the grammar for the same non-terminal");
            }

            ruleMap.put(key, rules);
        }
    }

    public boolean grammarContains(String symbol) {
        return ruleMap.containsKey(symbol);
    }

    public String getSymbols() {
        return ruleMap.keySet().toString();
    }

    public String[] generate(String symbol, int n) {
        validate(symbol, n);
        String[] result = new String[n];
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            eval(symbol, sb);
            result[i] = sb.toString();
        }

        return result;
    }

    private void eval(String symbol, StringBuilder sb) {
        String rule = getRandomRule(symbol);
        for (String token : rule.split(" ")) {
            if (!grammarContains(token)) {
                append(token, sb);
            }
            else {
                eval(token, sb);
            }
        }
    }

    private void append(String terminal, StringBuilder sb) {
        if (sb.length() != 0) {
            sb.append(" ");
        }
        sb.append(terminal);
    }

    private String getRandomRule(String symbol) {
        List<String> rules = ruleMap.get(symbol);
        return rules.get(RND.nextInt(rules.size()));
    }

    private void validate(String symbol, int n) {
        if (!grammarContains(symbol)) {
            throw new IllegalArgumentException("Invalid symbol: " + symbol);
        }
        if (n <= 0) {
            throw new IllegalArgumentException("Invalid number (must be greater than 0)");
        }
    }

    @Override
    public String toString() {
        return ruleMap.toString();
    }
}
