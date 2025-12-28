package Fibo;

public class Factorial {
    static int factorialT(int n) {
        System.out.println("Çağrı: factorial(" + n + ")");

        // Temel durum
        if (n == 1) {
            System.out.println("Dönüş: factorial(1) = 1");
            return 1;
        }

        // Recursive çağrı
        int result = n * factorialT(n - 1);

        // Geriye dönüş aşaması
        System.out.println("Geriye dönüşte: " + n + " * factorial(" + (n - 1) + ") = " + result);

        return result;
    }

    public static void main(String[] args) {
        int number = 5;
        int result = factorialT(number);
        System.out.println("\nSonuç: " + number + "! = " + result);
    }
}
