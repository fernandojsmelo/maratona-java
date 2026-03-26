package academy.devdojo.maratonajava.javacore.ZZGconcorrencia.service;

import java.util.concurrent.*;

public class StoreServiceDeprecated {

    public double getPriceSync(String storeNme) {
        System.out.printf("Getting price sync for store %s%n", storeNme);
        return princeGeneretor();
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
