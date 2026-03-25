package academy.devdojo.maratonajava.javacore.ZZGconcorrencia.test;

import academy.devdojo.maratonajava.javacore.ZZGconcorrencia.service.StoreService;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class CompletableFutureTest01 {
    static void main(String[] args) {
        StoreService storeService = new StoreService();
//        searchPriceSync(storeService);
//        searchPriceAsyncFuture(storeService);
        searchPriceAsyncCompletableFuture(storeService);
    }

    private static void searchPriceSync(StoreService storeService) {
        long start = System.currentTimeMillis();
        System.out.println(storeService.getPriceSync("store 1"));
        System.out.println(storeService.getPriceSync("store 2"));
        System.out.println(storeService.getPriceSync("store 3"));
        System.out.println(storeService.getPriceSync("store 4"));

        long end = System.currentTimeMillis();

        System.out.printf("Time passed to searchPriceSync %dms%n", (end - start));
    }

    private static void searchPriceAsyncFuture(StoreService storeService) {
        long start = System.currentTimeMillis();
        Future<Double> priceAsyncFuture1 = storeService.getPriceAsyncFuture("store 1");
        Future<Double> priceAsyncFuture2 = storeService.getPriceAsyncFuture("store 2");
        Future<Double> priceAsyncFuture3 = storeService.getPriceAsyncFuture("store 3");
        Future<Double> priceAsyncFuture4 = storeService.getPriceAsyncFuture("store 4");
        try {
            System.out.println(priceAsyncFuture1.get());
            System.out.println(priceAsyncFuture2.get());
            System.out.println(priceAsyncFuture3.get());
            System.out.println(priceAsyncFuture4.get());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }


        long end = System.currentTimeMillis();

        System.out.printf("Time passed to searchPriceSync %dms%n", (end - start));
        StoreService.shutdown();
    }

    private static void searchPriceAsyncCompletableFuture(StoreService storeService) {
        long start = System.currentTimeMillis();
        CompletableFuture<Double> priceAsyncCompletaFuture1 = storeService.getPriceAsyncCompletaFuture("store 1");
        CompletableFuture<Double> priceAsyncCompletaFuture2 = storeService.getPriceAsyncCompletaFuture("store 2");
        CompletableFuture<Double> priceAsyncCompletaFuture3 = storeService.getPriceAsyncCompletaFuture("store 3");
        CompletableFuture<Double> priceAsyncCompletaFuture4 = storeService.getPriceAsyncCompletaFuture("store 4");
        try {
            System.out.println(priceAsyncCompletaFuture1.get());
            System.out.println(priceAsyncCompletaFuture2.get());
            System.out.println(priceAsyncCompletaFuture3.get());
            System.out.println(priceAsyncCompletaFuture4.get());

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }


        long end = System.currentTimeMillis();

        System.out.printf("Time passed to searchPriceSync %dms%n", (end - start));

    }
}
