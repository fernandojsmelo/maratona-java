package academy.devdojo.maratonajava.introducao;

public class Aula06EstruturasDeRepedicao04 {

    // Dado o valor de um carro, descubra em quantas ele pode ser parcelado
    // Condição valorParcela >= 1000

    public static void main(String[] args) {
        double valorTotal = 30000;
        for (int parcela = 0; parcela <= valorTotal ; parcela++) {
            double valorParcela = valorTotal / parcela;
//            if (valorParcela >= 1000){
//                System.out.println("Parcela " + parcela + " R$ " + valorParcela);
//            }else {
//                break;
//            }
            if (valorParcela < 1000) {
                break;
            }
            System.out.println("Parcela " + parcela + " R$ " + valorParcela);
        }
    }
}
