package com.ds.practice.test.personal;

import java.util.Iterator;
import java.util.Vector;

public class BabyGin {
    public static void main(String[] args) {
        Vector<Integer> card = new Vector<>();

        for (int i = 0; i < 6; ++i){
            card.add((int) (Math.random()*9));
        }

        card.sort(null);

        System.out.println(card.toString());
        isRun(card);
        
    }

    private static boolean isRun(Vector<Integer> v) {
        boolean leftResult = true;
        boolean rightResult = true;
        char[] arr = v.toString().toCharArray();
        for (int i = 0; i < 2; ++i){
            if (arr[i] + 1 == arr[i+1]){
                leftResult = leftResult && true;
            } else {
                leftResult = leftResult && false;
            }
        }
        for (int i = 3; i < 5; ++i){
            if (arr[i] + 1 == arr[i+1]){
                rightResult = rightResult && true;
            } else {
                rightResult = rightResult && false;
            }
        }

        if (leftResult && rightResult){
            isBabyGin();
        } else if (leftResult) {
            System.out.println("is Left Run");
            // if (leftResult && isTriplete())
                // isBabyGin();
        } else if (rightResult) {
            System.out.println("is Left Run");
            // if (rightResult && isTriplete())
                // isBabyGin();
        } else
            return false;
        return (leftResult || rightResult);
    }
    
    private static boolean isTriplete() {
        
        return false;
    }

    private static boolean isBabyGin() {
        System.out.println("Baby Gin !!!");
        
        
        return false;
    }
}
