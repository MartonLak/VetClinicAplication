package Algorithms;

import java.util.Scanner;

public class Java2DArray
{
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args)
    {
        int[][] arr = new int[6][6];
        int sum=0;

       /* for (int i = 0; i < 6; i++) {
            String[] arrRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
            }
        }
        for (int i = 0; i < 6; i++)
        {
            for (int j = 0; j < 6; j++)
            {
                sum=sum+arr[i][j];
            }
        }*/


        sum=Math.max(6,-12);
        System.out.println(sum);
    }




}
