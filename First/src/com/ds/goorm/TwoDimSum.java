package com.ds.goorm;

import java.util.Scanner;

public class TwoDimSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][n];

        for (int i = 0; i < arr.length; ++i){
            for (int j = 0; j < arr[i].length; ++ j){
                arr[i][j] = sc.nextInt();
            }
        }
        int xStart, yStart, xEnd, yEnd;
        xStart = sc.nextInt();
        yStart = sc.nextInt();
        xEnd = sc.nextInt();
        yEnd = sc.nextInt();
        sc.close();

        int sum = 0;
        for (int i = xStart; i <= xEnd; ++i){
            for (int j = yStart; j <= yEnd; ++j){
                sum += arr[i][j];
            }
        }
        System.out.println(sum);

    }
}
