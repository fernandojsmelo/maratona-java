package academy.devdojo.maratonajava.javacore.ZZHpadroesdeprojetos.dominio;

import java.util.HashSet;
import java.util.Set;

public class AircraftSingletonLazy {

    private static AircraftSingletonLazy INSTANCE =
            new AircraftSingletonLazy("787-900");

    private final Set<String> availlableSeats = new HashSet<>();
    private final String  name;

    {
        availlableSeats.add("1A");
        availlableSeats.add("1B");
    }

    public AircraftSingletonLazy(String name) {
        this.name = name;
    }

    public static AircraftSingletonLazy getINSTANCE() {
        if (INSTANCE == null){
            synchronized (AircraftSingletonLazy.class) {
                if (INSTANCE == null) {
                    INSTANCE = new AircraftSingletonLazy("787-900");
                }
            }
        }
        return INSTANCE;
    }

    public boolean bookSeat(String seat){
        return availlableSeats.remove(seat);
    }
}
