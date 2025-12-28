package Stacks;

public class Test {


    public static void main(String[] args) {
        MyStack stack = new MyStack();

        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.push(50);

        stack.display();
        System.out.println("Stack boyutu: " + stack.getSize());

        stack.removeMiddle();
        stack.display();
    }
}