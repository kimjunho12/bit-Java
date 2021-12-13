package com.ds.goorm;

import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int r = 0;
        for (int i = 1; i <= n; ++i){
            r += fibo(i);
        }
        System.out.println(r);
        sc.close();
    }

    private static int fibo(int n) {
        if (n <= 1){
            return n;
        } else {
            return fibo(n-2) + fibo(n-1);
        }
        
    }
    
}
