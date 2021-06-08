package programs.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.UnaryOperator;

public class UniaryOperatorExample {
    public static void main(String[] args)
    {
        //Example-1
        UnaryOperator<Integer> func2 = x -> x * 2;
        Integer result2 = func2.apply(2);
        System.out.println(result2);

        //Example-2
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> result = math(list,
                x -> x * 2,
                x -> x + 1);
        System.out.println(result);
    }

    public static <T> List<T> math(List<T> list,
                                   UnaryOperator<T> uo, UnaryOperator<T> uo2) {
        List<T> result = new ArrayList<>();
        for (T t : list) {
            result.add(uo.andThen(uo2).apply(t));
        }
        return result;
    }
}
