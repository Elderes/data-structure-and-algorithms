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
        System.out.println();
        arvore.atravessarEmPosOrder(arvore.raiz);
        System.out.println();
        arvore.atravessarEmPreOrder(arvore.raiz);
        System.out.println();

        System.out.println(arvore.verificarExistencia(arvore.raiz, 6));

        System.out.println();
        
        arvore.removerMaior();
        arvore.atravessaEmOrdem(arvore.raiz);

        System.out.println();

        arvore.removerMenor();
        arvore.atravessaEmOrdem(arvore.raiz);
    }
}