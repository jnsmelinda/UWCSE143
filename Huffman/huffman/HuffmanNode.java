package huffman;

public class HuffmanNode implements Comparable<HuffmanNode> {

    public int frequency;
    public int letter;
    public HuffmanNode node1;
    public HuffmanNode node0;

    public HuffmanNode() {}

    public HuffmanNode(int frequency, int letter, HuffmanNode node0, HuffmanNode node1) {
        this.letter = letter;
        this.frequency = frequency;
        this.node0 = node0;
        this.node1 = node1;
    }

    @Override
    public int compareTo(HuffmanNode other) {
        return this.frequency - other.frequency;
    }

    @Override
    public String toString() {
        return "\nHuffmanNode{" +
                "  \nfrequency=" + frequency +
                ", \nletter=" + letter +
                ", \nnode1=" + node1 +
                ", \nnode0=" + node0 +
                '}';
    }
}
