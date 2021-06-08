package programs.java8.lamda;

public class LambdaExample {

    public static void main(String[] args)
    {
        //Example=1
        emptyLambda((()->{System.out.println("Hel");}));

        //Example=2
        emptyLambda((()->{}));

    }


    public static void emptyLambda(Runnable arr)
    {
        arr.run();
    }
}
