package academy.devdojo.maratonajava.javacore.ZZGconcorrencia.test;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.locks.ReentrantReadWriteLock;

class MapReadWrit {
    private final Map<String, String> map = new LinkedHashMap<>();
    private final ReentrantReadWriteLock rwl;

    public MapReadWrit(ReentrantReadWriteLock rwl) {
        this.rwl = rwl;
    }

    public void put(String key, String value) {
        rwl.writeLock().lock();
        try {
            if (rwl.isWriteLocked()) {
                System.out.printf(
                        "%s Obteve o WRIT lock %n", Thread.currentThread().getName());
            }
            map.put(key, value);
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            rwl.writeLock().unlock();
        }
    }

    public Set<String> allKeys() {
        rwl.readLock().lock();
        try {
            return map.keySet();
        } finally {
            rwl.readLock().unlock();
        }
    }
}

public class ReentrantReadWritLokcTest01 {
    static void main(String[] args) {
        ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();
        MapReadWrit mapReadWrit = new MapReadWrit(rwl);

        Runnable writ = () -> {
            for (int i = 0; i < 20; i++) {
                mapReadWrit.put(String.valueOf(i), String.valueOf(i));
            }
        };

        Runnable reader = () -> {
            if (rwl.isWriteLocked()) {
                System.out.println("WRITE LOCK!");
            }
            rwl.readLock().lock();
            System.out.println("FINALLY I GOT THE DAMN LOCK");
            try {
                System.out.println(
                        Thread.currentThread().getName() + " " + mapReadWrit.allKeys());
            } finally {
                rwl.readLock().unlock();
            }
        };

        Thread t1 = new Thread(writ);
        Thread t2 = new Thread(reader);
        Thread t3 = new Thread(reader);

        t1.start();
        t2.start();
        t3.start();
    }
}
