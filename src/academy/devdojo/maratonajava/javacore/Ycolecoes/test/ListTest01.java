package academy.devdojo.maratonajava.javacore.Ycolecoes.test;

import java.util.ArrayList;
import java.util.List;

public class ListTest01 {
    public static void main(String[] args) {
        //List nomes= new ArrayList(); // versão 1.4
        List<String> nomes= new ArrayList<>(16); // versão 1.5
        List<String> nomes2= new ArrayList<>(16); // versão 1.5
        nomes.add("William");
        nomes.add("DevDojo");

        nomes2.add("Suane");
        nomes2.add("Acdemy");

        nomes.addAll(nomes2);

        //nomes.remove(0); // ussando um index
        nomes.remove("william"); // ussando um objeto
        System.out.println(nomes.remove("william")); // ussando um objeto


        for (String nome: nomes){
            System.out.println(nome);
        }

        System.out.println("-----------------------------------");

        nomes.add("Suane");
        for (int i = 0; i < nomes.size(); i++) {
            System.out.println(nomes.get(i));
        }
    }
}
