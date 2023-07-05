package practice.multithreads.creation;

public class CounterA extends Thread{
    String name;

    public CounterA(String name){
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println(this.name+" has started.");
        for (int i=1; i<101; i++){
            System.out.println(this.name+" - "+i);
        }
        System.out.println(this.name+" has finished.");
    }
}
