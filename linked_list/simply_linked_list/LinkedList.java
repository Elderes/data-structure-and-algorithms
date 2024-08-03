package simply_linked_list;

class Node {
    public int value;
    public Node next;

    Node(int v) {
        this.value = v;
        this.next = null;
    }
}

class LinkedList {
    Node head;
    
    public LinkedList() {
        this.head = null;
    }

    public void addFirst(int value) {
        Node current = this.head;
        this.head = new Node(value);
        head.next = current;
    }

    public void addLast(int value) {
        Node current = this.head;

        if (current == null) {
            this.head = new Node(value);
        } else {
            while (current.next != null)
                current = current.next;
            current.next = new Node(value);
        }
    }

    public int getSize() {
        Node current = this.head;
        int size = 0;
        while (current != null) {
            current = current.next;
            size++;
        }
        return size;
    }

    public void add(int pos, int value) {
        Node current = this.head;
        int counter = 0;
        if (pos <= getSize()) {
            while (counter != pos) {
                current = current.next;
                counter++;
            }
            Node newNode = new Node(value);
            newNode.next = current.next;
            current.next = newNode;
        } else {
            System.out.println("Invalid index.");
        }
    }

    public void printElements() {
        Node current = this.head;
        int counter = 0;
        while (current != null) {
            System.out.println(counter + ". " + current.value);
            current = current.next;
            counter++;
        }
    }
}
