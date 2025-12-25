package HospitalPatientManagementSystemSimulation;

public class DischargeStack {
    private Node top;

     private class Node {
         DischargeRecord record;
        Node next;
        Node(DischargeRecord record) { this.record = record; }
    }


    public void push(DischargeRecord record) {
         Node newNode = new Node(record);
        newNode.next = top;
        top = newNode;
    }


     public DischargeRecord pop() {
         if (top == null) return null;
          DischargeRecord record = top.record;
           top = top.next;
         return record;
    }


     public DischargeRecord peek() {
         return (top != null) ? top.record : null;
    }

     public void printStack() {
         System.out.println("--- Discharge Stack (recent to Oldest) ---");
         Node temp = top;
          while (temp != null) {
             System.out.println(temp.record);
              temp = temp.next;
        }}}