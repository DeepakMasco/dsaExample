package tree;

public class Testing {

    public static void main(String[] args) {
        // print 1 to N (all even print) N  a
        int n = 10;

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
