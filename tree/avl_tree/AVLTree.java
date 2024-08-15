package tree.avl_tree;

class Node {
    int key, height;
    Node left, right;

    Node(int d) {
        key = d;
        height = 1;
    }
}

public class AVLTree {
    Node root;

    // Retorna a altura da árvore.
    int height(Node n) {
        if (n == null)
            return 0;
        return n.height;
    }
}
