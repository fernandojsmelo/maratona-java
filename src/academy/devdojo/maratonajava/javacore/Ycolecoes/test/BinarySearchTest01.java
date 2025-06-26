package academy.devdojo.maratonajava.javacore.Ycolecoes.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BinarySearchTest01 {
    public static void main(String[] args) {
        List<Integer> numero = new ArrayList<>();

        numero.add(2);
        numero.add(0);
        numero.add(4);
        numero.add(3);

        // (-(ponto de inserção)-1)
        // index 0,1,2,3
        // value 0,2,3,4

        Collections.sort(numero);
        System.out.printf(String.valueOf(Collections.binarySearch(numero,0)));
        System.out.printf(String.valueOf(Collections.binarySearch(numero,-1)));
    }
}
