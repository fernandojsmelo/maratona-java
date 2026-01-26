package academy.devdojo.maratonajava.javacore.ZZBcomportamento.interfaces;

import academy.devdojo.maratonajava.javacore.ZZBcomportamento.dominio.Car;

@FunctionalInterface
public interface CarPredicate {
    // anonimas, fubcões, conciso
    boolean test(Car car);
    // (paramentro) -> <expressão>
    // (Car car)    -> car.getColor().equals("green")
}
