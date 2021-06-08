package programs.java8;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.BiConsumer;

public class BiConsumerExample {
    public static void main(String[] args)
    {
        //Example1
        BiConsumer<Integer, Integer> addTwo = (x, y) -> System.out.println(x + y);
        addTwo.accept(1, 2);

        //Example2
        addTwo(1, 2, (x, y) -> System.out.println(x + y));          // 3
        addTwo("Node", ".js", (x, y) -> System.out.println(x + y)); // Node.js

        //Example3 - forEach accepts bi function
        Map<Integer, String> map = new LinkedHashMap<>();

        map.put(1, "Java");
        map.put(2, "C++");
        map.put(3, "Rust");
        map.put(4, "JavaScript");
        map.put(5, "Go");

        map.forEach((k, v) -> System.out.println(k + ":" + v));

    }

    static <T> void addTwo(T a1, T a2, BiConsumer<T, T> c) {
        c.accept(a1, a2);
    }

}
