package academy.devdojo.maratonajava.javacore.Uregex.text;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatterMatcherTest02 {
    public static void main(String[] args) {
        // \d = Todos os digitos,
        // \D = Tudo o que não for digito
        // \s = Espaços em branco \t \n \f \r
        // \S = Todos os caracters excluindo os brancos
        // \w = a-zA-Z, digitos, _
        // \W = Tudo o que não for incluso no \w

        // String regex = "\\d";
        //String regex = "\\D";
        //String regex = "\\s";
        //String regex = "\\S";
        //String regex = "\\w";
        String regex = "\\W";

        //String texto = "abaaba";
        String texto2 = "@#hh_j2 12gvh21";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(texto2);
        System.out.println("text:    " + texto2);
        System.out.println("indici:  0123456789");
        System.out.println("regex " + regex);
        System.out.println("Posições encontradas");
        while (matcher.find()) {
            System.out.print(matcher.start() + " "+matcher.group()+"\n");
        }
    }
}
