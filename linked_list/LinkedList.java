import java.util.LinkedList;

class LinkedListCustom {
    Node head;
    
    public LinkedListCustom() {
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

    public void add(int pos, int value) {
        
    }

    public void print() {
        Node curr = this.head;
        while (curr != null) {
            System.out.print(curr.value);
            System.out.print(", ");
            curr = curr.next;
        }
        System.out.print("\b");
    }
}