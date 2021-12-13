package com.ds.goorm;

import java.util.Scanner;

public class nConversion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();
        int to = sc.nextInt();
        sc.close();

        System.out.println(conv(num, to));
        
    }
    
    private static String conv(int n, int to) {
        StringBuffer sb = new StringBuffer();
        
        while (n > 0){
            if (n % to > 9) 
                sb.append((char)(n % to - 10 + 'A'));
            else
                sb.append(n % to);
            
            n /= to;
        }
        return sb.reverse().toString();
    }
}
