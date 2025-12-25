package L1;

public class StaticVariableLifeTime {
    static int variableCounter=0;

    public void incrementCounter(int objNo) {
        variableCounter++;
        System.out.println("Counter: "+objNo +" : " + variableCounter);
    }

    public static void main(String[] args) {

        StaticVariableLifeTime varObj1 = new StaticVariableLifeTime();
        StaticVariableLifeTime varObj2= new StaticVariableLifeTime();


        varObj1.incrementCounter(1);  // Counter: 1
        varObj2.incrementCounter(2);  // Counter: 2
    }
}