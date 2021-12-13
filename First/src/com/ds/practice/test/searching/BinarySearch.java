package com.ds.practice.test.searching;

import java.util.Arrays;
import java.util.Scanner;

import com.ds.practice.test.sorting.Sort;

public class BinarySearch {
    private int[] arr;
    private static int cnt = 0;
    public static void main(String[] args) {
        BinarySearch bs = new BinarySearch();    
        Scanner sc = new Scanner(System.in);
        // bs.arr = new int[] {1,2,3,4,5};
        
        System.out.println(Arrays.toString(bs.arr));


        int result = bs.bSearch(0, bs.arr.length - 1, sc.nextInt());    sc.close();
        System.out.println("검색 횟수 : " + cnt + "\t위치 : " + (result != -1 ? result + 1 : "X"));
    }

    public BinarySearch() {
        Sort s = new Sort();
        this.arr = s.getData();
        this.arr = s.quickSort(this.arr, 0, this.arr.length-1);
    }

    private int bSearch(int start, int end, int target) {
        cnt++;
		int mid;
		if(start <= end) {
			mid = (start + end) / 2;
			// 값을 바로 찾았을 경우
			if(target == arr[mid]) {
				return mid;
			} else if(target < arr[mid]) {		// 중앙값보다 작을 경우
				return bSearch(start, mid-1, target);	// 왼쪽에서 탐색
			} else {							// 중앙값보다 클 경우
				return bSearch(mid+1, end, target); 	// 오른쪽에서 탐색
			}
		}
		return -1;
	}
}
