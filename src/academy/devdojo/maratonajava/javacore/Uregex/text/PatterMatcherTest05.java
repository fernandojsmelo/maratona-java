package academy.devdojo.maratonajava.javacore.Uregex.text;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatterMatcherTest05 {
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
        // . = 1.3 => 123, 133, 1@3, 1A3, ...

        // String regex = "\\d";
        //String regex = "\\D";
        //String regex = "\\s";
        //String regex = "\\S";
        //String regex = "\\w";
        String regex = "([a-zA-Z0-9\\._-])+@([a-zA-Z])+(\\.([a-zA-Z])+)+";

        String texto = "luffy@hotmail.com, 123jotaro@gmail.com, #@!zoro@gmail.br, teste@gmail.com.br, sakura@mail ";
        System.out.println("Email valido");
        System.out.println("#@!zoro@gmail.br".matches(regex));
        System.out.println(texto.split(",")[1].trim());
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(texto);
        System.out.println("texto:    " + texto);
        System.out.println("indici:  0123456789");
        System.out.println("regex " + regex);
        System.out.println("Posições encontradas");
        while (matcher.find()) {
            System.out.print(matcher.start() + " "+matcher.group()+"\n");
        }
    }
}
