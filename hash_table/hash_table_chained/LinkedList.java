package hash_table_chained;

class Node {
    Aluno aluno;
    Node next;

    public Node(Aluno aluno) {
        this.aluno = aluno;
        this.next = null;
    }
}

class LinkedList {
    Node head;

    public LinkedList() {
        this.head = null;
    }

    public void inserir(Aluno aluno) {
        Node new_node = new Node(aluno); // Armazena o novo aluno em um novo nó, que ainda não foi encadeado (nenhum nó aponta para esse novo nó).

        if (head == null) {
            head = new_node;
        } else {
            Node current = head;
            while (current.next != null) { // Precisa checar se existe um endereço para próximo.
                current = current.next;
            }
            current.next = new_node; // Agora o último nó da lista (current) aponta para o novo nó (new_node).
        }
    }

    public boolean remover(int matricula) {
        Node current = head;
        Node previous = null;

        while (current != null) {
            if (current.aluno.getMatricula() == matricula) {
                if (previous == null) { // Em caso de remoção do primeiro nó.
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

    public String pegar(int matricula) {
        Node current = head;
        
        while (current != null) {
            if (current.aluno.getMatricula() == matricula) {
                return current.aluno.getNome();
            }
            current = current.next;
        }
        return null;
    }

    public String exibir() {
        Node current = head;
        StringBuilder result = new StringBuilder();

        while (current != null) {
            result.append(current.aluno.getMatricula()).append(" ");
            current = current.next;
        }
        return result.toString();
    }
}