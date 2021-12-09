package com.ds.practice.test;

public class Halbe {
    public void disp() {
        System.out.println("halbe");
    }
}

class Abe extends Halbe {
    public void disp() {
        System.out.println("abe");
    }
}

class Me extends Abe {
    public void disp() {
        System.out.println("me");
    }
}

class First {
    public static void main(String[] args) {
        Halbe halbe = new Halbe();
        Abe abe = new Abe();
        Me me = new Me();

        Halbe h;

        h = halbe;
        h.disp();

        h = abe;        // 동적바인딩 . : 부모의 레퍼런스로 자식을 접근하는 방식
        h.disp();
        
        h = me;
        h.disp();

        halbe.disp();
        abe.disp();
        me.disp();
    }
}
