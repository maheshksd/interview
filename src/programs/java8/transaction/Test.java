package programs.java8.transaction;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;

public class Test {
    public static void main(String[] args)
    {
        Trader mario = new Trader("Mario","Milan");
        Trader alan = new Trader("Alan","Cambridge");
        Trader brian = new Trader("Brian","Cambridge");
        Trader raoul = new Trader("Raoul","Perla");
        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );

        //Find all transactions in 2011 and sort by value (small to high)
        transactions.stream().filter(t->t.getYear() == 2011)
                .sorted(Comparator.comparing(Transaction::getValue))
        .collect(Collectors.toList());

        //Unique cities
        transactions.stream().map(t->t.getTrader().getCity()).distinct();
        //or
        transactions.stream().map(t->t.getTrader().getCity()).collect(Collectors.toSet());

        //Find all traders from Cambridge and sort them by name
        transactions.stream()
                .map(t -> t.getTrader())
                .filter(tr->tr.getCity().equalsIgnoreCase("Cambridge"))
                .distinct()
                .map(tr->tr.getName())
                .sorted();

        //Return a string of all traders’ names sorted alphabetically
        transactions.stream()
                .map(t -> t.getTrader())
                .filter(tr->tr.getCity().equalsIgnoreCase("Cambridge"))
                .distinct()
                .map(tr->tr.getName())
                .sorted().reduce("",(a,b)->a+b);
        //Note that this solution isn’t very efficient (all Strings are repeatedly concatenated, which creates
        //a new String object at each iteration) so use joining

        //joining
        String traderStr =
                transactions.stream()
                        .map(transaction -> transaction.getTrader().getName())
                        .distinct()
                        .sorted()
                        .collect(joining());

        //Are any traders based in Milan
        transactions.stream().anyMatch(tr->tr.getTrader().getCity().equalsIgnoreCase("Milan"));

        //Print all transactions’ values from the traders living in Cambridge
        transactions.stream().filter(tr->"Cambridge".equalsIgnoreCase(tr.getTrader().getCity()))
                .map(Transaction::getValue).forEach(System.out::print);

        //What’s the highest value of all the transactions
        Optional<Transaction> val=transactions.stream().max(Comparator.comparing(Transaction::getValue));
        System.out.println("MAx val: "+val.get().getValue());
        //or
        Optional<Integer> val2=transactions.stream().map(Transaction::getValue).reduce(Integer::max);
        System.out.println("MAx val2: "+val.get().getValue());

        //Find the transaction with the smallest value
        Optional<Transaction> val3 = transactions
                .stream().reduce((a,b)->a.getValue()<b.getValue()?a:b);
        System.out.println("MAx val: "+val3.get().getValue());

        //Sum of all tranactions using int stream
        int sum = transactions.stream().mapToInt(Transaction::getValue).sum();
        System.out.println("sum : "+sum);

        //Smallest using stream - OptionalInt bcz 0 is wrong value for min/max
        OptionalInt min = transactions.stream().mapToInt(Transaction::getValue).min();
        System.out.println("min : "+min);

        //IntStream to General stream
        IntStream intStream = transactions.stream().mapToInt(Transaction::getValue);
        Stream<Integer> integerStream = intStream.boxed();

    }
}
