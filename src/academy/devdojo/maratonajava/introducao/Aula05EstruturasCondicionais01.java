package academy.devdojo.maratonajava.introducao;

public class Aula05EstruturasCondicionais01 {
    public static void main(String[] args) {
        int idade = 20;
        boolean isAutorizadoComprarBebida = idade >= 18;
        // !

        if (isAutorizadoComprarBebida){
            System.out.println("Autorizado a Comprar Bebida alcólica");
        }else {
            System.out.println("Não Autorizado a Comprar Bebida alcólica");
        }

        if (!isAutorizadoComprarBebida){
            System.out.println("Não Autorizado a Comprar Bebida alcólica");
        }

        boolean c = false;
        if (c == true){
            System.out.println("Dentro de algo que nunca deve ser feito");
        }
        System.out.println("Fora do if");
    }
}
