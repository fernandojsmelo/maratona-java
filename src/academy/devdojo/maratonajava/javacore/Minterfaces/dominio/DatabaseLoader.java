package academy.devdojo.maratonajava.javacore.Minterfaces.dominio;

public class DatabaseLoader implements DataLoader, DataRemover{
    // private -> default -> protected -> public
    @Override
    public void Load() {
        System.out.println("Carregando dados do banco de dados");
    }

    @Override
    public void remove() {
        System.out.println("Removendo dados do banco de dados");
    }

    @Override
    public void checkPermission() {
        System.out.println("Checando permissões no banco de dados");
    }

    public static void retieveMaxDataSize(){
        System.out.println("Dentro do retieveMaxDataSize na classe DatabaseLoader");
    }
}
