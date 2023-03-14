import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void solution(int sizeOfAlphabet, String words, String text) {
        Trie trie = createTrie(sizeOfAlphabet, words);

        AlgorithmOfAhoCorasick alg = new AlgorithmOfAhoCorasick(trie);

        Vertex v = trie.root;

        System.out.println("Позиции конца найденных подстрок в тексте:");

        for (int i = 0; i < text.length(); i++) {
            v = alg.go(v, text.charAt(i));
            if (v.isTerminal) {
                System.out.println(i);
            }
        }
    }
    public static Trie createTrie(int sizeOfAlphabet, String words){
        ArrayList<String> listOfWords = new ArrayList<>();

        System.out.println("Полученные слова:");
        int k = 0;
        for (int i = 0; i < words.length() - 1; i++) {
            if (words.charAt(i) == ' ') {
                System.out.println(words.substring(k, i));
                listOfWords.add(words.substring(k, i));
                k = i + 1;
            }
        }
        System.out.println(words.substring(k));
        System.out.println();
        listOfWords.add(words.substring(k));

        Trie trie = new Trie(sizeOfAlphabet);

        for (String s : listOfWords) {
            trie.add(s);
        }

        return trie;
    }

    public static void start(){
        Scanner scan = new Scanner(System.in);

        System.out.println("Введите через пробел несколько строк для дальнейшего поиска:");

        String words = scan.nextLine();

        System.out.println("Введите размер алфавита:");

        int sizeOfAlphabet = scan.nextInt();

        System.out.println("Введите текст:");

        String text = scan.next();

        System.out.println();

        solution(sizeOfAlphabet, words, text);
    }
    public static void main(String[] args) {
        start();
    }

    public static void mainExample(String[] args) {
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

        AlgorithmOfAhoCorasick alg = new AlgorithmOfAhoCorasick(trie);

        String text = "doherscoenkhedo";
        Vertex v = trie.root;

        for (int i = 0; i < text.length(); i++) {
            v = alg.go(v, text.charAt(i));
            if (v.isTerminal) {
                System.out.println(i);
            }
        }
    }
}