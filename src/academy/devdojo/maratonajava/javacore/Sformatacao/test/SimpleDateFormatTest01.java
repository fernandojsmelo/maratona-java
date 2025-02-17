package academy.devdojo.maratonajava.javacore.Sformatacao.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SimpleDateFormatTest01 {
    public static void main(String[] args) {
        String pattern = "'Teresina' dd 'de' MMMM 'de' YYYY";
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        System.out.println(sdf.format(new Date()));

        try {
            System.out.println(sdf.parse("Teresina 17 de fevereiro de 2025"));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}
