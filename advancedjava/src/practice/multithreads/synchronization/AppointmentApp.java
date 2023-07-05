package practice.multithreads.synchronization;

public class AppointmentApp {
    public static void main(String[] args) {
        String[] users = {"Tolstoy", "Victor Hugo", "Balzac", "Dostoyevski", "John Steinbeck"};
        AppointmentCenter center = new AppointmentCenter();
        for (String user : users){
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    Thread.currentThread().setName(user);
                    String name = Thread.currentThread().getName();
                    System.out.println("Dear "+name+",  your appointment date is: "+center.getAppointmentDate());
                }
            });
            thread.start();
        }
    }
}
