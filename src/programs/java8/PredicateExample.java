package programs.java8;

import java.util.Arrays;
import java.util.List;
import java.util.function.DoublePredicate;
import java.util.function.Predicate;

public class PredicateExample {
    public static void main(String[] args)
    {
        //Example 1
        List<String> names1 = Arrays.asList("John", "Smith", "Samueal", "Catley", "Sie");
        Predicate<String> nameStartsWithS = str -> str.startsWith("S");
        names1.stream().filter(nameStartsWithS).forEach(System.out::println);

        //Composition methods
       /*default Predicate<T> and(Predicate<? super T> other);
        default Predicate<T> or(Predicate<? super T> other);
        static <T> Predicate<T> isEquals(Object targetRef);
        default Predicate<T> negate();*/

        //Example 2
        List<String> names2 = Arrays.asList("John", "Smith", "Samueal", "Catley", "Sie");
        Predicate<String> startPredicate = str -> str.startsWith("S");
        Predicate<String> lengthPredicate = str -> str.length() >= 5;
        names2.stream().filter(startPredicate.and(lengthPredicate)).forEach(System.out::println);

        //Example3
        DoublePredicate db
                = (x) -> { return x * x < 100.0; };
        System.out.println("100 is less than 100 "
                + db.test(10));

    }
}
