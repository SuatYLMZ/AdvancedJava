package practice.multithreads.interrupts;

public class ShopInterrupt {
    /*
            Task:
                    Write a program that keeps the stock status for a market.
                    If there is not enough stock, wait for the new stock to come.
                    When the new item comes. Let the sale begin.
     */

    public static volatile int stock;

    public static void main(String[] args) {
        ShopInterrupt shop = new ShopInterrupt();

        Thread consumerThread = new Thread(new Runnable() {
            @Override
            public void run() {
                shop.consumeProduct(5);
            }
        });
        consumerThread.setName("Consumer");

        Thread producerThread = new Thread(new Runnable() {
            @Override
            public void run() {
                shop.produceProduct(6);
                consumerThread.interrupt();
            }
        });
        producerThread.setName("Producer");

        consumerThread.start();
        producerThread.start();
    }

    private synchronized void produceProduct(int amount) {
        System.out.println(Thread.currentThread().getName()+" would like to add items to the stock.");
        stock+=amount;
        System.out.println("New products has been added.");
        System.out.println("Updated Stock: "+stock);
    }

    private synchronized void consumeProduct(int amount) {
        if (amount>stock){
            System.out.println(Thread.currentThread().getName()+" would like to buy a product");
            System.out.println("There's not enough stock.");
            System.out.println("Waiting for the new items");
            try{
                wait();
            }catch (InterruptedException e){
                if (amount<=stock){
                    System.out.println(Thread.currentThread().getName()+" would like to buy a product");
                    System.out.println("Product bought. Decreasing from the stock.");
                    stock-=amount;
                    System.out.println("Updated Stock: "+stock);
                }else{
                    System.out.println(Thread.currentThread().getName()+" would like to buy a product");
                    System.out.println("There is not enough product.");
                    System.out.println("You can check us out later!");
                }
            }

        }
    }
}
