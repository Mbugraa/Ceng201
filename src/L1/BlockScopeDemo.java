package L1;

public class BlockScopeDemo {

    static int globalCounter = 50;

    public static void main(String[] args) {

        System.out.println("initially globalCounter: " + globalCounter);

        int outerX = 5;
        System.out.println("inside local integer variable: " + outerX);


        if (outerX > 2) {
            int innerY = 15;
            System.out.println("local variable outerX: " + outerX);
            System.out.println("Variable defined inside the if block blockVar: " + innerY);
            System.out.println("inside the if block globalCounter: " + globalCounter);// Global variable
        }




        for (int i = 0; i < 3; i++) {
            System.out.println("inside for loop i: " + i);

        }


        int globalCounter = 100;
        System.out.println("inside main  globalCounter: " + globalCounter);


        System.out.println("Class level globalCounter: " + BlockScopeDemo.globalCounter);



    }
}