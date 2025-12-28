package Stacks;

public class MyStack {

    Node head;
    Node middle;
    int size;

    public MyStack() {
        this.head = null;
        this.middle = null;
        this.size = 0;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    // Eleman ekleme (push)
    public void push(int value) {
        Node newNode = new Node(value);
        newNode.next = head; // Yeni düğüm eski top’u işaret eder

        if(head!=null) {
            head.prev=newNode;
        }

        head = newNode;      // Yeni düğüm artık tepededir
        size++;
        if(size==1) {
            middle=newNode;
        } else if (size %2!=0) {
            middle=middle.prev;
        }

        System.out.println(value + " eklendi.");
    }



    // Eleman çıkarma (pop)
    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack boş, çıkarılamaz.");
            return -1;
        }
        int value = head.data;
        head = head.next;
        size--;
        System.out.println(value + " çıkarıldı.");
        return value;
    }

    // En üstteki elemanı gösterme (peek)
    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack boş.");
            return -1;
        }
        return head.data;
    }


    // Ortadaki elemanı çıkarma
    public void removeMiddle() {
        if (isEmpty()) {
            System.out.println("Stack boş, ortadan çıkarılamaz.");
            return;
        }

        System.out.println("Ortadaki eleman (" + middle.data + ") çıkarıldı.");

        // Eğer tek eleman varsa
        if (size == 1) {
            head = null;
            middle = null;
            size = 0;
            return;
        }

        // Ortadaki düğümü çıkar: prev ve next'i birbirine bağla
        if (middle.prev != null) {
            middle.prev.next = middle.next;
        }
        if (middle.next != null) {
            middle.next.prev = middle.prev;
        }

        size--;

        // Yeni middle güncellemesi
        if (size % 2 == 0) {
            // eleman sayısı çiftse bir ileri git
            middle = middle.next;
        } else {
            // tekse bir geri git
            middle = middle.prev;
        }
    }



    public void display() {
        if (isEmpty()) {
            System.out.println("Stack boş.");
            return;
        }
        System.out.print("Stack içeriği (üstten alta): ");
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }



    public void addMyStack(int data) {
        Node stackp=new Node(data);

        if (head == null) {
            head = middle = stackp;
            size++;
            System.out.println("Added " + stackp.getInfo());
            return;
        }

        middle.next = stackp; //
        stackp.prev = middle; //
        middle = stackp;

        System.out.println("Added: " + stackp.getInfo());
    }



    public void nextStack() {


        if (middle.next == null) {
            System.out.println("You're on the last");
            return;
        }

        middle = middle.next;
        System.out.println("Now playing: " + middle.getInfo());
    }


    public void previousStack() {
        if (middle == null) {
            System.out.println("empty");
            return;
        }

        if (middle.prev == null) {
            System.out.println("Start");
            return;
        }

        middle = middle.prev;
        System.out.println("Now playing: " + middle.getInfo());
    }


    public boolean isEmpty() {
        return head == null;
    }


}