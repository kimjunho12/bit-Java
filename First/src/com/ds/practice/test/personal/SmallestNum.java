package com.ds.practice.test.personal;

import java.util.Iterator;
import java.util.Vector;

public class SmallestNum {
    public static void main(String[] args) {
        for(int i = 1000; i < 10000; ++i){
            System.out.print(i + "\t");
            getSmallestNum(i);
            System.out.println();
        }
        
    }

    private static void getSmallestNum(int num){
        String rawNum = String.valueOf(num);
     
        Vector<Integer> v = new Vector<>();
        for (char c : rawNum.toCharArray()){
            v.add(Character.getNumericValue(c));
        }

        v.sort(null);

        Iterator<Integer> it = v.iterator();
        int n1000 = 0;
        int idx = 0;
        while (it.hasNext()){
            int tmp = it.next();
            if (tmp != 0){
                n1000 = tmp;
                break;
            }
            idx++;
        }
        v.remove(idx);

        System.out.print(n1000);
        it = v.iterator();
        while(it.hasNext()){
            System.out.print(it.next());
        }
    }
}
