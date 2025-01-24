 package academy.devdojo.maratonajava.javacore.Fmodificadorestatico.dominio;

public class Anime {
    private String nome;
    private static int[] episodios;

    // 0 - Bloco de inicialização é execultado quando a JVM carrega classe
    // 1 - Alocado espaço em memória para o objeto
    // 2 - Cada atributo de classe é criado e inicializado com valores default ou o quer for passado
    // 3 - Bloco de inicialização é execultado
    // 4 - Construtor é execultado

    static {
        System.out.println("Dentro do bloco de inicialização estatico 1");
        episodios = new int[100];
        for (int i = 0; i < episodios.length; i++) {
            episodios[i] = i + 1;
        }
    }

    static {
        System.out.println("Dentro do bloco de inicialização estatico  2");

    }

    static {
        System.out.println("Dentro do bloco de inicialização estatico  3");

    }

    {
        System.out.println("Dentro do bloco de inicialização não estatico");

    }

    public Anime(String nome) {
        this.nome = nome;
    }

    public Anime() {
        for(int episodio: episodios){
            System.out.print(episodio + " ");
        }
        System.out.println();
    }

    public String getNome() {
        return nome;
    }

    public int[] getEpisodios() {
        return episodios;
    }
}
