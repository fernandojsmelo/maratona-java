package academy.devdojo.maratonajava.javacore.Zgenerics.test;

import academy.devdojo.maratonajava.javacore.Ycolecoes.dominio.Consunidor;

import java.util.ArrayList;
import java.util.List;

public class GenericsTest01 {
    public static void main(String[] args) {
        // Type erasure
        List<String> lista = new ArrayList<>();
        lista.add("Midoriya");
        lista.add("Midoriya");

        for (String o : lista){
            System.out.println(o);
        }
        add(lista, new Consunidor("Midoriya"));

        for (Object o : lista){
            System.out.println(o);
        }
    }
    private static void add(List lista, Consunidor consunidor){
        lista.add(consunidor);
    }
}
