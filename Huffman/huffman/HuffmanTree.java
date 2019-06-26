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
            if (count[i] > 0) {
                queue.add(new HuffmanNode(count[i], i, null, null));
            }
        }

        while (queue.size() != 1) {
            HuffmanNode first = queue.remove();
            HuffmanNode second = queue.remove();
            HuffmanNode subtree = new HuffmanNode(first.frequency + second.frequency, 0, first, second);
            queue.add(subtree);
        }

        root = queue.remove();

//        for (HuffmanNode node = queue.poll(); node != null; node = queue.poll()) {
//         System.out.println(node);
//        }
    }

    public void write(PrintStream output) {
        printPreorder(root, "", output);
    }

    private void printPreorder(HuffmanNode node, String code, PrintStream output) {
        if (node.node0 == null || node.node1 == null) {
            output.println(node.letter);
            output.println(code);
        }
        else {
            printPreorder(node.node0, code + "0", output);
            printPreorder(node.node1, code + "1", output);
        }
    }


}
