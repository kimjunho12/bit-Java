package com.ds.practice.test.sorting;

import java.util.Arrays;

public class Sort {
    private static int[] data = new int[10000];

    public static void main(String[] args) {

        Sort s = new Sort();

        System.out.println(Arrays.toString(s.bubble(data)));
        System.out.println(Arrays.toString(s.insertion(data)));
        System.out.println(Arrays.toString(s.quickSort(data, 0, data.length - 1)));

    }

    public Sort() {
        for (int i = 0; i < data.length; ++i) {
            data[i] = (int) (Math.random() * 1000) + 1;
        }
    }

    private int[] bubble(int[] arr) {
        for (int i = 0; i < arr.length; ++i) {
            for (int j = 0; j < arr.length - i - 1; ++j) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
        return arr;
    }

    private int[] insertion(int[] arr) {
        for (int i = 1; i < arr.length; ++i) {
            int tmp = arr[i];
            int aux = i - 1;

            while ((aux >= 0) && (arr[aux] > tmp)) {

                arr[aux + 1] = arr[aux];
                aux--;
            }
            arr[aux + 1] = tmp;
        }
        return arr;
    }

    private int[] quickSort(int[] arr, int left, int right) {
        int l, r, mid;
        if (left < right) {
            l = left;
            r = right;
            mid = (l + r) / 2;
            int pivot = arr[mid];
            
            while (l < r) { // l과 r이 교차할 때 까지 진행
                while (pivot < arr[r]) r--;             // pivot 값보다 오른쪽 값이 크다면 (알맞은 상태) 다음 값 조회
                while (l < r && arr[l] <= pivot) l++;   // pivot 값보다 왼쪽 값이 작거나 같다면 (알맞은 상태) 다음 값 조회
                // while 문이 끝나면
                // l은 pivot보다 큰 왼쪽에 있는 수
                // r은 pivot보다 작거나 같은 오른쪽에 있는수
    
                // swap 진행
                int tmp = arr[l];
                arr[l] = arr[r];
                arr[r] = tmp;
            }
            // 분할 정복
            // l이 최종 pivot의 위치
            quickSort(arr, left, l - 1);    // pivot보다 작은쪽(왼쪽) 다시 진행
            quickSort(arr, l + 1, right);   // pivot보다 큰쪽(오른쪽) 다시 진행
        }
        return arr;
    }
}
