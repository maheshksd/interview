package programs.java8.reduce;

import java.awt.*;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class ReduceExample {
    public static void main(String[] args)
    {
        //Example-1
        List<Integer> numbers = Arrays.asList(1,2,3);
        int product = numbers.stream().reduce(1, (a, b) -> a * b);

        //Example-2
        List<Integer> numbers2 = Arrays.asList(1,2,3);
        int product2 = numbers2.stream().reduce(1, Integer::sum);

        //Example-3
        List<Integer> numbers3 = Arrays.asList(1,2,3);
        Optional<Integer> sum = numbers3.stream().reduce((a, b) -> (a + b));

        //Example-4
        Optional<Integer> max = numbers.stream().reduce(Integer::max);

        //Example-5
        Optional<Integer> min = numbers.stream().reduce(Integer::min);

        //Example-6 - Count number of elements
        List<Integer> numbers6 = Arrays.asList(1,2,3,77);
        int count = numbers6.stream().reduce(0,(a,b)->a+1);
        System.out.println(count);

        //Example-7 - Count number of elements
        List<Integer> numbers7 = Arrays.asList(1,2,3,77,99);
        int count7 = numbers7.stream().map(a->1).reduce(0,Integer::sum);
        System.out.println(count7);

        //Example-8 - Count number of elements
        List<Integer> numbers8 = Arrays.asList(1,2,3,77,88);
        long count8 = numbers8.stream().count();

    }
}
