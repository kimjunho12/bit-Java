package com.ds.practice.test.personal;

import java.util.Arrays;
import java.util.Scanner;

public class BabyGin {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choose;
        
        do {            
            int[] card = shuffleCard();

            Arrays.sort(card);
            
            play(card);
            System.out.print("Play the game again? <1-yes/2-no>: "); choose = sc.nextInt();
        } while (choose != 2);
        sc.close();
    }

    private static int[] shuffleCard() {
        int[] card = new int[6];

        System.out.print("Input 6 Numbers: ");

        for (int i = 0; i < 6; ++i) {
            card[i] = (int) (Math.random() * 9);
            System.out.print(card[i]);
        }
        System.out.println();

        return card;
    }

    private static boolean isRun(int[] arr, int idx) {
        for (int i = idx; i < idx + 2; ++i){
            if (arr[i] + 1 != arr[i+1])
                return false;
        }
        return true;
    }

    private static boolean isTriplete(int[] arr, int idx) {
        for (int i = idx; i < idx + 2; ++i){
            if (arr[i] != arr[i+1])
                return false;
        }
        return true;
    }

    private static boolean isBabyGin(int[] arr) {
        if (isRun(arr, 0) || isTriplete(arr, 0)) {
            if (isRun(arr, 3))
                return true;
            if (isTriplete(arr, 3))
                return true;
        }
        return false;
    }

    private static void play(int[] arr) {
        if (isBabyGin(arr))
            System.out.println("Baby gin !!!");
        else
            System.out.println("Lose");
    }
}
