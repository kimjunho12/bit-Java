package com.ds.practice.memoryapp;

public class MyQueue<T> extends Memory<T> {
    
    public MyQueue(){

    }

    public MyQueue(int maxSize, T[] arr){
        super(maxSize, arr);
        this.last = 0;
    }

    @Override
    protected boolean isEmpty() {
        return last == 0 ? true : false;
    }

    @Override
    protected T pop() {
        if (!isEmpty() && last >= 0){
            T result = arr[0];
            for (int i = 0; i < last-1; ++i){
                arr[i] = arr[i+1];
            }
            last--;
            return result;
        } else {
            System.out.println("비어있습니다!");
            return null;
        }
    }    
}
