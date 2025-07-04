package academy.devdojo.maratonajava.javacore.Ycolecoes.dominio;

import java.util.Objects;

public class Manga implements Comparable<Manga>{
    private Long id;
    private String nome;
    private double preco;
    private int quantidade;

    public Manga(Long id, String nome, double preco) {
        Objects.requireNonNull(id, "Id não pode ser Null");
        Objects.requireNonNull(nome, "Nome não pode ser Null");

        this.id = id;
        this.nome = nome;
        this.preco = preco;
    }

    public Manga(Long id, String nome, double preco, int quantidade) {
        this(id, nome, preco);
        this.quantidade = quantidade;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Manga manga)) return false;
        return Objects.equals(id, manga.id) && Objects.equals(nome, manga.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome);
    }

    @Override
    public String toString() {
        return "Manga{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", preco=" + preco +
                ", quantidade=" + quantidade +
                '}';
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    @Override
    public int compareTo(Manga outroManga) {
        // Retorna negativo se o this < outroManga;
        // se this == outroManga, retorna 0;
        // Retosna posítivo se this > oitroManga

//        if (this.id < outroManga.getId()){
//            return -1;
//        } else if (this.id.equals(outroManga.getId())) {
//            return 0;
//        }else {
//            return 1;
//        }
        return this.nome.compareTo(outroManga.getNome());
//        return Double.compare(preco, outroManga.getPreco());
//        return Double.valueOf(preco).compareTo(outroManga.getPreco());
//        return this.id.compareTo(outroManga.getId());
    }
}
