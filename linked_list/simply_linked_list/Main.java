package simply_linked_list;

public class Main {
    public static void main(String[] args) {
        final LinkedList linkedlist = new LinkedList();

        linkedlist.addLast(5);
        linkedlist.addLast(4);
        linkedlist.addLast(2);
        linkedlist.addFirst(0);
        linkedlist.print();
    }
}