package academy.devdojo.maratonajava.javacore.ZZHpadroesdeprojetos.test;

import academy.devdojo.maratonajava.javacore.ZZHpadroesdeprojetos.dominio.Person;

public class BuilderPatternTest01 {
    static void main(String[] args) {
        Person builder = new Person.PersonBuilder()
                .firstName("William")
                .lastName("Suane")
                .userName("viradonojiraya")
                .email("william.suane@devdojo.academy")
                .build();

        System.out.printf(builder.toString());
    }
}
