package com.ds.practice.memoryapp;

import java.util.Arrays;

public abstract class Memory<T> {
    protected int maxSize;
    protected int last;
    protected T[] arr;

    public Memory() {
    }

    public Memory(int maxSize, T[] arr) {
        this.maxSize = maxSize;
        this.arr = arr;
        this.last = 0;
    }

    protected abstract boolean isEmpty();

    protected T[] push(T item) {
        try {
            arr[last++] = item;
        } catch (Exception e) {
            System.out.println("허용 사이즈 초과입니다!");
            last--;
        }
        return arr;
    }

    protected abstract T pop();

    @Override
    public String toString() {
        return "Memory [arr=" + Arrays.toString(arr) + ", last=" + last + ", maxSize=" + maxSize + "]";
    }
}
