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
                if (previous != null) {
                    head = current.next;
                } else {
                    previous.next = current.next;
                }
            }
        }
    }
}