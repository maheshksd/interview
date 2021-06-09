package programs.java8.lamda.counstructor;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

public class Test {
    private static Map<String,Function<String,Fruit>> appleMap=new HashMap<String,Function<String,Fruit>>();
    public static void main(String[] args)
    {
        //Example-1
        Supplier<Apple> appleSupplier = Apple::new;
        System.out.println(appleSupplier.get().getColor());

        //Example-2
        Function<String,Apple> stringAppleFunction = Apple::new;
        System.out.println(stringAppleFunction.apply("red").getColor());

        //Example-3
        BiFunction<String,Double,Apple> stringDoubleAppleBiFunction = Apple::new;
        System.out.println(stringDoubleAppleBiFunction.apply("red",2.5).getWeight());

        //Example-4
        TriFunction<String,Double,Integer,Apple> triFunction = Apple::new;
        System.out.println(triFunction.apply("red",2.5,250).getPrice());

        //Example-5
        appleMap.put("apple",Apple::new);
        appleMap.put("orange",Orange::new);
        System.out.println(getApple("apple").getClass());
        System.out.println(getApple("orange").getClass());
    }

    private static Fruit getApple(String fruitType){
       return appleMap.get(fruitType).apply(fruitType);
    }
}
