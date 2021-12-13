package com.ds.practice.test.tree;

public class NodeApp {
    public static void main(String[] args) {
        // MyLinkedList list = new MyLinkedList();

        // list.addLast(1);
        // list.addLast(2);
        // list.addLast(3);
        // list.addLast(4);
        // list.addLast(5);
        // list.addLast(6);
        // System.out.println(list);

        DoubleLinkedList dll = new DoubleLinkedList();
        System.out.println(dll.isEmpty());
        dll.append(10);     // 10
        dll.push(20);       // 20 - 10
        dll.append(30);     // 20 - 10 - 30
        dll.insertAt(40, 2);// 20 - 10 - 40 - 30
        dll.push(50);       // 50 - 20 - 10 - 40 - 30
        dll.insertAt(70, 6);// 50 - 20 - 10 - 40 - 30 - 70

        dll.disp();

        System.out.println("70 is at " + dll.indexOf(70));


        System.out.println(dll.removeAt(0));            // 50 // 20 - 10 - 40 - 30 - 70
        System.out.println(dll.removeAt(1));            // 10 // 20 - 40 - 30 - 70
        System.out.println(dll.removeAt(dll.size()-1)); // 70 // 20 - 40 - 30

        dll.disp();

        System.out.println("40 is at " + dll.indexOf(40));

        System.out.println(dll.isEmpty());

        System.out.println(dll.get(-89));
        System.out.println("20 is at " + dll.indexOf(20));

    }
}
