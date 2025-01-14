package academy.devdojo.maratonajava.introducao;

public class Aula07Arrays02 {
    public static void main(String[] args) {
        // byte, short, int, long float e double o valor é 0
        // char '\u0000' é ' '
        // boolean é false
        // String é null

        String[] nomes = new String[4];

       nomes[0] = "Goku";
       nomes[1] = "Kurosaki";
       nomes[2] = "Luffy";


        for (int i = 0; i < nomes.length; i++) {
            System.out.println(nomes[i]);

        }

        double[] nomesD = new double[3];

        System.out.println(nomesD[0]);
        System.out.println(nomesD[1]);
        System.out.println(nomesD[1]);

        boolean[] nomesB = new boolean[3];

        System.out.println(nomesB[0]);
        System.out.println(nomesB[1]);
        System.out.println(nomesB[1]);
    }

}
