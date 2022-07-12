package MultiThreading;
// Multi Threading is CPU switching between multiple threads.
// To decide which thread will get resource first it is based on priority and the algo in OS.
// And every thread will get fix amount of time to work and then next thread will get.
// This is how multiThreading works and this is called time slicing.
public class ExtendThread extends Thread {

    @Override
    protected void finalize() throws Throwable {
        // We can perform our clean up activities in this method.
        super.finalize();
    }

    // volatile keyword here makes sure that
    // the changes made in one thread are
    // immediately reflect in other thread
    static volatile int sharedVar = 6;

    @Override
    public void run() {
       System.out.println("Thread Started");
       // We can see here the thread name will ne different from the main.
        // It proves start() method creates a new thread and use that to call run method.
        System.out.println(Thread.currentThread().getName());
    }

    public static void main(String[] args) throws InterruptedException {





        System.out.println(Thread.currentThread().getName());
        ExtendThread extendThread = new ExtendThread();


        // It is basically to tell first complete the execution of this
        // thread and then only move ahead for further execution.
        extendThread.join();




        // We can use the below to make it daemon thread.
       // extendThread.setDaemon(true);
        extendThread.start();
        // We CANNOT start the thread multiple times it will fail saying illeagel state
        // This method actually creates and registers a new thread and use it
        //extendThread.start();
        //extendThread.start();
    }
}
