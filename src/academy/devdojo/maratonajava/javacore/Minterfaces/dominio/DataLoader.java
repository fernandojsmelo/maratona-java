package academy.devdojo.maratonajava.javacore.Minterfaces.dominio;

public interface DataLoader {
    public static final int MAX_DATA_SIZE = 10;

    public abstract void Load();

    public default void checkPermission() {
        System.out.println("Fazendo chegagem de permissões");
    }

    public static void retieveMaxDataSize(){
        System.out.println("Dentro do retieveMaxDataSize na interface");
    }
}
