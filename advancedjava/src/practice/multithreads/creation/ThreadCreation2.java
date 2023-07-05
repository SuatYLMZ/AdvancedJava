package practice.multithreads.creation;

public class ThreadCreation2 {
    /*
            Task2: CounterB which will implement the Runnable interface.
                    print the alphabet. From A to Z.
     */

    public static void main(String[] args) {
        CounterB counter1 = new CounterB("Ronaldo");
        CounterB counter2 = new CounterB("Messi");

        Thread thread1 = new Thread(counter1);
        Thread thread2 = new Thread(counter2);

        thread1.start();
        thread2.start();
    }

}
