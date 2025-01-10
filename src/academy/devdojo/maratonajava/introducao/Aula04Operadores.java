package academy.devdojo.maratonajava.introducao;

public class Aula04Operadores {
    public static void main(String[] args) {

        // % resto da divisão
        int resto = 21 % 7;
        System.out.println(resto);

        // < menor quer, > maior quer, <= menor igual, > maior igual, == igual, != diferente
        boolean isDezMaiorQueVinte = 10 >= 20;
        boolean isDezMenorQueVinte = 10 <= 20;
        boolean isDezIgualQueVinte = 10 == 20;
        boolean isDezIgualQueDez = 10 == 10.0;
        boolean isDezDiferenteQueDez = 10 != 10.0;

        System.out.println("isDezMaiorQueVinte "+ isDezMaiorQueVinte);
        System.out.println("isDezMenorQueVinte "+ isDezMenorQueVinte);
        System.out.println("isDezIgualQueVinte "+ isDezIgualQueVinte);
        System.out.println("isDezIgualQueDez "+ isDezIgualQueDez);
        System.out.println("isDezDiferenteQueDez "+ isDezDiferenteQueDez);

        // && (AND), || (OR), ! (DIFERENTE)
        int idade = 29;
        float salario = 3500F;
        boolean isDentroDaLeiMaiorQueTrinta = idade >= 30 && salario >= 4612;
        boolean isDentroDaLeiMenorQueTrinta = idade < 30 && salario >= 3381;

        System.out.println("isDentroDaLeiMaiorQueTrinta "+ isDentroDaLeiMaiorQueTrinta);
        System.out.println("isDentroDaLeiMenorQueTrinta "+ isDentroDaLeiMenorQueTrinta);

        double valorTotalContaCorrente = 200;
        double valorTotalContaPoupanca = 10000;
        float valorPlaystation = 5000;

        boolean isPlaystationCincoCompravel = valorTotalContaCorrente >= valorPlaystation || valorTotalContaPoupanca >= valorPlaystation;

        System.out.println("isPlaystationCincoCompravel "+ isPlaystationCincoCompravel);

        // = += -= *= /= %=

        double bonus = 1800;
        bonus += 1000;
        bonus -= 1000;
        bonus *= 2;
        bonus /= 2;
        bonus %= 2;

        System.out.println(" bonus " + bonus);

        // ++ --
        int contator = 0;
        contator += 1; // contator = contator + 1;
        contator++;
        contator--;
        ++contator;
        --contator;

        int contator2 = 0;

        System.out.println(contator);
        System.out.println(++contator2);
    }
}
