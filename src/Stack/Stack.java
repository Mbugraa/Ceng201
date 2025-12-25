package Stack;

public class Stack {

    static final int MAX = 1000;
    int top;
    int[] a = new int[MAX]; // Maximum size of Stack


    Stack() {
        top = -1;
    }


    boolean isEmpty() {
        return (top < 0);
    }


    boolean push(int x) {
        if (top >= (MAX - 1)) {
            System.out.println("Stack Overflow");
            return false;
        } else {
            a[++top] = x;
            System.out.println(x + " pushed into stack");
            return true;
        }
    }


    int pop() {
        if (top < 0) {
            System.out.println("Stack Underflow");
            return 0;
        } else {
            int x = a[top--];
            return x;
        }
    }


    int peek() {
        if (top < 0) {
            System.out.println("Stack Underflow");
            return 0;
        } else {
            return a[top];
        }
    }


    void print() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return;
        }
        System.out.print("Stack elements: ");
        for (int i = top; i >= 0; i--) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }


    public static void main(String[] args) {
        Stack s = new Stack();
        s.push(10);
        s.push(20);
        s.push(30);

        s.print();

        System.out.println(s.pop() + " popped from stack");

        System.out.println("Top element is " + s.peek());
        s.print();
    }
}