class Node {
    Aluno aluno;
    Node next;

    public Node(Aluno aluno) {
        this.aluno = aluno;
        this.next = null;
    }
}

public class LinkedList {
    private Node head;

    public LinkedList() {
        this.head = null;
    }

    public void inserir(Aluno aluno) {
        Node newNode = new Node(aluno);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (head != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public boolean remover(int matricula) {
        Node current = head;
        Node previous = null;

        while (current != null) {
            if (current.aluno.getMatricula() == matricula) {
                if (previous != null) { // Em caso de remoção do primeiro nó.
                    head = current.next; // O segundo nó passa a ser a cabeça da lista.
                } else {
                    previous.next = current.next; // O nó anterior é "amarrado" com o próximo.
                }
                return true; // Encontrou a matrícula. Quebra o ciclo.
            }
            previous = current; // Mantem a referência do nó anterior se achar o elemento a ser removido.
            current = current.next; // Vai para o próximo nó e repete o ciclo.
        }
        return false; // Caso a matrícula não seja encontrada na lista.
    }

    public String pegarValor(int matricula) {
        Node current = head; //
    }

}