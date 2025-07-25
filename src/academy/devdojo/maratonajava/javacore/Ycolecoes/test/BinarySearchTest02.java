package academy.devdojo.maratonajava.javacore.Ycolecoes.test;

import academy.devdojo.maratonajava.javacore.Ycolecoes.dominio.Manga;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BinarySearchTest02 {
    public static void main(String[] args) {

        MangaByIdComparator mangaByIdComparator = new MangaByIdComparator();
        List<Manga> mangas = new ArrayList<>(6);
        mangas.add(new Manga(5L,"Attack on Titan", 19.9));
        mangas.add(new Manga(1L,"Bersek", 9.5));
        mangas.add(new Manga(4L,"Hellsing Ultimate", 3.2));
        mangas.add(new Manga(3L,"Pokemon",11.20));
        mangas.add(new Manga(2L,"Dragon Ball Z",2.99));

        //Collections.sort(mangas);
        mangas.sort(mangaByIdComparator);

        for (Manga manga : mangas) {
            System.out.println(manga);
        }

        Manga mangaToSearch = new Manga(2L,"Dragon Ball Z",2.99);

        System.out.printf(String.valueOf(Collections.binarySearch(mangas, mangaToSearch, mangaByIdComparator)));
    }
}
