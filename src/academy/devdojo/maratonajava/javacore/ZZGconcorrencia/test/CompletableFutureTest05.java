package academy.devdojo.maratonajava.javacore.ZZGconcorrencia.test;

import academy.devdojo.maratonajava.javacore.ZZGconcorrencia.dominio.Quote;
import academy.devdojo.maratonajava.javacore.ZZGconcorrencia.service.StoreServiceWithDiscount;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

public class CompletableFutureTest05 {
    static void main(String[] args) {
        StoreServiceWithDiscount service = new StoreServiceWithDiscount();
        searchPricesWithDiscountAsync(service);
    }

    private static void searchPricesWithDiscountAsync(StoreServiceWithDiscount service){
        long start = System.currentTimeMillis();
        List<String> stores = List.of("store 1", "store 2", "store 3", "store 4");

        CompletableFuture[] completableFutures;
        completableFutures = stores.stream()
                .map(s -> CompletableFuture.supplyAsync(() -> service.getPriceSync(s)))
                .map(cf -> cf.thenApply(Quote::newQuote))
                .map(cf -> cf.thenCompose(
                        quote -> CompletableFuture.supplyAsync(
                                () -> service.applyDiscount(quote))))
                .map(cf -> cf.thenAccept(
                        store -> System.out.printf("%s finished in %d%n", store,
                                (System.currentTimeMillis() - start))))
                .toArray(CompletableFuture[]::new);

        CompletableFuture<Void> voidCompletableFuture = CompletableFuture.allOf(completableFutures);
        voidCompletableFuture.join();
        System.out.printf("Finished? %b%n", voidCompletableFuture.isDone());

        long end = System.currentTimeMillis();
        System.out.printf("Time passed to searchPriceSync %dms%n", (end - start));
    }
}
