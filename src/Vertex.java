import java.util.Arrays;

public class Vertex {
    Vertex[] next;
    boolean isTerminal;
    Vertex parent;
    Character charOfParent;
    Vertex suffixLink;
    Vertex[] go;

    public Vertex(int sizeOfAlphabet, Vertex parent, Character charOfParent) {
        this.next = arrayAlphabet(sizeOfAlphabet);
        this.go = arrayAlphabet(sizeOfAlphabet);
        this.parent = parent;
        this.charOfParent = charOfParent;
    }

    private Vertex[] arrayAlphabet(int size) {
        Vertex[] arr = new Vertex[size];
        Arrays.fill(arr, null);
        return arr;
    }
}
