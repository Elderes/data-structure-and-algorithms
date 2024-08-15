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
        if (current == null) {
            return new Node(v); // A adição do novo nó acontece aqui quando o valor atual está vazio.
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

    boolean verificarExistencia(Node current, int v) {
        if (current == null) {
            return false;
        }
        if (current.value == v) {
            return true;
        }
        if (v > current.value) {
            return verificarExistencia(current.filhoDireita, v); // A função é chamada novamente até que caia em uma das duas primeiras condições.
        } else {
            return verificarExistencia(current.filhoEsquerda, v);
        }
    } 

    void removerMaior() {
        raiz = removerMaiorRecursivo(raiz); // Atribui a raíz (que passará a ser o nó atual) pelo valor retornado da função, que recebe a própria raíz como argumento na chamada.
    }

    private Node removerMaiorRecursivo(Node current) {
        if (current == null) {
            return null;
        }

        if (current.filhoDireita == null) {
            return current.filhoEsquerda;
        }

        current.filhoDireita = removerMaiorRecursivo(current.filhoDireita);
        
        return current;
    }

    void removerMenor() {
        raiz = removerMenorRecursivo(raiz);
    }

    private Node removerMenorRecursivo(Node current) {
        if (current == null) {
            return null;
        }

        if (current.filhoEsquerda == null) {
            return current.filhoDireita;
        }

        current.filhoEsquerda = removerMenorRecursivo(current.filhoEsquerda); 
        
        return current;
    }

    void atravessaEmOrdem(Node node) {
        if (node != null) {
            atravessaEmOrdem(node.filhoEsquerda);
            System.out.println(" " + node.value);
            atravessaEmOrdem(node.filhoDireita);
        }
    }

    void atravessarEmPreOrder(Node node) {
        if (node != null) {
            System.out.println(" " + node.value);
            atravessarEmPreOrder(node.filhoEsquerda);
            atravessarEmPreOrder(node.filhoDireita);
        }
    }
    
    void atravessarEmPosOrder(Node node) {
        if (node != null) {
            atravessarEmPosOrder(node.filhoEsquerda);
            atravessarEmPosOrder(node.filhoDireita);
            System.out.println(" " + node.value);
        }
    } 

}
