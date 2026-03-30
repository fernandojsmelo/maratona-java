package academy.devdojo.maratonajava.javacore.ZZHpadroesdeprojetos.dominio;

import java.util.HashSet;
import java.util.Set;

public class AircraftSingletonEager {

    private static final AircraftSingletonEager INSTANCE =
            new AircraftSingletonEager("787-900");

    private final Set<String> availlableSeats = new HashSet<>();
    private final String  name;

    {
        availlableSeats.add("1A");
        availlableSeats.add("1B");
    }

    public AircraftSingletonEager(String name) {
        this.name = name;
    }

    public static AircraftSingletonEager getINSTANCE() {
        return INSTANCE;
    }

    public boolean bookSeat(String seat){
        return availlableSeats.remove(seat);
    }
}
