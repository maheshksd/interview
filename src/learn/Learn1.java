package learn;

import javax.swing.*;

public class Learn1 {
    public static void main(String[] args)
    {
        String s="abcde";
        int index = s.indexOf('c');
        System.out.println(index);
        System.out.println(s.substring(0,index));
        System.out.println(s.substring(index+1,s.length()));
    }
}
