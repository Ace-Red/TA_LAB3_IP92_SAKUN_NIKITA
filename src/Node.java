import java.io.Serializable;

public class Node implements Serializable {
    public int numberOfNodes;
    public int[] key;
    public Node[] children;
    public boolean isLeaf;

    Node() {
        key = new int[20];
        children = new Node[21];
        isLeaf = true;
    }
}
