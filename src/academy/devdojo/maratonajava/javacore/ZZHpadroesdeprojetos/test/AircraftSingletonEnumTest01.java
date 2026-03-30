package academy.devdojo.maratonajava.javacore.ZZHpadroesdeprojetos.test;

import academy.devdojo.maratonajava.javacore.ZZHpadroesdeprojetos.dominio.AircraftSimgletonEnum;
import academy.devdojo.maratonajava.javacore.ZZHpadroesdeprojetos.dominio.AircraftSingletonLazy;

public class AircraftSingletonEnumTest01 {
    static void main(String[] args) {

        bookSeat("1A");
        bookSeat("1A");
    }

    private static void bookSeat(String seat) {
        System.out.println(AircraftSimgletonEnum.INSTANCE.hashCode());
        AircraftSimgletonEnum instance = AircraftSimgletonEnum.INSTANCE;
        System.out.println(instance.bookSeat(seat));
    }
}
