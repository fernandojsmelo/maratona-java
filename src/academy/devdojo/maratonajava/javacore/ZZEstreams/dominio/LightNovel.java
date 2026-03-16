package academy.devdojo.maratonajava.javacore.ZZEstreams.dominio;

import java.util.Objects;

public class LightNovel {
    private String title;
    private double price;
    private Cataegory cataegory;

    public LightNovel(String title, double price) {
        this.title = title;
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof LightNovel that)) return false;
        return Objects.equals(title, that.title);
    }

    public LightNovel(String title, double price, Cataegory cataegory) {
        this.title = title;
        this.price = price;
        this.cataegory = cataegory;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(title);
    }

    @Override
    public String toString() {
        return "LightNovel{" +
                "title='" + title + '\'' +
                ", price=" + price +
                ", cataegory=" + cataegory +
                '}';
    }

    public Cataegory getCataegory() {
        return cataegory;
    }

    public String getTitle() {
        return title;
    }

    public double getPrice() {
        return price;
    }
}
