package academy.devdojo.maratonajava.javacore.ZZEstreams.test;

import academy.devdojo.maratonajava.javacore.ZZEstreams.dominio.Cataegory;
import academy.devdojo.maratonajava.javacore.ZZEstreams.dominio.LightNovel;
import academy.devdojo.maratonajava.javacore.ZZEstreams.dominio.Promtion;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamTest14 {
    private static List<LightNovel> lightNovels = new ArrayList<>(List.of(
            new LightNovel("Tensei Shittara", 8.99, Cataegory.FANTASY),
            new LightNovel("Overlord", 10.99, Cataegory.FANTASY),
            new LightNovel("Violet Evergarden", 5.99, Cataegory.DRAMA),
            new LightNovel("No Game no Life", 2.99, Cataegory.FANTASY),
            new LightNovel("Fullmetal Alchemist", 5.99, Cataegory.FANTASY),
            new LightNovel("Kumo Desuga", 1.99, Cataegory.FANTASY),
            new LightNovel("Kumo Desuga", 1.99, Cataegory.FANTASY),
            new LightNovel("Monogatari", 4.00, Cataegory.ROMACE)
    ));

    static void main(String[] args) {
        Map<Cataegory, Long> collect = lightNovels
                .stream()
                .collect(
                        Collectors
                                .groupingBy(
                                        LightNovel::getCataegory,
                                        Collectors.counting()
                                )
                );
        System.out.println(collect);

        Map<Cataegory, Optional<LightNovel>> collect1 = lightNovels
                .stream()
                .collect(
                        Collectors.groupingBy(
                                LightNovel::getCataegory,
                                Collectors.maxBy(
                                        Comparator.comparing(LightNovel::getPrice)
                                )
                        )
                );
        System.out.println(collect1);

        Map<Cataegory, LightNovel> collect2 = lightNovels
                .stream()
                .collect(Collectors.groupingBy(LightNovel::getCataegory,
                        Collectors.collectingAndThen(
                                Collectors.maxBy(
                                        Comparator.comparing(
                                                LightNovel::getPrice
                                        )
                                ), Optional::get
                        )
                ));
        System.out.println(collect2);

        Map<Cataegory, LightNovel> collect3 = lightNovels
                .stream()
                .collect(Collectors.toMap(
                        LightNovel::getCataegory,
                        Function.identity(),
                        BinaryOperator.maxBy(Comparator.comparing(
                        LightNovel::getPrice
                ))));
        System.out.println(collect3);
    }
}
