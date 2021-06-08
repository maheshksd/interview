package programs.java8;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Stream;

//It represents a function which does not take in any argument but produces a value of type T
public class SupplierExample {
    private static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    public static void main(String[] args)
    {
        Supplier<Double> randomValue = () -> Math.random();

        // Print the random value using get()
        System.out.println(randomValue.get());

        Map<String, Integer> nameMap = new HashMap<>();
        Integer value = nameMap.computeIfAbsent("John", s -> s.length());
        Integer value2 = nameMap.computeIfAbsent("John", String::length);

        Function<Integer, String> intToString = Object::toString;
        Function<String, String> quote = s -> "'" + s + "'";
        Function<Integer, String> quoteIntToString = quote.compose(intToString);

        //assertEquals("'5'", quoteIntToString.apply(5));

        //BiFunction
        //BiFunction implementation that receives a key and an old value to calculate a new value for the salary and return it
        Map<String, Integer> salaries = new HashMap<>();
        salaries.put("John", 40000);
        salaries.put("Freddy", 30000);
        salaries.put("Samuel", 50000);
        salaries.replaceAll((name, oldValue) -> name.equals("Freddy") ? oldValue : oldValue + 10000);


        Supplier<Integer> randomNumbersSupp=() -> new Random().nextInt(10);
        Stream.generate(randomNumbersSupp).limit(5).forEach(System.out::println);

        Supplier<String> today = () -> dtf.format(LocalDateTime.now());
        System.out.println(today.get());

    }
}
