package academy.devdojo.maratonajava.javacore.Rdatas.test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;

public class LocalDateTimeTest01 {
    public static void main(String[] args) {
        LocalDateTime localDateTime = LocalDateTime.now();
        LocalDate date = LocalDate.of(2022, Month.AUGUST, 6);
        LocalDate date2 = LocalDate.parse("2022-08-06");
        LocalTime time = LocalTime.of(9, 45, 21);
        LocalTime time2 = LocalTime.parse("09:45:21");

        System.out.println(localDateTime);
        System.out.println(date);
        System.out.println(date2);
        System.out.println(time);
        System.out.println(time2);

        LocalDateTime ldt1 = date.atTime(time);
        LocalDateTime ldt2 = time.atDate(date);
        System.out.println(ldt1);
        System.out.println(ldt2);
    }
}
