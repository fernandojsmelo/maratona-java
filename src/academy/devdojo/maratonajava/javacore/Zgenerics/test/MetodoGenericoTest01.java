package academy.devdojo.maratonajava.javacore.Zgenerics.test;

import academy.devdojo.maratonajava.javacore.Zgenerics.dominio.Barco;

import java.util.Comparator;
import java.util.List;

public class MetodoGenericoTest01 {
    public static void main(String[] args) {
        criarArryaComUmObjeto(new Barco("Canoa Marota"));

    }

    private static <T> void criarArryaComUmObjeto(T t){
        List<T> list = List.of(t);
        System.out.println(list);
    }

//    private static <T extends Comparator<T>> List<T> criarArryaComUmObjeto(T t){
//        return List.of(t);
//    }
}
