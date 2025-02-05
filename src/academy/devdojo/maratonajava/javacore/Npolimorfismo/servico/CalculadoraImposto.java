package academy.devdojo.maratonajava.javacore.Npolimorfismo.servico;

import academy.devdojo.maratonajava.javacore.Npolimorfismo.dominio.Produto;
import academy.devdojo.maratonajava.javacore.Npolimorfismo.dominio.Tomate;

public class CalculadoraImposto {
//    public static void calcularImpostoComputador(Computador computador) {
//        System.out.println("Relatório de Imposto do Computador");
//        double imposto = computador.calcularImposto();
//        System.out.println("Computador " + computador.getNome());
//        System.out.println("Valor " + computador.getValor());
//        System.out.println("Imposto " + imposto);
//
//    }
//
//    public static void calcularImpostoTomate(Tomate tomate) {
//        System.out.println("Relatório de Imposto do Computador");
//        double imposto = tomate.calcularImposto();
//        System.out.println("Tomate " + tomate.getNome());
//        System.out.println("Valor " + tomate.getValor());
//        System.out.println("Imposto " + imposto);
//
//    }

    public static void calcularImposto(Produto produto) {
        System.out.println("Relatório de Imposto de Produtos");
        double imposto = produto.calcularImposto();
        System.out.println("Produto : " + produto.getNome());
        System.out.println("Preço : " + produto.getValor());
        System.out.println("Imposto a ser pago : " + imposto);

        if (produto instanceof Tomate) {
            Tomate tomate = (Tomate) produto;
            System.out.println(tomate.getDataValidade());

            String dataValidade = ((Tomate) produto).getDataValidade();
            System.out.println(dataValidade);

        }
    }
}
