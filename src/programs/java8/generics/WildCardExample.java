package programs.java8.generics;

import java.util.Arrays;
import java.util.List;

public class WildCardExample {

    static int count;

    public static void print(List<? extends Number> list)
    {
        for (Number n : list)
            System.out.print(n + " ");
        System.out.println();
    }

    public static <T> void print2(List<T> list)
    {
        for (T n : list)
            System.out.print(n + " ");
        System.out.println();
    }

    public static void main(String[] args)
    {
        WildCardExample example = new WildCardExample();
        List<Cat> catList = Arrays.asList(example.getCat(), example.getCat());
        print2(catList);
    }



    Cat getCat()
    {
        return new Cat();
    }

    class Cat {
        String getCatName()
        {
            return "Black:" + count++;
        }
    }


}

