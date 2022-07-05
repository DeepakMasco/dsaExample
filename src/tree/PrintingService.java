package tree;

public class PrintingService {

    static int m;
    int j = 1;
    public void printEven() {
        synchronized (this) {
            while (j < m) {
                if (j % 2 != 0) {
                try {
                    wait();
                }
                catch(Exception e) {
                    System.out.println("Error Occurred");
                }
                }
                    System.out.println(j + Thread.currentThread().getName());

                j++;
                notify();
            }
        }
    }

    public void printOdd() {
        synchronized (this) {
            while (j < m) {
                if(j%2==0) {
                    try {
                        wait();
                    } catch (Exception e) {
                        System.out.println("Error Occurred");
                    }
                }
                    System.out.println(j+ Thread.currentThread().getName());
                j++;
                notify();
            }
        }

    }


    public static void main(String[] args) {
        // print 1 to N (all even print) N  a
        m = 10;

        PrintingService printingService = new PrintingService();

        Thread oddThread = new Thread(new Runnable() {
            @Override
            public void run() {
                printingService.printOdd();
            }
        });


        Thread evenThread = new Thread(new Runnable() {
            @Override
            public void run() {
                printingService.printEven();

            }
        });

        oddThread.start();
        evenThread.start();





    }

}
