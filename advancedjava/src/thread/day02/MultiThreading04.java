package thread.day02;

public class MultiThreading04 {
    public static void main(String[] args) {

        Brakets1 brakets1 = new Brakets1();

        long startTime = System.currentTimeMillis();
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i =0; i< 7;i++ ){
                    brakets1.generateBrackets();
                }
            }
        });

        thread1.start();

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i =0; i< 7;i++ ){
                    brakets1.generateBrackets();
                }
            }
        });
        thread2.start();
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        //these lines will wait until the thread die or terminate
        System.out.println("End of the code");
        long endTime = System.currentTimeMillis();
//        System.out.println("Time executed is: "+(endTime-startTime)); //Time executed is: 3575
        System.out.println("Time executed is: "+(endTime-startTime)); //Time executed is: 1831
    }
}
class Brakets1{

    //[[[[[ ]]]]]
    public void generateBrackets(){

        //this --> the thread which calls this method
        //block/locks the method block
        //when the thread finishes its task, the block will be released for other threads

        synchronized (this){
            for(int i =0; i<10; i++){
                if(i<5){
                    System.out.print("[");
                }else {
                    System.out.print("]");
                }
            }
            System.out.println("");
        }

        //delaying the method
        for(int i = 0; i<5; i++){
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
