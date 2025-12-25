package HospitalPatientManagementSystemSimulation;

public class TreatmentQueue {
    private Node head, tail;
    private int size = 0;


    public void enqueue(TreatmentRequest request) {
        Node newNode = new Node(request);
        if (tail ==null) {
            head =tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }


    public TreatmentRequest dequeue() {
        if (head ==null) return null;
        TreatmentRequest request = head.request;
        head = head.next;
        if (head ==null) tail = null;
        size--;
        return request;
    }

     public int size() { return size; }

       public void printQueue() {
         Node temp= head;
        while (temp!=null) {
            System.out.println(temp.request);
            temp = temp.next;
        }
    }


        private class Node {
           TreatmentRequest request;
           Node next;
            Node(TreatmentRequest request) { this.request = request; }
    }}