package academy.devdojo.maratonajava.javacore.ZZEstreams.test;

import academy.devdojo.maratonajava.javacore.ZZEstreams.dominio.Cataegory;
import academy.devdojo.maratonajava.javacore.ZZEstreams.dominio.LightNovel;
import academy.devdojo.maratonajava.javacore.ZZEstreams.dominio.Promtion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamTest13 {
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
        Map<Promtion, List<LightNovel>> collect = lightNovels
                .stream()
                .collect(Collectors.groupingBy(
                        ln -> ln.getPrice() < 6 ?
                                Promtion.UNDER_PROMOTION : Promtion.NORMAL_PRICE
                ));
        System.out.println(collect);

        // Map(Cataegory, Map<Promtion, List<LightNovel>>>

        Map<Cataegory, Map<Promtion, List<LightNovel>>> collect1 = lightNovels
                .stream().collect(Collectors.groupingBy(LightNovel::getCataegory,
                Collectors.groupingBy(
                        ln -> ln.getPrice() < 6 ?
                                Promtion.UNDER_PROMOTION : Promtion.NORMAL_PRICE
                )));
        System.out.println(collect1);
    }

    private static Promtion getPromotion(LightNovel ln){
        return ln.getPrice() < 6 ? Promtion.UNDER_PROMOTION : Promtion.NORMAL_PRICE;
    }
}
