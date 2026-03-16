package academy.devdojo.maratonajava.javacore.ZZEstreams.test;

import academy.devdojo.maratonajava.javacore.ZZEstreams.dominio.Cataegory;
import academy.devdojo.maratonajava.javacore.ZZEstreams.dominio.LightNovel;
import academy.devdojo.maratonajava.javacore.ZZEstreams.dominio.Promtion;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamTest15 {
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
        Map<Cataegory, DoubleSummaryStatistics> collect = lightNovels
                .stream()
                .collect(
                        Collectors.groupingBy(
                                LightNovel::getCataegory,
                                Collectors.summarizingDouble(LightNovel::getPrice)
                        )
                );
        System.out.println(collect);

        // Map<Category, List<Promotion>>
        Map<Cataegory, Set<Promtion>> collect1 = lightNovels
                .stream()
                .collect(
                        Collectors.groupingBy(
                                LightNovel::getCataegory,
                                Collectors.mapping(StreamTest15::getPromotion,
                                        Collectors.toSet()
                                )
                        )
                );
        System.out.println(collect1);

        Map<Cataegory, LinkedHashSet<Promtion>> collect2 = lightNovels
                .stream()
                .collect(
                        Collectors.groupingBy(
                                LightNovel::getCataegory,
                                Collectors.mapping(StreamTest15::getPromotion,
                                        Collectors.toCollection(LinkedHashSet::new)
                                )
                        )
                );
        System.out.println(collect2);

    }

    private static Promtion getPromotion(LightNovel ln){
        return ln.getPrice() < 6 ? Promtion.UNDER_PROMOTION : Promtion.NORMAL_PRICE;
    }
}
