package learn;

import java.util.Scanner;

public class Learn1 {
    public static void main(String[] args)
    {
        Scanner scanner=new Scanner(System.in);

        System.out.println("Enter your first number: ");
        int a  = scanner.nextInt();

        System.out.println("Enter your second number: ");
        int b  = scanner.nextInt();

        int sum= a+b;

        System.out.println("Sum= "+ sum );

    }
}
