package Fibo;

public class FibonacciIterative {
    public static void main(String[] args) {
        int n = 10; // Kaç terim yazdırılacak
        int first = 0;
        int second = 1;

        System.out.print("Fibonacci serisi: " + first + " " + second);

        for (int i = 2; i < n; i++) {
            int next = first + second;
            System.out.print(" " + next);
            first = second;
            second = next;
        }
    }
}