package com.ds.practice.test.thread;

public class RunnableEx implements Runnable {
    private int[] arr; 

    public RunnableEx() {
        arr = new int[10];

        for(int i = 0; i < arr.length; ++i) {
            arr[i] = i;
        }
    }

    public void run() {
        for (int i : arr){
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread() + " " + arr[i]);
        }

    }

    public static void main(String[] args) {
        RunnableEx re = new RunnableEx();   // Runable class 생성
        Thread th = new Thread(re);         // Thread를 Runable을 가지고 생성

        th.start();                         // runable 상태                
    }
}
