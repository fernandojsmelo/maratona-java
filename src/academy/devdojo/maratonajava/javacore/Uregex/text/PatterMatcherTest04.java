package academy.devdojo.maratonajava.javacore.Uregex.text;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatterMatcherTest04 {
    public static void main(String[] args) {
        // \d = Todos os digitos,
        // \D = Tudo o que não for digito
        // \s = Espaços em branco \t \n \f \r
        // \S = Todos os caracters excluindo os brancos
        // \w = a-zA-Z, digitos, _
        // \W = Tudo o que não for incluso no \w
        // [] = renger
        // ? Zero ou uma
        // * Zero ou mais
        // + uma ou mais
        // {n,m} de n até m
        // ()
        // |
        // $ = Final de linha

        // String regex = "\\d";
        //String regex = "\\D";
        //String regex = "\\s";
        //String regex = "\\S";
        //String regex = "\\w";
        String regex = "0[xX]([0-9a-fA-F])+(\\s|$)";

        String texto = "12 0x 0X 0xFFABC 0x10G 0x1";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(texto);
        System.out.println("text:    " + texto);
        System.out.println("indici:  0123456789");
        System.out.println("regex " + regex);
        System.out.println("Posições encontradas");
        while (matcher.find()) {
            System.out.print(matcher.start() + " "+matcher.group()+"\n");
        }
    }
}
