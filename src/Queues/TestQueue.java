package Queues;

public class TestQueue {

    public static void main(String[] args)

    {

        Queue queue = new Queue(4);

        System.out.println(queue.dequeue() + " dequeued from queue\n");

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
        Queue queue2 = new Queue(4);
        queue2.enqueue(10);
        queue2.enqueue(40);

        System.out.println("Compare Queue: "+ queue.areEqual(queue, queue2));
        System.out.println(queue.dequeue() + "dequeued from queue\n");
        System.out.println("Front item is:" + queue.front());
        System.out.println("Rear item is: "+ queue.rear());

    }

}