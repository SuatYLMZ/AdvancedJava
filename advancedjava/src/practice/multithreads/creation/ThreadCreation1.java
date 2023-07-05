package practice.multithreads.creation;

public class ThreadCreation1 {
    /*
            Task1: Counter class which extends the Thread class.
                    We'll create two methods that counts from 1 to 100.
     */
    public static void main(String[] args) {
        CounterA counter1 = new CounterA("Ronaldo");
        CounterA counter2 = new CounterA("Messi");

        counter1.start();
        counter2.start();
    }

}
