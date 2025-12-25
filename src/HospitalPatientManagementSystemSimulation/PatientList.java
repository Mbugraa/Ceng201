package HospitalPatientManagementSystemSimulation;

public class PatientList {

    private Node head;

    // INNER NODE CLASS (DOĞRU YER)
    private class Node {
        Patient patient;
        Node next;

        Node(Patient patient) {
            this.patient = patient;
            this.next = null;
        }
    }

    // O(n)
    public void addPatient(Patient p) {
        Node newNode = new Node(p);
        if (head == null) {
            head = newNode;
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    // O(n)
    public void removePatient(int id) {
        if (head == null) return;

        if (head.patient.id == id) {
            head = head.next;
            return;
        }

        Node current = head;
        while (current.next != null && current.next.patient.id != id) {
            current = current.next;
        }

        if (current.next != null) {
            current.next = current.next.next;
        }
    }

    // O(n)
    public Patient findPatient(int id) {
        Node temp = head;
        while (temp != null) {
            if (temp.patient.id == id) return temp.patient;
            temp = temp.next;
        }
        return null;
    }

    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.patient);
            temp = temp.next;
        }
    }
}
