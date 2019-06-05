import java.util.*;

public class AnagramSolver {
    private List<String> dictionary;

    public AnagramSolver(List<String> list) {
        this.dictionary = new ArrayList<>();
        dictionary.addAll(list);
    }

    public void print(String s, int max) {
        Map map = new HashMap<String, Set<String>>();
        reduceDictionary(s, map);
        System.out.println(map);
    }

    private boolean contains(LetterInventory word, LetterInventory other) {
        return (word.subtract(other) != null);
    }

    private void reduceDictionary(String s, Map<String, Set<String>> map) {
        LetterInventory word = new LetterInventory(s);
        for(String str : dictionary) {
            if (contains(word, new LetterInventory(str))) {
                addToMap(s, map, str);
            }
        }
    }

    private void addToMap(String s, Map<String, Set<String>> map, String str) {
        if (!(map.containsKey(s))) {
            Set<String> value = new TreeSet<>();
            value.add(str);
            map.put(s, value);
        }
        map.get(s).add(str);
    }
}
