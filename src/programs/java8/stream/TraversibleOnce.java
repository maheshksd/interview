package programs.java8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class TraversibleOnce {
    public static void main(String[] args)
    {
        List<String> list = Arrays.asList("one", "two", "three");
        Stream<String> stream = list.stream();
        stream.forEach(System.out::println);

        //java.lang.IllegalStateException: stream has already been operated upon or closed
        stream.forEach(System.out::println);
    }
}
