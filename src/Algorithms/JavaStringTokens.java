package Algorithms;

import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JavaStringTokens
{
    public static void main(String[] args)
    {
        //Scanner scan = new Scanner(System.in);
        String str = "Hello, thanks for attempting this problem! Hope it will help you to learn java! Good luck and have a nice day!";
        String regex = "[ ,?._'@!]+";
        StringTokenizer multiTokenizer = new StringTokenizer(str,regex);
        System.out.println(multiTokenizer.countTokens());
        while (multiTokenizer.hasMoreTokens())
        {
            System.out.println(multiTokenizer.nextToken());
        }
        System.out.println(str.length());
    }
}
