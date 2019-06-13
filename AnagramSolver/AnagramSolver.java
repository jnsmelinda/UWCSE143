import java.util.*;

import static java.util.stream.Collectors.toMap;

public class AnagramSolver {
    private Map<String, LetterInventory> dictionary;

    public AnagramSolver(List<String> list) {
//        this.dictionary = new HashMap<>();
//        for (String word : list) {
//            dictionary.put(word, new LetterInventory(word));
//        }

        this.dictionary = list.stream().collect(toMap(word -> word, LetterInventory::new));
    }

    public void print(String s, int max) {
        LetterInventory inventory = new LetterInventory(s);
        print(inventory, max, new ArrayList<>(), inventory.size(), reduceDictionary(inventory));
    }

    private void print(LetterInventory current, int max, List<String> anagram, int inventorySize, Map<String, LetterInventory> dictionary) {
        if (max == 0 && current.isEmpty()) {
            printAnagram(anagram, inventorySize);
        }
        else if (anagram.size() <= max && current.isEmpty()) {
            printAnagram(anagram, inventorySize);
        }
        else {
            for (Map.Entry<String, LetterInventory> entry : dictionary.entrySet()) {
                LetterInventory result = current.subtract(entry.getValue());
                if (result != null) {
                    anagram.add(entry.getKey());
                    print(result, max, anagram, inventorySize, dictionary);
                    anagram.remove(entry.getKey());
                }
            }
        }
    }

    private Map<String, LetterInventory> reduceDictionary(LetterInventory inventory) {
//        Map<String, LetterInventory> reducedDictionary = new HashMap<>();
//        for (Map.Entry<String, LetterInventory> entry : this.dictionary.entrySet()) {
//            LetterInventory result = inventory.subtract(entry.getValue());
//            if (result != null) {
//                reducedDictionary.put(entry.getKey(), entry.getValue());
//            }
//        }
//
//        return reducedDictionary;

        return dictionary.entrySet().stream()
                .filter(entry -> inventory.subtract(entry.getValue()) != null)
                .collect(toMap(Map.Entry::getKey, Map.Entry::getValue));

    }

    private void printAnagram(List<String> anagram, int inventorySize) {
//        int counter = 0;
//        for (String st : anagram) {
//            counter += st.length();
//            if (counter == inventory.size()) {
//                System.out.println(anagram);
//            }
//        }

        if (inventorySize == anagram.stream().mapToInt(String::length).sum()) {
            System.out.println(anagram);
        }
    }

}
