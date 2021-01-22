package Algorithms;

import java.util.ArrayList;
import java.util.Scanner;

public class JavaArraylist
{
    public static void Solution2()
    {
        int howManyElements=3;
        Scanner in = new Scanner(System.in);
        int howManyArry=in.nextInt();
        ArrayList<Integer> myNumbers[] = new ArrayList[howManyArry];

        for(int i=0; i<howManyArry;i++)
        {
         myNumbers[i]=new ArrayList<>();
        }
        for (int i=0;i<howManyArry;i++)
        {
            myNumbers[i].add(in.nextInt());
            for (int j=0;j<myNumbers[i].get(0);j++)
            {
                myNumbers[i].add(in.nextInt());
            }
        }
       /* for (int j=0;j<howManyArry;j++)
        {
            for (int i : myNumbers[j])
            {
                System.out.print(i+ " ");
            }
            System.out.println("\n");
        }*/
        /*quart*/

        int quarynumber=in.nextInt();
        ArrayList<Integer> quarys[] = new ArrayList[quarynumber];
        for(int i=0; i<quarynumber;i++)
        {
            quarys[i]=new ArrayList<>();
        }
        for (int i=0;i<quarynumber;i++)
        {
            for (int j=0;j<2;j++)
            {
                quarys[i].add(in.nextInt());
            }
        }
      /*  for (int j=0;j<quarynumber;j++)
        {
            for (int i : quarys[j])
            {
                System.out.print(i+ " ");
            }
            System.out.println("\n");
        }*/

        /*Analyze*/
        for (int i=0;i<quarynumber;i++)
        {
                    if (quarys[i].get(0) <= howManyArry && quarys[i].get(1)<=myNumbers[quarys[i].get(0)-1].get(0))
                    {
                        System.out.println(myNumbers[quarys[i].get(0) - 1].get(quarys[i].get(1)));
                    }
                    else
                    {
                        System.out.println("Error!");
                    }
        }
    }
    public static void main(String[] args)
    {
        Solution2();
    }
}
