package com.ds.practice.test.thread;

public class ThreadEx extends Thread {
    private int[] arr; 

    public ThreadEx() {
        arr = new int[10];

        for(int i = 0; i < arr.length; ++i) {
            arr[i] = i;
        }
    }

    public void run() {
        for (int i : arr){
            try {
                sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(currentThread() + " " + arr[i]);
        }

    }

    public static void main(String[] args) {
        ThreadEx te = new ThreadEx();   // 쓰레드 생성
        te.start();                     // runable 상태
    }
}
