package Stack;

public class StackUsingLinkedlist {
    private class Node {
        int data;
        Node link;


        Node(int data) {
            this.data = data;
            this.link = null;
        }
    }


    private Node top;


    public StackUsingLinkedlist() {
        this.top = null;
    }


    public void push(int x) {

        Node temp = new Node(x);


        temp.link = top;


        top = temp;
    }


    public boolean isEmpty() {
        return top == null;
    }


    public int peek() {

        if (!isEmpty()) {
            return top.data;
        } else {
            System.out.println("Stack is empty");
            return -1;
        }
    }


    public int pop() {

        if (top == null) {
            System.out.print("\nStack Underflow");
            return -1;
        }

        // get the data from top node
        int data = top.data;


        top = top.link;

        return data;
    }


    public void display() {

        if (top == null) {
            System.out.println("Stack is empty");
            return;
        }

        Node temp = top;
        while (temp != null) {

            System.out.print(temp.data);


            temp = temp.link;

            if(temp != null)
                System.out.print(" -> ");
        }
        System.out.println();
    }


    public int size() {
        int count = 0;
        Node temp = top;
        while (temp != null) {
            count++;
            temp = temp.link;
        }
        return count;
    }

    // Main method for testing
    public static void main(String[] args) {
        StackUsingLinkedlist stack = new StackUsingLinkedlist();

        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.print("Stack elements: ");
        stack.display(); // Output: 30 -> 20 -> 10

        System.out.println("Top element: " + stack.peek()); // Output: 30

        System.out.println("Popped: " + stack.pop()); // Output: 30
        System.out.println("Popped: " + stack.pop()); // Output: 20

        System.out.print("Stack after popping: ");
        stack.display(); // Output: 10

        System.out.println("Stack size: " + stack.size()); // Output: 1
        System.out.println("Is stack empty? " + stack.isEmpty()); // Output: false
    }
}
