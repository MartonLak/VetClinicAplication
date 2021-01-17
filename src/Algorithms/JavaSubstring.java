package Algorithms;

import java.util.Calendar;
import java.util.Scanner;

public class JavaSubstring
{
  public static void subString(String s, Integer first, Integer second) {

      char[] ch = new char[s.length() + 1];
      char[] chSub = new char[s.length() + 1];
      String finalSub = new String();

      for (int i = first; i <second; i++)
      {
          ch[i] = s.charAt(i);
          finalSub = finalSub+Character.toString(ch[i]);
      }
      System.out.println(finalSub);
  }
      public static void main (String[]args)
      {

          Scanner in = new Scanner(System.in);
          String S = in.next();
          //int start = in.nextInt();
          //int second = in.nextInt();
        //     JavaSubstring test1 = new JavaSubstring();

          subString("helloworld",3,7);
      }
  }
