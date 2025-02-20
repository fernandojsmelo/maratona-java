package academy.devdojo.maratonajava.javacore.Tresourcebundle.test;

import java.util.Locale;
import java.util.ResourceBundle;

public class ResourceBundleTest01 {
    public static void main(String[] args) {
        System.out.println(Locale.getDefault());
        ResourceBundle bundle = ResourceBundle.getBundle("messages", new Locale("en", "US"));
        System.out.println(bundle.getString("hello"));
        System.out.println(bundle.getString("good.morning"));

        System.out.println(bundle.getString("hi"));

        bundle = ResourceBundle.getBundle("messages", new Locale("pt", "BR"));
        System.out.println(bundle.getString("hello"));
        System.out.println(bundle.getString("good.morning"));

        // Locale("fr", "CA")
        // messages_fr_CA.properties vai procurar esse arquivo, se não encontrar,
        // messages_fr.properties vai procurar esse arquivo, se não encontrar,
        // messages_pt_BR.properties vai procurar esse arquivo, se não encontrar,
        // messages_pt.properties vai procurar esse arquivo, se não encontrar,
        // messages.properties vai procurar esse arquivo base. O ultimo possivel.
        System.out.println(bundle.getString("hi"));

    }
}
