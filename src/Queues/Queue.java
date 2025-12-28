package Queues;

public class Queue {

    int front, rear, size;
    int capacity;
    int array[];

    public Queue(int cap) {
        capacity = cap;
        front = size = 0;
        rear = capacity - 1;
        array = new int[capacity];
    }

    // Queue is full when size becomes
    // equal to the capacity

    boolean isFull() {
        return (size == capacity);
    }

    // Queue is empty when size is O
    boolean isEmpty() {
        return (size == 0);

    } // Method to add an item to the queue.

    // It changes rear and size
    void enqueue(int item) {
        if (isFull())
            return;
        rear = (rear + 1) % capacity;
        array[rear] = item;
        size = size + 1;
        System.out.println(item + "enqueued to queue");
    } // Method to remove an item from queue.
    boolean areEqual(Queue q1, Queue q2) {

        if (q1.size != q2.size) {
            return false;
        }

        for (int i = 0; i < q1.size; i++) {
            int q1index = (q1.front + i) % q1.capacity;
            int q2index = (q2.front + i) % q2.capacity;

            if (q1.array[q1index] != q2.array[q2index]) {
                return false;
            }
        }
        return true;
    }
// It changes front and size

    int dequeue() {
        if (isEmpty())
            return Integer.MIN_VALUE;
        int item = array[front];
        front = (front + 1) % capacity;
        size = size - 1;
        return item;

    }

    // Method to get front of queue

    int front() {

        if (isEmpty())

            return Integer.MIN_VALUE;

        return array[front];

    }

// Method to get rear of queue

    int rear() {

        if (isEmpty())

            return Integer.MIN_VALUE;

        return array[rear];

    }

}