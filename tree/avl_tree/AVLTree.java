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
    
    /* Retorna a altura da árvore. */
    int height(Node n) {
        return (n == null) ? 0 : n.height;
    }
    
    /* "(a > b)" é um boolean. "?" verifica o valor desse boolean,
    e retorna "a" caso verdadeiro, e "b" caso falso. */
    int max(int a, int b) {
        return (a > b) ? a : b; 
    }

    void updateHeight(Node n) {
        n.height = 1 + max(height(n.left), height(n.right));
    }

    int getBalance(Node n) {
        return (n == null) ? 0 : height(n.right) - height(n.left);
    }

    Node findMin(Node n) {
        while (n.left != null) {
            n = n.left;
        }
        return n;
    }

    // https://www.baeldung.com/java-avl-trees
    Node rightRotate(Node y) {
        Node x = y.left;
        Node z = x.right; 

        x.right = y;
        y.left = z;

        updateHeight(y);
        updateHeight(x);
        
        return x;
    }
    
    Node leftRotate(Node x) {
        Node y = x.right;
        Node z = y.left; 

        y.left = x;
        x.right = z;

        updateHeight(y);
        updateHeight(x);
        
        return y;
    }

    // Tendo como base subárvore esquerda - subárvore direita.
    Node rebalance(Node z) {
        updateHeight(z);
        int balance = getBalance(z);

        if (balance > 1) {
            if (height(z.right.right) > height(z.right.left)) {
                z = leftRotate(z);
            } else {
                z.right = rightRotate(z.right);
                z = leftRotate(z);
            }
        } else if (balance < -1) {
            if (height(z.left.left) > height(z.left.right)) 
                z = rightRotate(z);
            else {
                z.left = leftRotate(z.left);
                z = rightRotate(z);
            }
        }
        return z;
    }

    Node insert(Node current, int key) {
        if (current == null) {
            return new Node(key);
        } else if (current.key > key) {
            current.left = insert(current.left, key);
        } else if (current.key < key) {
            current.right = insert(current.right, key);
        } else {
            throw new RuntimeException("Duplicate Key!");
        }
        return rebalance(current);
    }

    Node remove(Node current, int key) {
        if (current == null) {
            return current;
        }
        
        if (key < current.key) {
            current.left = remove(current.left, key);
        }

        else if (key > current.key) {
            current.right = remove(current.right, key);
        }
        
        else {
            // Caso 1: Nó sem filhos (nó folha).
            if (current.left == null && current.right == null) {
                current = null;
            }
            // Caso 2: Nó tem um único filho.
            else if (current.right == null) {
                current = current.left;
            } 
            else if (current.left == null) {
                current = current.right;
            }
            // Caso 3: Nó com dois filhos.
            else {
                Node temp = findMin(current.right);
                current.key = temp.key;
                current.right = remove(current.right, temp.key);
            }
        }

        if (current == null) {
            return null;
        }

        return rebalance(current);
    }

    void preOrder(Node node) {
        if (node != null) {
            System.out.print(node.key + " ");
            preOrder(node.left);
            preOrder(node.right);
        }
    }
    
}
