package huffman;

import java.io.PrintStream;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

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
        queue.add(new HuffmanNode(1, count.length, null, null));

        while (queue.size() != 1) {
            HuffmanNode first = queue.remove();
            HuffmanNode second = queue.remove();
            queue.add(new HuffmanNode(first.frequency + second.frequency, 0, first, second));
        }

        root = queue.remove();

//        for (HuffmanNode node = queue.poll(); node != null; node = queue.poll()) {
//         System.out.println(node);
//        }
    }

    public HuffmanTree(Scanner input) {
        HuffmanNode parent = new HuffmanNode(0, 0, new HuffmanNode(), new HuffmanNode());

        while (input.hasNextLine()){
            int n = Integer.parseInt(input.nextLine());
            String code = input.nextLine();
            for (int i = 0; i < code.length(); i++) {
                if (code.charAt(i) == 0) {
                    parent.node0 = new HuffmanNode(0, 0, new HuffmanNode(), null);
                    if (i == code.length() - 1) {
                        parent.node0.letter = n;
                    }
                    parent = parent.node0;
                }
                else {
                    parent.node1 = new HuffmanNode(0, 0, null, new HuffmanNode());
                    if (i == code.length() - 1) {
                        parent.node1.letter = n;
                    }
                    parent = parent.node1;
                }
            }
        }
        System.out.println(parent);

    }

    public void write(PrintStream output) {
        write(root, "", output);
    }

    private void write(HuffmanNode node, String code, PrintStream output) {
        if (node.node0 == null || node.node1 == null) {
            output.println(node.letter);
            output.println(code);
        }
        else {
            write(node.node0, code + "0", output);
            write(node.node1, code + "1", output);
        }
    }

    public void decode(BitInputStream input, PrintStream output, int charMax) {

    }
}
