package com.efimchick;

import java.math.BigInteger;
import java.util.concurrent.*;

/**
 * Created by efimchick on 01.08.17.
 */
public class LockFreeFibonacci {
    public static void main(String[] args) throws InterruptedException {

        final ExecutorService executorService = Executors.newWorkStealingPool();

        final FibonacciSequence fibonacciSequence = new FibonacciSequence();

        for (int i = 0; i < 30; i++) {
            final CompletableFuture<BigInteger> future = CompletableFuture.supplyAsync(() -> fibonacciSequence.next(), executorService);

            future.thenAccept(System.out::println);

        }

        executorService.shutdown();
        executorService.awaitTermination(5, TimeUnit.SECONDS);


    }
}
