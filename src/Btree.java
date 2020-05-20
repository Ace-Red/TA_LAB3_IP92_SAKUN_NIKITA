import java.io.Serializable;

public class Btree implements Serializable {
    public Node root;
    int t = 10;

    Btree() {

        root = new Node();

        root.isLeaf = true;
        root.numberOfNodes = 0;

        root.key[0].value = -1;
    }


    public void insert(int k) {

        Node r = root;
        if (r.numberOfNodes == (2 * t - 1)) {

            Node s = new Node();

            root = s;
            s.numberOfNodes = 0;

            s.isLeaf = false;
            s.children[0] = r;


            splitChild(s, 1, r);

            insertNonfull(s, k);
        } else {
            insertNonfull(r, k);
        }
    }


    public void insertNonfull(Node node, int value) {
        int i = node.numberOfNodes;

        if (node.isLeaf) {
            while (i >= 1 && value < node.key[i - 1].value) {
                node.key[i] = node.key[i - 1];
                i--;
            }
            node.key[i] = new Note(value);
            node.numberOfNodes++;
        } else {
            while (i >= 1 && value < node.key[i - 1].value) {
                i--;
            }
            i++;

            if (node.children[i - 1].numberOfNodes == (2 * t - 1)) {

                splitChild(node, i, node.children[i - 1]);

                if (value > node.key[i - 1].value) {
                    i++;
                }
            }

            insertNonfull(node.children[i - 1], value);
        }
    }

    public void splitChild(Node parentNode, int childIndex, Node newChild) {

        Node z = new Node();
        z.isLeaf = newChild.isLeaf;
        z.numberOfNodes = t - 1;
        for (int i = 0; i < t - 1; i++) {
            z.key[i] = newChild.key[i + t];
        }
        if (!newChild.isLeaf) {
            for (int i = 0; i < t; i++) {
                z.children[i] = newChild.children[i + t];
            }
        }
        newChild.numberOfNodes = (t - 1);


        for (int j = parentNode.numberOfNodes; j >= childIndex; j--) {
            parentNode.children[j + 1] = parentNode.children[j];
        }
        parentNode.children[childIndex] = z;

        for (int j = parentNode.numberOfNodes; j >= childIndex; j--) {
            parentNode.key[j + 1] = parentNode.key[j];
        }
        parentNode.key[childIndex - 1] = newChild.key[10];

        parentNode.numberOfNodes++;
    }


    public boolean search(Node node, int value) {

        int i = 1;
        while (i <= node.numberOfNodes && value > node.key[i - 1].value) {
            i++;
        }

        if (i <= node.numberOfNodes && value == node.key[i - 1].value) {

            return true;
        }

        if (!node.isLeaf) {

            return search(node.children[i - 1], value);
        }

        return false;
    }


    public boolean search(int k) {

        Node x = root;

        return search(x, k);
    }

    public boolean delete(int k) {
        Node x = root;
        return delete(x, k);
    }


    public boolean delete(Node node, int value) {

        int i = 1;


        while (i <= node.numberOfNodes && value > node.key[i - 1].value) {

            i++;
        }

        if (node.isLeaf) {

            if (i <= node.numberOfNodes && value == node.key[i - 1].value) {

                node.key[i - 1].value = 0;

                for (int j = i - 1; j < node.numberOfNodes - 1; j++) {
                    node.key[j] = node.key[j + 1];
                    if (j + 1 == node.numberOfNodes - 1)
                        node.numberOfNodes--;
                }
                return true;
            }
        } else {
            return delete(node.children[i - 1], value);
        }

        return false;
    }


    public void print() {
        printBtree(root, "");
    }


    public void printBtree(Node node, String indent) {
        if (node == null) {
            System.out.println(indent + "The B-Tree is Empty");
        } else {
            System.out.print(indent);


            for (int i = node.numberOfNodes - 1; i >= 0; i--) {
                if (!node.isLeaf) {
                    printBtree(node.children[i], indent);
                }

                if (node.key[i].value > 0)
                    System.out.println(indent + node.key[i]);
            }
            if (!node.isLeaf) {
                printBtree(node.children[node.numberOfNodes], indent);
            }
        }
    }
    public void redact(int key,int value2){

    }
    public String searchKey(int key){
        Node x = root;

        return searchKey2(x, key);
    }
    public String searchKey2(Node node, int value) {

        int i = 1;
        while (i <= node.numberOfNodes && value > node.key[i - 1].value) {
            i++;
        }

        if (i <= node.numberOfNodes && value == node.key[i - 1].value) {

            return (""+node.key[i - 1].value);
        }

        if (!node.isLeaf) {

            return searchKey2(node.children[i - 1], value);
        }

        return "Не найдено!";
    }

}
