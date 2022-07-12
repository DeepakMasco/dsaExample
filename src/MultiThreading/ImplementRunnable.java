package MultiThreading;

public class ImplementRunnable implements Runnable{

    @Override
    public void run() {
        System.out.println("Implemented the Runnable Interface");
        System.out.println(Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        // As we can see the thread in main and run method is same and this runnable does not create any new thread.
        System.out.println(Thread.currentThread().getName());

        ImplementRunnable implementRunnable = new ImplementRunnable();
        // We can do run multiple times.
        implementRunnable.run();
        implementRunnable.run();
        implementRunnable.run();
        implementRunnable.run();
        implementRunnable.run();


    }
}
