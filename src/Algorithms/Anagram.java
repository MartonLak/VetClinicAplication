package Algorithms;

import java.util.Arrays;
import java.util.Scanner;

public class Anagram {

    public static void sortArray(char[] a)
    {
        int n = a.length;
        char temp = 0;
        for(int i=0; i < n; i++){
            for(int j=1; j < (n-i); j++){
                if(a[j-1] > a[j]){
                    //swap elements
                    temp = a[j-1];
                    a[j-1] = a[j];
                    a[j] = temp;
                }

            }
        }

    }
    public static boolean isAnagram(String a, String b)
    {
        char[] ch1 = new char[a.length()];
        char[] ch2 = new char[b.length()];
        char[] ch3 = new char[a.length()];
        char[] ch4 = new char[a.length()];
        int counter =0;
        for (int i =0; i<a.length();i++)
        {
            ch1[i]=a.charAt(i);
        }
        for (int i =0; i<b.length();i++)
        {
            ch2[i]=b.charAt(i);
        }
        for (int i =0; i<a.length();i++)
        {
            ch3[i]=Character.toUpperCase(ch1[i]);

        }
        for (int i =0; i<b.length();i++)
        {
            ch4[i]=Character.toUpperCase(ch2[i]);
        }
        sortArray(ch3);
        sortArray(ch4);
        if(a.length()==b.length())
        {
            System.out.println(a.length());
            System.out.println(b.length());
            for (int i = 0; i < a.length(); i++)
            {
                if (ch4[i] != ch3[i]) {
                    counter++;
                }
            }
        }
        if(counter==0 && a.length()==b.length())
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        String a = scan.next();
        String b = scan.next();
        scan.close();
        boolean ret = isAnagram(a, b);
        System.out.println( (ret) ? "Anagrams" : "Not Anagrams" );
    }

}
