package huffman;

import java.io.PrintStream;
import java.util.PriorityQueue;
import java.util.Queue;

public class HuffmanTree {

    private Queue<HuffmanNode> queue;
    private HuffmanNode root;

    public HuffmanTree(int[] count) {
        queue = new PriorityQueue();

        for (int i = 0; i < count.length; i++) {
            System.out.println(count[i]);
            queue.add(new HuffmanNode(count[i], null, null));
        }

//        for (HuffmanNode node = queue.poll(); node != null; node = queue.poll()) {
//            System.out.println(node);
//        }
    }

    public void write(PrintStream output) {
    }
}
