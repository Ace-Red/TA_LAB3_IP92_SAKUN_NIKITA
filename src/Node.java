import java.io.Serializable;

public class Node implements Serializable {
    public int numberOfNodes;
    public Note[] key;
    public Node[] children;
    public boolean isLeaf;

    Node() {
        key = new Note[20];
        children = new Node[21];
        isLeaf = true;
    }
}
