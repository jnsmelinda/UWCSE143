package huffman;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintStream;

public class MainHuffman {
    public static void main(String[] args) throws IOException {

        int CHAR_MAX = 256;

        FileInputStream input = new FileInputStream("huffman/hamlet.txt");
        int[] count = new int[CHAR_MAX];
        int n = input.read();
        while (n != -1) {
            count[n]++;
            n = input.read();
        }
        HuffmanTree ht = new HuffmanTree(count);
        PrintStream output = new PrintStream(new File("huffman/hamlet.code"));
        ht.write(output);

    }

}
