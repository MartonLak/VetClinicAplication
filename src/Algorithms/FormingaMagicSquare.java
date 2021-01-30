package Algorithms;

import java.awt.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class FormingaMagicSquare
{

    static int checkMagic(int[][] s)
    {
        ArrayList<int[][]> options = new ArrayList<>();
        int[][] tmp = new int[][]{{8, 1, 6}, {3, 5, 7}, {4, 9, 2}};
        options.add(tmp);
        tmp = new int[][]{{6, 1, 8}, {7, 5, 3}, {2, 9, 4}};
        options.add(tmp);
        tmp = new int[][]{{8, 1, 6}, {3, 5, 7}, {4, 9, 2}};
        options.add(tmp);
        tmp = new int[][]{{4, 9, 2}, {3, 5, 7}, {8, 1, 6}};
        options.add(tmp);
        tmp = new int[][]{{8, 3, 4}, {1, 5, 9}, {6, 7, 2}};
        options.add(tmp);
        tmp = new int[][]{{4, 3, 8}, {9, 5, 1}, {2, 7, 6}};
        options.add(tmp);
        tmp = new int[][]{{6, 7, 2}, {1, 5, 9}, {8, 3, 4}};
        options.add(tmp);
        tmp = new int[][]{{2, 7, 6}, {9, 5, 1}, {4, 3, 8}};
        options.add(tmp);

        int min = 100;
        int sum = 0;
        int temp =0;
        for (int[][] option : options) {

            for (int i = 0; i <3; i++) {
                for (int j = 0; j < 3; j++) {
                    sum = sum + Math.abs(option[i][j] - s[i][j]);
                }
            }
            sum = Math.abs(sum);
            if(sum<min){
                min = sum;
            }
            sum = 0;
        }
        return min;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args)
    {

        int[][] s = new int[3][3];

        for (int i = 0; i < 3; i++) {

            for (int j = 0; j < 3; j++) {

                s[i][j] = scanner.nextInt();
            }
        }
        System.out.println(checkMagic(s));
    }

}


