package programs.java8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FunctionExample {
    public static void main(String[] args)
    {
        //Example-1
        List<String> names = Arrays.asList("Smith", "Gourav", "Heather", "John", "Catania");
        Function<String, Integer> nameMappingFunction = String::length;
        List<Integer> nameLength = names.stream().map(nameMappingFunction).collect(Collectors.toList());
        System.out.println(nameLength);

        //Example-2
        Function<Integer,Integer> f = x->x+1;
        Function<Integer,Integer> g = x->x*2;
        Function<Integer,Integer> h = f.andThen(g);
        System.out.println(h.apply(10)); //g(f(x))

        Function<Integer,Integer> I = f.compose(g);
        System.out.println(I.apply(10)); //f(g(x))



    }
}
