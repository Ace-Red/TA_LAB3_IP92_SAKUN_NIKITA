public class Node {
    public int numberOfNodes;              // number of nodes

    public int key[];                      // the array that holds the keys value.

    public Node children[];                // the array that holds the references of the keys in the node.

    public boolean isLeaf;                   // the variable to deterime if the node is is Leaf or not.


    Node() {
        key = new int[20];             // The node can have at most 3 keys
        children = new Node[21];       // We have 4 references for each node
        isLeaf = true;                  // assign the node to be Leaf.
    }
}
