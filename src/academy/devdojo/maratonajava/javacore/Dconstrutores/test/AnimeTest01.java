package academy.devdojo.maratonajava.javacore.Dconstrutores.test;

import academy.devdojo.maratonajava.javacore.Dconstrutores.dominio.Anime;

public class AnimeTest01 {
    public static void main(String[] args) {
        Anime anime = new Anime("Hikyuu", "TV", 12,"Ação");

        Anime anime2 = new Anime();

        anime.impreme();
        anime2.impreme();
    }
}
