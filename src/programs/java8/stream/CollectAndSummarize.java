package programs.java8.stream;

import java.util.*;

import static java.util.stream.Collectors.*;

public class CollectAndSummarize {
    public static void main(String[] args)
    {
        //Example-1
      List<Dish> menu = Arrays.asList(new Dish(10),new Dish(11));
        Comparator<Dish> dishCaloriesComparator =
                Comparator.comparingInt(Dish::getCalories);
        Optional<Dish> mostCalorieDish =
                menu.stream()
                        .collect(maxBy(dishCaloriesComparator));
        System.out.println(mostCalorieDish);

        //Example-2
        int totalCalories = menu.stream().collect(summingInt(Dish::getCalories));

        //Example-3
        double avgCalories =
                menu.stream().collect(averagingInt(Dish::getCalories));

        IntSummaryStatistics menuStatistics =
                menu.stream().collect(summarizingInt(Dish::getCalories));
        // IntSummaryStatistics{count=9, sum=4300, min=120,
        //       average=477.777778, max=800}

        //Example-3
        String shortMenu1 = menu.stream().map(Dish::getName).collect(joining());

        //Example-3
        String shortMenu2 = menu.stream().map(Dish::getName).collect(joining(", "));

        //Example-3
        int totalCalories1 = menu.stream().collect(reducing(
                0, Dish::getCalories, (i, j) -> i + j));

        //Example-6
    }
}
