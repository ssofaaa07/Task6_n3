public class AlgorithmOfAhoCorasick {

    public Trie trie;

    public AlgorithmOfAhoCorasick(Trie trie) {
        this.trie = trie;
    }

    public void setTrie(Trie trie) {
        this.trie = trie;
    }

    private int charToIndex(char c) {
        return c - 'a';
    }

    public Vertex getLink(Vertex v) {
        if (v.suffixLink == null) {
            if (v == trie.root || v.parent == trie.root) {
                v.suffixLink = trie.root;
            } else {
                v.suffixLink = this.go(this.getLink(v.parent), v.charOfParent);
            }
        }
        return v.suffixLink;
    }

    public Vertex go(Vertex v, char c) {
        if (v.go[charToIndex(c)] == null) {
            if (v.next[charToIndex(c)] != null) {
                v.go[charToIndex(c)] = v.next[charToIndex(c)];
            } else if (v == trie.root) {
                v.go[charToIndex(c)] = trie.root;
            } else {
                v.go[charToIndex(c)] = this.go(getLink(v), c);
            }
        }
        return v.go[charToIndex(c)];
    }
}
