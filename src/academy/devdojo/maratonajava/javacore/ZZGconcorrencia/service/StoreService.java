package academy.devdojo.maratonajava.javacore.ZZGconcorrencia.service;

import java.util.concurrent.*;

public class StoreService {
    private static final ExecutorService ex = Executors.newCachedThreadPool();

    public static void shutdown() {
        ex.shutdown();
    }

    public double getPriceSync(String storeNme) {
        System.out.printf("Getting price sync for store %s%n", storeNme);
        return princeGeneretor();
    }

    public Future<Double> getPriceAsyncFuture(String storeNme) {
        System.out.printf("Getting price sync for store %s%n", storeNme);
        return ex.submit(this::princeGeneretor);
    }

    public CompletableFuture<Double> getPriceAsyncCompletaFuture(String storeNme) {
        System.out.printf("Getting price sync for store %s%n", storeNme);
        return CompletableFuture.supplyAsync(this::princeGeneretor);
    }

    private double princeGeneretor() {
        System.out.printf("%s generatoing price %n ", Thread.currentThread().getName());
        delay();
        return ThreadLocalRandom.current().nextInt(1, 500) * 10;
    }

    private void delay() {
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
