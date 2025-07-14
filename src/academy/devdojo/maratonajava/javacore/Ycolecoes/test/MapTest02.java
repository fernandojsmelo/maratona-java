package academy.devdojo.maratonajava.javacore.Ycolecoes.test;

import academy.devdojo.maratonajava.javacore.Ycolecoes.dominio.Consunidor;
import academy.devdojo.maratonajava.javacore.Ycolecoes.dominio.Manga;

import java.util.HashMap;
import java.util.Map;

public class MapTest02 {
    public static void main(String[] args) {
        Consunidor consunidor1 = new Consunidor("Willian Suane");
        Consunidor consunidor2 = new Consunidor("Devojo Academy");

        Manga manga1 = new Manga(5L,"Attack on Titan", 19.9);
        Manga manga2 = new Manga(1L,"Bersek", 9.5);
        Manga manga3 = new Manga(4L,"Hellsing Ultimate", 3.2);
        Manga manga4 = new Manga(3L,"Pokemon",11.20);
        Manga manga5 = new Manga(2L,"Dragon Ball Z",2.99);

        Map<Consunidor, Manga> consunidorManga = new HashMap<>();

        consunidorManga.put(consunidor1, manga1);
        consunidorManga.put(consunidor2, manga4);

        for (Map.Entry<Consunidor, Manga> entry : consunidorManga.entrySet()){
            System.out.println(entry.getKey().getNome() + " - " + entry.getValue().getNome());
        }
    }
}
