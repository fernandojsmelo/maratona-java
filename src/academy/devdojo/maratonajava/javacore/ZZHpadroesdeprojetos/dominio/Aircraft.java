package academy.devdojo.maratonajava.javacore.ZZHpadroesdeprojetos.dominio;

import java.util.HashSet;
import java.util.Set;

public final class Aircraft {
    private final Set<String> availlableSeats = new HashSet<>();
    private final String  name;

    {
        availlableSeats.add("1A");
        availlableSeats.add("1B");
    }

    public Aircraft(String name) {
        this.name = name;
    }

    public boolean bookSeat(String seat){
        return availlableSeats.remove(seat);
    }
}
