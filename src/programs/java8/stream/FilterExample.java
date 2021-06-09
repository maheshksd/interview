package programs.java8.stream;

import java.util.Arrays;
import java.util.List;

public class FilterExample {
    public static void main(String[] args)
    {
        //Example-1 distinct
        List<Integer> numbers = Arrays.asList(1, 2, 1, 3, 3, 2, 4);
        numbers.stream()
                .filter(i -> i % 2 == 0)
                .distinct()
                .forEach(System.out::println);

        //Example-2 Limit
        numbers = Arrays.asList(10, 20, 10, 30, 30, 20, 40);
        numbers.stream()
                .limit(3).forEach(System.out::println);

        //Example-3 Skip
        numbers.stream().skip(2).forEach(System.out::println);

        //Example-4 FlatMap
        List<String> list = Arrays.asList("Hello", "World");
        list.stream()
                .map(w->w.split("")) //Stream<String[]>
                .flatMap(Arrays::stream)//Strem<String>
        .distinct().forEach(System.out::print);

    }
}
