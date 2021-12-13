package com.ds.goorm;

import java.util.Scanner;

public class Hexagon {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();   sc.close();

        double area = 3*Math.sqrt(3)*Math.pow(n, 2)/2;

        System.out.println(Math.round(area*100)/100.0);
    }
}
