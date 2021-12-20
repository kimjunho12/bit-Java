package com.ds.practice.test;

import java.util.Arrays;
import java.util.Stack;

public class Postfix {
    public static void main(String[] args) {
        String exp = new String("113 + 11 - ( 32 - ( 9 - 2 + 6 ) )");
        String[] tokens = exp.split(" ");
        Stack<String> opStack = new Stack<>();
        System.out.println(Arrays.toString(tokens));

        for (String s : tokens) {
            if (!"()*/%+-".contains(s)){
                System.out.print(s + " ");
            } else if ("(".equals(s)){
                opStack.push(s);
            } else if (")".equals(s)){
                System.out.print(opStack.pop() + " ");
            } else {
                opStack.push(s);
            }
        }
        System.out.println(opStack.toString());
    }
}
