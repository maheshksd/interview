package programs.java8.parallelStream;

import java.util.Arrays;
import java.util.List;

public class Example {
    public static void main(String[] args)
    {
        //Example-1
        List<Integer> numbers1 = Arrays.asList(1,2,3,77);
        int sum = numbers1.parallelStream().reduce(0, Integer::sum);
    }
}
