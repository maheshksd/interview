package programs.java8.stream.intstream;

import java.util.function.IntSupplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class IntStreamExample {
    public static void main(String[] args)
    {
        //Example-1
        IntStream intStream = IntStream.rangeClosed(1,5).filter(r->r%2==0);
        System.out.println(intStream.count());

        //Example-2
        IntStream.range(1,5)
                .forEach(System.out::print);

        //Example-3
        System.out.println();
        IntStream.rangeClosed(1,5)
                .forEach(System.out::print);

        //Example-4
        System.out.println("============");
        Stream.iterate(0, n -> n + 2)
                .limit(10)
                .forEach(System.out::print);

        //Example-5
        Stream.iterate(new int[]{0, 1},
                t -> new int[]{t[1], t[0]+t[1]})
                .limit(20)
                .forEach(t -> System.out.println("(" + t[0] + "," + t[1] +")"));

        //Example-6
        Stream.generate(Math::random)
                .limit(5)
                .forEach(System.out::println);

        //Example-7
        IntStream twos = IntStream.generate(new IntSupplier(){
            public int getAsInt(){
                return 2;
            }
        });
        twos.forEach(System.out::print);
    }
}
