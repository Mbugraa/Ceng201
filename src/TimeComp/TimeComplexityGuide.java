package TimeComp;

public class TimeComplexityGuide {
    public static void main(String[] args) {

        System.out.println(" 1:Why can't we rely on CPU execution time to measure algorithm efficency?");
        System.out.println(answer("1"));
        System.out.println("\n2: How many operations does this code execute?");
        System.out.println(answer("2"));
        System.out.println("\n3.a. Give he final time complexity of the code: ");
        System.out.println(answer("3a"));
        System.out.println("\n3.b. Give he final time complexity of the code: ");
        System.out.println(answer("3b"));
        System.out.println("\n3.c. Give he final time complexity of the code: ");
        System.out.println(answer("3c"));


        String[] questions = {"1", "2", "3a", "3b", "3c"};
        for (String q : questions) {
            System.out.println("Question " + q + ":");
            System.out.println(answer(q));
            System.out.println();
        }
    }

    /**
     * Returns the answer based on the question ID
     * @param questionId Question number (1, 2, 3a, 3b, 3c)
     * @return The answer to the question
     */
    public static String answer(String questionId) {
        switch (questionId.toLowerCase()) {
            case "1":
                return "We cannot rely on CPU execution time because:\n" +
                        "- Hardware differences\n" +
                        "- Software environment\n" +
                        "Therefore, we use Big O notation.";
            case "2":
                return "Answer: O(1)\n" +
                        "Explanation: The code performs a fixed number of operations (3 operations).\n";

            case "3a":
                return "Answer: O(n)\n" +
                        "Explanation: A single loop runs n times.\n";

            case "3b":
                return "Answer: O(n²)\n" +
                        "Explanation: Two nested loops, each running n times.\n" +
                        "n × n = n² iterations.";

            case "3c":
                return "Answer: O(log n)\n" +
                        "Explanation: n is divided by 2 at each step.\n" +
                        "For n = 1024, there are 10 iterations (2^10 = 1024).\n" +
                        "Logarithmic time complexity – very efficient.";
            default:
                return "Invalid question ID! Please check the question ID.";
        }
    }
}
