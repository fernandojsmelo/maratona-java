package academy.devdojo.maratonajava.javacore.Minterfaces.dominio;

public interface DataLoader {
    public abstract void Load();

    public default void checkPermission() {
        System.out.println("Fazendo chegagem de permissões");
    }
}
