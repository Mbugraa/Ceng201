package Fibo;

public class FibonacciRecursive {
    static int fib(int n) {
        System.out.println("Çağrı: fib(" + n + ")");
        if (n <= 1) return n;  // temel durum
        int result = fib(n - 1) + fib(n - 2);
        System.out.println("Geri dönüş: fib(" + n + ") = " + result);
        return result;
    }

    public static void main(String[] args) {
        int n = 6; // 6. Fibonacci sayısı
        int result = fib(n);
        System.out.println("\nSonuç: fib(" + n + ") = " + result);
    }
    public int fibCount(int[] arr, int index) {
        if (arr.length == index) return 0;  // temel durum

        if(arr[index]%2==0) {
            return 1+fibCount(arr,index+1);
        } else {
            fibCount(arr,index+1);
        }

        return 0;
    }

}