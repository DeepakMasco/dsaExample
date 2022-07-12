package MultiThreading;

import java.util.concurrent.Callable;

//The generic type is the return type of call method. This feature is not available in runnable
public class ImplementCallable implements Callable<Integer> {


    @Override
    public Integer call() throws Exception {
        return 5;
    }


    public static void main(String[] args) throws Exception {
        ImplementCallable implementCallable = new ImplementCallable();
        Integer ans = implementCallable.call();
        System.out.println(ans);
    }
}
