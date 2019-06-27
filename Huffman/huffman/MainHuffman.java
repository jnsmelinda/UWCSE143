package huffman;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class MainHuffman {
    public static void main(String[] args) throws IOException {
//        int CHAR_MAX = 256;
//        FileInputStream input = new FileInputStream("huffman/test.txt");
//        int[] count = new int[CHAR_MAX];
//        int n = input.read();
//        while (n != -1) {
//            count[n]++;
//            n = input.read();
//        }
//        HuffmanTree encodeTree = new HuffmanTree(count);
//        PrintStream output = new PrintStream(new File("huffman/test.code"));
//        encodeTree.write(output);

        Scanner codeInput = new Scanner(new File("huffman/test.code"));
        HuffmanTree decodeTree = new HuffmanTree(codeInput);


    }

}
