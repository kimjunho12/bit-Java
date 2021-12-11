package com.ds.practice.test.personal;

import java.util.Scanner;

public class SortedNum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Input X Number : "); int x = sc.nextInt();
        System.out.print("Input y Number : "); int y = sc.nextInt();
        sc.close();

        int cnt = 0;
        for (int i = x; i <= y; ++i) {
            if(isSorted(i)){
                System.out.printf("%d\t", i);
                cnt++;
            }
        }
        System.out.println("\nCount : " + cnt);

    }

    private static boolean isSorted(int n) {
        boolean r = true;
        char[] strNum = Integer.toString(n).toCharArray();
        for (int i = 0; i < strNum.length - 1; ++i) {
            if (strNum[i] < strNum[i+1]) {
                r = r && true;
            } else
                r = r && false;
        }

        return r;

    }
    
}
