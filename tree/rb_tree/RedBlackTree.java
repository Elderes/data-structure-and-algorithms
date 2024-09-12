class Node {
    int key;
    Node parent, left, right;
    boolean isRed;

    Node(int newKey) {
        this.key = newKey;
        this.isRed = true;
        this.parent = null;
        this.left = null;
        this.right = null;
    }
}

public class RedBlackTree {
    private Node root;
    private Node TNULL;

    public RedBlackTree() {
        TNULL = new Node(0);
        TNULL.isRed = false;
        root = TNULL;
    }

    private void leftRotate(Node x) {
        Node y = x.right;
        x.right = y.left;
    }
}
