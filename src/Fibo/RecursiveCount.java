package Fibo;

import java.io.FileOutputStream;

public class RecursiveCount {

    public static void main(String[] args) {

        int sayilar[]= {3, 6, 7, 8};
        FibonacciRecursive fb=new FibonacciRecursive();

        System.out.println( fb.fibCount(sayilar,0));

    }
}