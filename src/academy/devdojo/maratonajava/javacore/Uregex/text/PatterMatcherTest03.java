package academy.devdojo.maratonajava.javacore.Uregex.text;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatterMatcherTest03 {
    public static void main(String[] args) {
        // \d = Todos os digitos,
        // \D = Tudo o que não for digito
        // \s = Espaços em branco \t \n \f \r
        // \S = Todos os caracters excluindo os brancos
        // \w = a-zA-Z, digitos, _
        // \W = Tudo o que não for incluso no \w
        // [] = renger

        // String regex = "\\d";
        //String regex = "\\D";
        //String regex = "\\s";
        //String regex = "\\S";
        //String regex = "\\w";
        //String regex = "[a-zA-C]";
        String regex = "0[xX][0-9a-fA-F]";

        //String texto = "abaaba";
        String texto2 = "12 0x 0X 0xFFABC 0x109 0x1";
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
