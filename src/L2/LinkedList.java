package L2;

public class LinkedList {
    Node head;

    public LinkedList() {
        head = null;
    }


    public void append(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }

        Node current = head;
        while (current.next != null) {   // Listenin sonuna git
            current = current.next;
        }
        current.next = newNode;
    }


    public void prepend(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }


    public void delete(int key) {
        if (head == null) return;


        if (head.data == key) {
            head = head.next;
            return;
        }

        Node current = head;
        Node prev = null;
        while (current != null && current.data != key) {
            prev = current;
            current = current.next;
        }

        if (current == null) return;
        prev.next = current.next;
    }


    public void display() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
}