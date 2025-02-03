package academy.devdojo.maratonajava.javacore.Minterfaces.dominio;

public class DatabaseLoader implements DataLoader{
    @Override
    public void Load() {
        System.out.println("Carregando dados do banco de dados");
    }
}
