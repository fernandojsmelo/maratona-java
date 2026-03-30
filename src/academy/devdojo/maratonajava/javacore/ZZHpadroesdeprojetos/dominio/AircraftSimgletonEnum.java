package academy.devdojo.maratonajava.javacore.ZZHpadroesdeprojetos.dominio;

import java.util.HashSet;
import java.util.Set;

public enum AircraftSimgletonEnum {
    INSTANCE;
    private final Set<String> availableSeats;

    AircraftSimgletonEnum() {
        this.availableSeats = new HashSet<>();
        this.availableSeats.add("1A");
        this.availableSeats.add("1B");
    }

    public boolean bookSeat(String seat) {
        return availableSeats.remove(seat);
    }
}
