package academy.devdojo.maratonajava.javacore.Minterfaces.dominio;

public class FileLoader implements DataLoader{
    @Override
    public void Load() {
        System.out.println("Carrega dados de um arquivo");
    }
}
