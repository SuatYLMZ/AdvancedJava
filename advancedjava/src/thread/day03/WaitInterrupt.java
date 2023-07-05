package thread.day03;

public class WaitInterrupt {
    static private int balance = 0;
    public static void main(String[] args) {

        WaitInterrupt obj = new WaitInterrupt();

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                obj.withdraw(800);
            }
        });
        thread1.setName("Withdraw Thread");
        thread1.start();

        Thread thread2  = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                obj.deposit(2000);
                thread1.interrupt(); //stop withdraw thread
            }
        });
        thread2.setName("Deposit Thread");
        thread2.start();

    }

    //method to withdraw
    public synchronized void withdraw(int amount){
        if(balance<=0 || balance<amount){
            System.out.println("Insufficient balance: "+balance);
            System.out.println("Waiting for the balance to be updated...");
            try {
                wait(); // we are making the thread to wait until someone deposit
                //sufficient money
                //wait and notify should be in the same object
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
                //System.out.println("Withdraw is interrupted");
            }
            //if balance becomes sufficient
            if(balance>=amount){
                balance = balance - amount;
                System.out.println("Amount has been withdrawn successfully. Curret balance is: "+balance);

            }else {
                System.out.println("Insufficient amoutn : "+balance);
                System.out.println("Ask your parents to deposit more");
            }
        }
    }

    //method to deposit
    public synchronized void deposit(int amount){
        System.out.println(Thread.currentThread().getName() +" want to deposit amount");
        balance = balance +amount;
        System.out.println("The amount is deposited. The current balance is "+balance);

    }
}
