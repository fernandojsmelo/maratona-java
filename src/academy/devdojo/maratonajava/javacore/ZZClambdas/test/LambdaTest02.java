package academy.devdojo.maratonajava.javacore.ZZClambdas.test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class LambdaTest02 {
    static void main() {
        List<String> strings = List.of("Natsu", "Allucard");
        List<Integer> integers = map(strings, (String::length));
        List<String> map = map(strings, s -> s.toUpperCase());
        System.out.println(integers);
        System.out.println(map);
    }

    private static <T, R> List<R> map(List<T> list, Function<T, R> function){
        List<R> reult = new ArrayList<>();
        for (T e : list){
            R r = function.apply(e);
            reult.add(r);
        }
        return reult;
    }
}
