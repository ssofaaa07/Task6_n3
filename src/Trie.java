import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Trie {

    int sizeOfAlphabet;
    ArrayList<Vertex> vertices;
    Vertex root;

    public Trie(int sizeOfAlphabet) {
        this.sizeOfAlphabet = sizeOfAlphabet;
        this.vertices = new ArrayList<>();
        vertices.add(new Vertex(sizeOfAlphabet, null, null));
        this.root = vertices.get(0);
    }

    public int size() {
        return vertices.size();
    }

    public Vertex last() {
        return vertices.get(vertices.size() - 1);
    }

    private int charToIndex(char c) {
        return c - 'a';
    }

    public void add(String s) {
        Vertex v = root;
        for (int i = 0; i < s.length(); i++) {
            if (v.next[charToIndex(s.charAt(i))] == null) {
                vertices.add(new Vertex(sizeOfAlphabet, v, s.charAt(i)));
                v.next[charToIndex(s.charAt(i))] = this.last();
            }
            v = v.next[charToIndex(s.charAt(i))];
        }
        v.isTerminal = true;
    }

    public boolean find(String s) {
        Vertex v = root;
        for (int i = 0; i < s.length(); i++) {
            if (v.next[charToIndex(s.charAt(i))] == null) {
                return false;
            }
            v = v.next[charToIndex(s.charAt(i))];
        }
        return v.isTerminal;
    }
}