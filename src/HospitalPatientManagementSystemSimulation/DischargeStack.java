package HospitalPatientManagementSystemSimulation;

public class DischargeStack {
    private Node top; // Yığının en üstündeki eleman

    private class Node {
        DischargeRecord record;
        Node next;
        Node(DischargeRecord record) { this.record = record; }
    }

    // Yığının üstüne eleman ekle (O(1))
    public void push(DischargeRecord record) {
        Node newNode = new Node(record);
        newNode.next = top;
        top = newNode;
    }

    // En üstteki elemanı çıkar ve döndür (O(1))
    public DischargeRecord pop() {
        if (top == null) return null;
        DischargeRecord record = top.record;
        top = top.next;
        return record;
    }

    // En üstteki elemana bak ama çıkarma (O(1))
    public DischargeRecord peek() {
        return (top != null) ? top.record : null;
    }

    public void printStack() {
        System.out.println("--- Discharge Stack (Recent to Oldest) ---");
        Node temp = top;
        while (temp != null) {
            System.out.println(temp.record);
            temp = temp.next;
        }
    }
}