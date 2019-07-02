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
        root = new HuffmanNode();
        while (input.hasNextLine()) {
            HuffmanNode current = root;
            int letter = Integer.parseInt(input.nextLine());
            String code = input.nextLine();
            for (int i = 0; i < code.length(); i++) {
                if (code.charAt(i) == '0') {
                    if (current.node0 == null) {
                        current.node0 = new HuffmanNode();
                        if (i == code.length() - 1) {
                            current.node0.letter = letter;
                        }
                    }
                    current = current.node0;
                }
                else {
                    if (current.node1 == null) {
                        current.node1 = new HuffmanNode();
                        if (i == code.length() - 1) {
                            current.node1.letter = letter;
                        }
                    }
                    current = current.node1;
                }
            }
        }
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

    public void decode(BitInputStream input, PrintStream output, int eof) {
        HuffmanNode current = root;
        int bit = input.readBit();
        while (bit != -1) {
            if (bit == 0) {
                current = current.node0;
            }
            else {
                current = current.node1;
            }
            if (current.node0 == null && current.node1 == null) {
                if (current.letter != eof) {
                    output.write(current.letter);
                    current = root;
                }
                else {
                    break;
                }
            }

            bit = input.readBit();
        }
    }

    public void printPreorder() {
        System.out.print("preorder:");
        printPreorder(root);
    }

    private void printPreorder(HuffmanNode root) {
        if (root != null) {
            System.out.print(" " + root.letter);
            printPreorder(root.node0);
            printPreorder(root.node1);
        }
    }
}
