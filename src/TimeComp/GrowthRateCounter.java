package TimeComp;

public class GrowthRateCounter {

    // O(1) - Constant Time
    public static long constantTime(int n) {
        long counter = 0;
        counter++; // sabit işlem
        return counter;
    }

    // O(n) - Linear Time
    public static long linearTime(int n) {
        long counter = 0;
        for (int i = 0; i < n; i++) {
            counter++;
        }
        return counter;
    }

    // O(n²) - Quadratic Time
    public static long quadraticTime(int n) {
        long counter = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                counter++;
            }
        }
        return counter;
    }

    // O(log n) - Logarithmic Time
    public static long logarithmicTime(int n) {
        long counter = 0;
        while (n > 1) {
            n = n / 2;
            counter++;
        }
        return counter;
    }

    public static void main(String[] args) {
        int[] nValues = {2, 4, 8, 16, 32, 64, 128};

        System.out.printf("%-10s %-10s %-10s %-10s %-10s%n",
                "n", "O(1)", "O(log n)", "O(n)", "O(n²)");
        System.out.println("------------------------------------------------");

        for (int n : nValues) {
            System.out.printf("%-10d %-10d %-10d %-10d %-10d%n",
                    n,
                    constantTime(n),
                    logarithmicTime(n),
                    linearTime(n),
                    quadraticTime(n));
        }
    }
}