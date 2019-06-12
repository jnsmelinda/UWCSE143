import java.util.*;

public class AnagramSolver {
    private List<String> dictionary;

    public AnagramSolver(List<String> list) {
        this.dictionary = list;
    }

    public void print(String s, int max) {
        print(new LetterInventory(s), max, new ArrayList(), s, reduceDictionary(s));
    }

    private void print(LetterInventory inventory, int max, List<String> anagram, String s, List<String> dictionary) {
        if (max == 0 && inventory.isEmpty()) {
            printAnagram(anagram, s);
        }
        else if (anagram.size() <= max && inventory.isEmpty()) {
            printAnagram(anagram, s);
        }
        else {
            for (String word : dictionary) {
                LetterInventory result = inventory.subtract(new LetterInventory(word));
                if (result != null) {
                    anagram.add(word);
                    print(result, max, anagram, s, dictionary);
                    anagram.remove(word);
                }
            }
        }
    }

    private List reduceDictionary(String s) {
        List newDictionary = new ArrayList();
        for (String element : this.dictionary) {
            LetterInventory result = new LetterInventory(s).subtract(new LetterInventory(element));
            if (result != null) {
                newDictionary.add(element);
            }
        }

        return newDictionary;
    }

    private void printAnagram(List<String> anagram, String s) {
//        int counter = 0;
//        for (String st : anagram) {
//            counter += st.length();
//            if (counter == new LetterInventory(s).size()) {
//                System.out.println(anagram);
//            }
//        }

        if (new LetterInventory(s).size() == anagram.stream().mapToInt(String::length).sum()) {
            System.out.println(anagram);
        }
    }

}
