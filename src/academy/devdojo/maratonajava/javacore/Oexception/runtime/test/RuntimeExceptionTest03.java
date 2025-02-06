package academy.devdojo.maratonajava.javacore.Oexception.runtime.test;

public class RuntimeExceptionTest03 {
    public static void main(String[] args) {
        extracted();
        extracted2();
    }

    private static String extracted() {
        try {
            System.out.println("Abrindo o arquivo");
            System.out.println("Escrevendo dados no arquivo");
            return "Conexão aberta";
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            System.out.println("Fechando recurso liberado pelo S.O");
        }
    }

    private static void extracted2() {
        try {
            System.out.println("Abrindo o arquivo");
            System.out.println("Escrevendo dados no arquivo");
            throw new RuntimeException();
        } finally {
            System.out.println("Fechando recurso liberado pelo S.O");
        }
    }
}
