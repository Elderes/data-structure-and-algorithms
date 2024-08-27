package tree.avl_tree;

public class Main {
    public static void main(String[] args) {
        AVLTree tree = new AVLTree();

        tree.root = tree.insert(tree.root, 15);
        tree.root = tree.insert(tree.root, 10);
        tree.root = tree.insert(tree.root, 12);
        tree.root = tree.insert(tree.root, 2);
        tree.root = tree.insert(tree.root, 17);
        tree.root = tree.insert(tree.root, 6);
        tree.root = tree.insert(tree.root, 8);

        tree.preOrder(tree.root);
    }
}
