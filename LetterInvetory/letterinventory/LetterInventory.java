package letterinventory;

public class LetterInventory {

    private final int[] COUNTER = new int[26];
    private int size;

    public LetterInventory(String word) {
        word = word.toLowerCase();
        for (int i = 0; i < word.length(); i++) {
            if ((word.charAt(i) >= 'a' && word.charAt(i) <= 'z')){
                COUNTER[getIndex(word.charAt(i))]++;
                size++;
            }
        }
    }

    public int get(char letter){
        return COUNTER[getIndex(letter)];
    }

    public void set(char letter, int value) throws IllegalArgumentException{
        if (value < 0) {
            throw new IllegalArgumentException("value < 0");
        }
        if (getIndex(letter) > 26 || getIndex(letter) < 0){
            throw new IllegalArgumentException("non-alphabetic character");
        }

        getNewSize(letter, value);
        COUNTER[getIndex(letter)] = value;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("[");

        for (int i = 0; i < COUNTER.length; i++) {
            if (COUNTER[i] > 0) {
                for (int j = 0; j < COUNTER[i]; j++){
                    sb.append((char) ((char)i + 'a'));
                }
            }
        }
        sb.append("]");

        return sb.toString();
    }

    public LetterInventory add(LetterInventory other){
        LetterInventory result = new LetterInventory("");
        for (int i = 0; i < other.COUNTER.length; i++) {
            if (other.COUNTER[i] > 0 || this.COUNTER[i] > 0){
                result.COUNTER[i] = (other.COUNTER[i] + this.COUNTER[i]);
            }
        }
        result.size = this.size + other.size;

        return result;
    }

    public LetterInventory subtract(LetterInventory other){
        LetterInventory result = new LetterInventory("");
        for (int i = 0; i < other.COUNTER.length; i++){
            if (this.COUNTER[i] >= other.COUNTER[i]){
                result.COUNTER[i] = this.COUNTER[i] - other.COUNTER[i];
            }
            else {
                return null;
            }
        }
        result.size = this.size - other.size;

        return result;
    }

    private int getIndex(char letter){
        return Character.getNumericValue(letter) - 10;
    }

    private void getNewSize(char letter, int value) {
        size = (size - get(letter)) + value;
    }
}
