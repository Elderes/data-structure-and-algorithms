// Node e LinkedList

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

    public void exibir() {
        while (next != null) {
            System.out.println(head);
        }
        System.out.println(head);
    }
}