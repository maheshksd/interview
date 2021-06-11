package programs.java8.stream;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

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

        //Example-5 Make pair -> 1,3 1,4 etc.
        List<Integer> numbers1 = Arrays.asList(1, 2, 3);
        List<Integer> numbers2 = Arrays.asList(3, 4);
        List<int[]> pairs1 =
                numbers1.stream()
                        .flatMap(i -> numbers2.stream()
                                .map(j -> new int[]{i, j})
                        )
                        .collect(toList());
        System.out.println(pairs1);

        //Example-6 pair with sum divisible by 3
        List<Integer> numbers3 = Arrays.asList(1, 2, 3);
        List<Integer> numbers4 = Arrays.asList(3, 4);
        List<int[]> pairs2 =
                numbers3.stream()
                        .flatMap(i -> numbers4.stream().filter(j->(i+j)%3==0)
                                .map(j -> new int[]{i, j})
                        )
                        .collect(toList());
        System.out.println(pairs2);

    }
}
