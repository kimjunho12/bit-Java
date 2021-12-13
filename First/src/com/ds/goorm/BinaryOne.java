package com.ds.goorm;

import java.util.Scanner;

public class BinaryOne {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();   sc.close();
        String binN = Integer.toBinaryString(n);

        int result = 0;
        for (char c : binN.toCharArray()){
            if (c == '1')
                result++;
        }
        System.out.println(result);

    }
    
}
