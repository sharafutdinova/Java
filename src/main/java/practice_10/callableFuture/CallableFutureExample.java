package practice_10.callableFuture;

import java.util.Random;
import java.util.concurrent.*;

public class CallableFutureExample {

    static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Callable<Integer> dhaResult = () -> {
            System.out.println("AAAAAAA");
            Thread.sleep(1000);
            return new Random().nextInt();
        };
        Future<Integer> future = executorService.submit(dhaResult);
        System.out.println(future.get());
        executorService.shutdown();
    }
}
