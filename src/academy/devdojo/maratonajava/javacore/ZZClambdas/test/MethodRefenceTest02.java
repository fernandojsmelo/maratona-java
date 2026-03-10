package academy.devdojo.maratonajava.javacore.ZZClambdas.test;

import academy.devdojo.maratonajava.javacore.ZZClambdas.dominio.Anime;
import academy.devdojo.maratonajava.javacore.ZZClambdas.service.AnimeComparators;

import java.util.ArrayList;
import java.util.List;

public class MethodRefenceTest02 {
    //Reference to on instance method of a particular object
    static void main() {
        AnimeComparators animeComparators = new AnimeComparators();
        List<Anime> animeList = new ArrayList<>(List.of(
                new Anime("Berserk",43),
                new Anime("One Piece",900),
                new Anime("Naruto",500)
        ));
        animeList.sort(animeComparators::compareByEpisodesnoStatic);
        System.out.println(animeList);
    }

}
