package TimeComp;

public class TimeComplexityExamples {
    public static void constantTime(int[] arr) {
        System.out.println("O(1) Example:");
        if (arr.length > 0)
            System.out.println("First element: " + arr[0]);
    }

    // O(n) - Linear Time
    // Döngü, n eleman üzerinde tek tek ilerler.
    public static void linearTime(int[] arr) {
        System.out.println("\nO(n) Example:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    // O(n²) - Quadratic Time
    // İç içe iki döngü: her biri n kez çalışır.
    public static void quadraticTime(int[] arr) {
        System.out.println("\nO(n²) Example:");
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print("(" + arr[i] + "," + arr[j] + ") ");
            }
            System.out.println();
        }
    }

    // O(log n) - Logarithmic Time
    // Her adımda giriş yarıya indirilir (örneğin binary search).
    public static void logarithmicTime(int n) {
        System.out.println("\nO(log n) Example:");
        int steps = 0;
        while (n > 1) {
            n = n / 2;
            steps++;
            System.out.println("Step " + steps + ": n = " + n);
        }
    }

    // O(n log n) - Linearithmic Time
    // Genelde sıralama algoritmalarında görülür (örneğin Merge Sort).
    public static void linearithmicTime(int n) {
        System.out.println("\nO(n log n) Example (simulation):");
        for (int i = 1; i <= n; i++) {
            int temp = n;
            while (temp > 1) {
                temp = temp / 2;
            }
        }
        System.out.println("Simulated " + n + " * log(n) steps roughly.");
    }

    // main metodu — tüm örnekleri çalıştırır
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};

        constantTime(arr);
        linearTime(arr);
        quadraticTime(arr);
        logarithmicTime(16);
        linearithmicTime(16);
    }
}
