package tree.binary_tree;

public class Main {
    public static void main(String[] args) {
        BinaryTree arvore = new BinaryTree();

        arvore.adicionar(9);
        arvore.adicionar(6);
        arvore.adicionar(4);
        arvore.adicionar(8);
        arvore.adicionar(3);
        arvore.adicionar(5);
        arvore.adicionar(7);

        arvore.atravessaEmOrdem(arvore.raiz);
    }
}