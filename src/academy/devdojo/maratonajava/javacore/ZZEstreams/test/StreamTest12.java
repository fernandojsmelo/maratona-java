package academy.devdojo.maratonajava.javacore.ZZEstreams.test;

import academy.devdojo.maratonajava.javacore.ZZEstreams.dominio.Cataegory;
import academy.devdojo.maratonajava.javacore.ZZEstreams.dominio.LightNovel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamTest12 {
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
        Map<Cataegory, List<LightNovel>> cataegoryLightNovelMap = new HashMap<>();
        List<LightNovel> fantasy = new ArrayList<>();
        List<LightNovel> drama = new ArrayList<>();
        List<LightNovel> romance = new ArrayList<>();
        for (LightNovel lightNovel : lightNovels) {
            switch (lightNovel.getCataegory()){
                case DRAMA: drama.add(lightNovel); break;
                case FANTASY: fantasy.add(lightNovel); break;
                case ROMACE: drama.add(lightNovel); break;
            }
        }
        cataegoryLightNovelMap.put(Cataegory.DRAMA, drama);
        cataegoryLightNovelMap.put(Cataegory.FANTASY, fantasy);
        cataegoryLightNovelMap.put(Cataegory.ROMACE, romance);
        System.out.println(cataegoryLightNovelMap);

        System.out.println("-----------------------------------------");

        Map<Cataegory, List<LightNovel>> collect = lightNovels
                .stream()
                .collect(Collectors.groupingBy(LightNovel::getCataegory));
        System.out.println(collect);

    }
}
