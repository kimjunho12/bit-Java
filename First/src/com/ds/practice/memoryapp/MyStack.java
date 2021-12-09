package com.ds.practice.memoryapp;

public class MyStack<T> extends Memory<T> {
    
    public MyStack(){

    }

    public MyStack(int maxSize, T[] arr){
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
            return arr[--last];
        } else {
            System.out.println("비어있습니다!");
            return null;
        }
    }
    
}
