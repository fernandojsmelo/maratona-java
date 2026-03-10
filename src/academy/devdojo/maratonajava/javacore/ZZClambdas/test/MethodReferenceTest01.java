package academy.devdojo.maratonajava.javacore.ZZClambdas.test;

import academy.devdojo.maratonajava.javacore.ZZClambdas.dominio.Anime;
import academy.devdojo.maratonajava.javacore.ZZClambdas.service.AnimeComparators;

import java.util.ArrayList;
import java.util.List;

// Refence to a static method
public class MethodReferenceTest01 {
    static void main() {
        List<Anime> animeList = new ArrayList<>(List.of(
                new Anime("Berserk",43),
                new Anime("One Piece",900),
                new Anime("Naruto",500)
        ));
        //Collections.sort(animeList, (a1, a2) ->
        //        a1.getTitle().compareTo(a2.getTitle()));
        //animeList.sort( AnimeComparators::compareByTitle);
        animeList.sort( AnimeComparators::compareByEpisodes);
        System.out.println(animeList);
    }

}
