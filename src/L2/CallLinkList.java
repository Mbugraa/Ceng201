package L2;

public class CallLinkList {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        list.append(10);
        list.append(20);
        list.prepend(5);
        list.append(30);

        list.display(); // 5 -> 10 -> 20 -> 30 -> null

        list.delete(20);
        list.display(); // 5 -> 10 -> 30 -> null

        reversedLink();
    }



    public static void reversedLink() {

        ReverseLinkedList revers=new ReverseLinkedList();
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);

        head = revers.reverse(head);


        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }

    }
}

