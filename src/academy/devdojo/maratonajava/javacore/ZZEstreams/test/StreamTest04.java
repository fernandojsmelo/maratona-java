package academy.devdojo.maratonajava.javacore.ZZEstreams.test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class StreamTest04 {
    static void main(String[] args) {
        List<List<String>> devDojo = new ArrayList<>();
        List<String> graphicDesigners = List.of
                ("Wildnei Suane", "Catarina Santos", "Sandy Carolina");
        List<String> developes = List.of("Willian", "David", "Harisson");
        List<String> students = List.of
                ("Édipo", "Gustavo Lima", "Gustavo Mendes", "Guilherme");

        devDojo.add(graphicDesigners);
        devDojo.add(developes);
        devDojo.add(students);

        for (List<String> people : devDojo) {
            for (String person : people) {
                System.out.println(person);
            }

        }

        System.out.println("-----------------------------");
        devDojo.stream()
                .flatMap(Collection::stream)
                .forEach(System.out::println);

    }
}
