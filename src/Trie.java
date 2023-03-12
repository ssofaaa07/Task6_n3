import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Trie {

    private int sizeOfAlphabet;
    private ArrayList<Vertex> vertices;
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

    public int charToIndex(char c) {
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
//
//    public Vertex getLink(Vertex v) {
//        if (v.suffixLink == null) {
//            if (v == root || v.parent == root) {
//                v.suffixLink = root;
//            } else {
//                v.suffixLink = this.go(this.getLink(v.parent), v.charOfParent);
//            }
//        }
//        return v.suffixLink;
//    }
//
//    public Vertex go(Vertex v, char c) {
//        if (v.go[charToIndex(c)] == null) {
//            if (v.next[charToIndex(c)] != null) {
//                v.go[charToIndex(c)] = v.next[charToIndex(c)];
//            } else if (v == root) {
//                v.go[charToIndex(c)] = root;
//            } else {
//                v.go[charToIndex(c)] = this.go(getLink(v), c);
//            }
//        }
//        return v.go[charToIndex(c)];
//    }

    public static void main(String[] args) {

    }

}
