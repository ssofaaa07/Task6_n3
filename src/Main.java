import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
         List list = Arrays.asList("he", "she", "his", "hers");
        int sizeOfAlphabet = 26;

        Trie trie = new Trie(sizeOfAlphabet);

        for (Object s : list) {
            trie.add((String) s);
        }
        System.out.println(trie.size());
        for (Object s : list) {
            System.out.println(trie.find((String) s));
        }
        System.out.println(trie.find("hi"));

        AlgoritmOfAhoCorasick alg = new AlgoritmOfAhoCorasick(trie);

        String text = "odfhdosheheghiswphegkdfkjshfks";
        Vertex v = trie.root;

        for (int i = 0; i < text.length(); i++) {
            v = alg.go(v, text.charAt(i));
            if (v.isTerminal) {
                System.out.println(i);
                System.out.println(text.substring(i-3, i+1));
            }
        }
    }
}