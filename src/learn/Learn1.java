package learn;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.List;

public class Learn1 {
    public static void main(String[] args)
    {
        //int array[], n;

        int n = 6;

        int[] array = {1,2,3,4,6};
        List<Integer> sdfd = Arrays.asList(array);

        int  sum= (n*(n+1))/2;
        int missingSum = Arrays.stream(array).sum();





        System.out.println(sum - missingSum);

    }
}
