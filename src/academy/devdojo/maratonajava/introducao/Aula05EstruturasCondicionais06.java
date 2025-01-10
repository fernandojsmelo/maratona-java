package academy.devdojo.maratonajava.introducao;

public class Aula05EstruturasCondicionais06 {
    public static void main(String[] args) {
        // Utilizaando switch dados os valores de 1 a 7, imprima se é dia útil ou final de semana
        // Considerndo 1 como Domingo

        byte dia = 1;

        switch (dia) {
            case 1:
            case 7:
                System.out.println("FDS");
                break;
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                System.out.println("Dia Útil");
                break;
            default:
                System.out.println("Opçãp Invalida");
                break;
        }

    }
}
