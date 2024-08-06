package tree.binary_tree;

class Node {
    int value;
    Node filhoEsquerda;
    Node filhoDireita;

    public Node(int v) {
        this.value = v;
        this.filhoDireita = null;
        this.filhoEsquerda = null;
    }
}

public class BinaryTree {
    Node raiz;

    public BinaryTree() {
        this.raiz = null;
    } 

    void adicionar(int v) {
        raiz = adicionarRecursivo(raiz, v);
    }

    private Node adicionarRecursivo(Node current, int v) {
        // Chamadas recursivas. A função chama ela mesma até que respeite uma das condições.
        if (current == null) {
            return new Node(v); // A adição do novo nó sempre acontece aqui, quando o valor atual está vazio.
        }

        if (v < current.value) { // Percorre a árvore, decidindo entre o caminho da esquerda ou direita.
            current.filhoEsquerda = adicionarRecursivo(current.filhoEsquerda, v);
        } else if (v > current.value) {
            current.filhoDireita = adicionarRecursivo(current.filhoDireita, v);
        } else {
            return current; // Caso valor já exista.
        }
        return current;
    }

    void removerPrimeiro() {
        
    }

    void removerUltimo() {
        raiz = null;
    }

    void atravessaEmOrdem(Node node) {
        // Chamadas recursivas novamente. Percorre a árvore para exibir os valores nos nós.
        if (node != null) {
            atravessaEmOrdem(node.filhoEsquerda);
            System.out.println(" " + node.value);
            atravessaEmOrdem(node.filhoDireita);
        }
    }

}