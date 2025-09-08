package academy.devdojo.maratonajava.javacore.ZZBcomportamento.test;

import academy.devdojo.maratonajava.javacore.ZZBcomportamento.dominio.Car;

import java.util.ArrayList;
import java.util.List;

public class ComportamentoPorParamentroTest01 {
    private static List<Car> cars = List.of(
                    new Car("green", 2011),
                    new Car("black", 1998),
                    new Car("red", 2019)
    );

    static void main() {
        System.out.println(filterGreenCar(cars).toString());
        System.out.println(filterCarByColor(cars, "green").toString());
        System.out.println(filterCarByColor(cars, "red").toString());
        System.out.println("----------------------------------------------");
        System.out.println(filterByYearBefore(cars,2015));

    }

    private static List<Car> filterGreenCar(List<Car> cars) {
        List<Car> filteredCar = new ArrayList<>();
        for (Car car : cars) {
            if (car.getColor().equals("green")) {
                filteredCar.add(car);
            }
        }
        return filteredCar;
    }

    private static List<Car> filterCarByColor(List<Car> cars, String cor) {
        List<Car> filteredCar = new ArrayList<>();
        for (Car car : cars) {
            if (car.getColor().equals(cor)) {
                filteredCar.add(car);
            }
        }
        return filteredCar;
    }

    private static List<Car> filterByYearBefore(List<Car> cars, int year) {
        List<Car> filteredCar = new ArrayList<>();
        for (Car car : cars) {
            if (car.getYear() < year) {
                filteredCar.add(car);
            }
        }
        return filteredCar;
    }

}
