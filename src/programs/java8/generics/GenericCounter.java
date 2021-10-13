package programs.java8.generics;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;

public class GenericCounter {
    public static void main(String[] args)
    {
        new GenericCounter().testThis();
    }

    public void testThis()
    {
        List<Integer> ci = Arrays.asList(1, 2, 3, 4, 5);
        CounterUtil counterUtil = new CounterUtil();
        int count = counterUtil.countIf(ci, t -> t % 2 == 0);
        int count2 = counterUtil.countIf(ci, new OddPredicate());
        System.out.println("Number of odd integers = " + count + " and even " + count2);
    }


    class OddPredicate implements Predicate<Integer> {
        public boolean test(Integer t)
        {
            return t % 2 != 0;
        }
    }

    class CounterUtil {
        public <T> int countIf(Collection<T> ci, Predicate<T> predicate)
        {
            int count = 0;
            for (T ele : ci)
            {
                if (predicate.test(ele))
                    count++;
            }
            return count;
        }

        public <T> long countIf2(Collection<T> ci, Predicate<T> predicate)
        {
           return ci.stream().filter(predicate).count();
        }
    }
}
