package academy.devdojo.maratonajava.javacore.ZZGconcorrencia.test;

import academy.devdojo.maratonajava.javacore.ZZGconcorrencia.service.StoreService;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

public class CompletableFutureTest02 {
    static void main(String[] args) {
        StoreService storeService = new StoreService();
        searchPriceAsyncCompletableFuture(storeService);
    }

    private static void searchPriceAsyncCompletableFuture(StoreService storeService) {
        long start = System.currentTimeMillis();
        List<String> stores = List.of("store 1", "store 2", "store 3", "store 4");

        List<CompletableFuture<Double>> completableFutures = stores.stream()
                .map(storeService::getPriceAsyncCompletaFuture)
                .collect(Collectors.toList());

        List<Double> prices = completableFutures
                .stream()
                .map(CompletableFuture::join)
                .collect(Collectors.toList());

        System.out.println(prices);

        long end = System.currentTimeMillis();

        System.out.printf("Time passed to searchPriceSync %dms%n", (end - start));

    }
}
