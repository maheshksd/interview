package programs.java8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class ConsumerExample {
    public static void main(String[] args)
    {
        //Example 1
        Consumer<String> printConsumer1 = t -> System.out.println(t);
        Stream<String> cities1 = Stream.of("Sydney", "Dhaka", "New York", "London");
        cities1.forEach(printConsumer1);

        //Example 2
        List<String> cities2 = Arrays.asList("Sydney", "Dhaka", "New York", "London");
        Consumer<List<String>> upperCaseConsumer = list -> {
            for(int i=0; i< list.size(); i++){
                list.set(i, list.get(i).toUpperCase());
            }
        };
        Consumer<List<String>> printConsumer2 = list -> list.stream().forEach(System.out::println);
        upperCaseConsumer.andThen(printConsumer2).accept(cities2);
    }
}
