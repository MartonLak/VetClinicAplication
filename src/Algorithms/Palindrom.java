package Algorithms;

import java.util.Scanner;

public class Palindrom
{
    public static String Palindrom(String s)
    {
       char ch[] = new char[s.length()];
       char ch2[] = new char[s.length()];
       String a;
       String b;
       int counter =0;
       for(int i=0; i<s.length();i++)
       {
           ch[i]=s.charAt(i);
       }
        for(int i=0; i<s.length();i++)
        {
            ch2[s.length()-i-1]=ch[i];
        }
        for(int i=0; i<s.length();i++)
        {
            if (ch[i]!=ch2[i])
            {
                counter++;
            }
        }
        if (counter==0)
        return "yes";
        else
            return "No";
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String A=sc.next();
        System.out.println(Palindrom(A));
    }
}
