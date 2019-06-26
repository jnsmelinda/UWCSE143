package huffman;

public class HuffmanNode implements Comparable<HuffmanNode> {

    public int frequency;
    public HuffmanNode node1;
    public HuffmanNode node0;

    public HuffmanNode() {}

    public HuffmanNode(int frequency, HuffmanNode node1, HuffmanNode node0) {
        this.frequency = frequency;
        this.node1 = node1;
        this.node0 = node0;
    }

    @Override
    public int compareTo(HuffmanNode other) {
        return this.frequency - other.frequency;
    }

    @Override
    public String toString() {
        return "HuffmanNode{" +
                "frequency=" + frequency +
                ", node1=" + node1 +
                ", node0=" + node0 +
                '}';
    }
}
