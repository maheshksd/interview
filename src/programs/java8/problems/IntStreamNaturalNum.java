package programs.java8.problems;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.IntSupplier;
import java.util.stream.IntStream;

public class IntStreamNaturalNum {
    public static void main(String[] args)
    {
        //Method 1
        IntStream.range(10,11).forEach(System.out::println);

        //Method 2
        IntStream intStream =  IntStream.iterate(-1,a->a+1);
        intStream.limit(12).forEach(System.out::println);

        //Method 3
        IntSupplier generator = new IntSupplier() {
            int current = 0;
            public int getAsInt() {
                return current++;
            }
        };
        IntStream natural = IntStream.generate(generator);

        //Method 4 - Multithreaded
        IntStream natural2 = IntStream.generate(new AtomicInteger()::getAndIncrement);

        //Method 5 - Random
        IntStream.generate(new Random()::nextInt).limit(10).forEach(System.out::println);


    }
}
