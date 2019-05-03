import java.util.*;

public class HangmanManager {

    private Set<Character> letters;
    private int guessCounter;

    private String pattern;
    private Set<String> words;

    public HangmanManager(Collection<String> dictionary, int length, int max) {
        letters = new TreeSet<>();

        if (length < 1) {
            throw new IllegalArgumentException("length of word is less than 1");
        }
        if (max < 0) {
            throw new IllegalArgumentException("max is less than 0");
        }

        pattern = initialPattern(length);
        words = new TreeSet<>(dictionary);
        guessCounter = max - letters.size();
    }

    public Set<String> words() {
        return words;
    }

    public int guessesLeft() {
        return guessCounter;
    }

    public Set<Character> guesses() {
        return letters;
    }

    public String pattern() {
        String word = "";
        for (int i = 0; i < pattern.length(); i++) {
            word += pattern.charAt(i) + " ";
        }
        return word.trim();
    }

    public int record(char guess) {
        Map<String, Set<String>> currentMap = new TreeMap<>();
        validate(guess);

        currentMap = makeGoups(guess, currentMap);

        getBiggestSet(currentMap);
        if (currentMap.keySet().size() > 1) {
            keepOnePair(currentMap);
        }

        pattern = currentMap.entrySet().iterator().next().getKey();
        words = currentMap.entrySet().iterator().next().getValue();

        int appearances = updateGame(guess);

        return appearances;
    }

    private int updateGame(char guess) {
        int appearances = appearances(guess);
        if (appearances == 0) {
            letters.add(guess);
            guessCounter--;
        }
        else {
            for (String element : words) {
                createPattern(element, guess);
            }
        }
        return appearances;
    }

    private void keepOnePair(Map<String, Set<String>> currentMap) {
        if (!currentMap.equals(currentMap.entrySet().iterator().next())) {
            Iterator<Map.Entry<String, Set<String>>> iterator = currentMap.entrySet().iterator();
            while (iterator.hasNext()) {
                if (!iterator.next().equals(currentMap.entrySet().iterator().next())) {
                    iterator.remove();
                }
            }
        }
    }

    private int appearances(char guess) {
        int counter = 0;
        for (int i = 0; i < pattern.length(); i++) {
            if (pattern.charAt(i) == guess) {
                counter++;
            }
        }

        return counter;
    }

    private void getBiggestSet(Map<String, Set<String>> currentMap) {
        Iterator<Map.Entry<String, Set<String>>> iterator = currentMap.entrySet().iterator();
        while (iterator.hasNext()) {
            if (iterator.next().getValue().size() != biggestSize(currentMap)) {
                iterator.remove();
            }
        }
    }

    private int biggestSize(Map<String, Set<String>> map) {
        int max = 0;
        for (String element : map.keySet()) {
            if (map.get(element).size() > max) {
                max = map.get(element).size();
            }
        }

        return max;
    }

    private Map<String, Set<String>> makeGoups(char guess, Map<String, Set<String>> newMap) {
        for (String element : words) {
            String currentPattern = createPattern(element, guess);
            if (!newMap.containsKey(currentPattern)) {
                newMap.put(currentPattern, new TreeSet<>());
            }
            newMap.get(currentPattern).add(element);
        }
        return newMap;
    }

    private String createPattern(String element, char guess) {
        StringBuilder string = new StringBuilder(pattern);
        for (int i = 0; i < pattern.length(); i++) {
            if (element.charAt(i) == guess) {
                string.setCharAt(i, guess);
            }
        }

        return string.toString();
    }

    private String initialPattern(int length) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append("-");
        }

        return sb.toString();
    }

    private void validate(char guess) {
        if (guessesLeft() < 1 || words.size() == 0) {
            throw new IllegalStateException("no guesses left or empty set of words / games should be over");
        }
        else if (letters.contains(guess)) {
            throw new IllegalArgumentException("letter was guessed before");
        }
    }
}
