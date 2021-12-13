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
        dll.append(10);     // 10
        dll.push(20);       // 20 - 10
        dll.append(30);     // 20 - 10 - 30
        dll.insertAt(40, 2);// 20 - 10 - 40 - 30
        dll.push(50);       // 50 - 20 - 10 - 40 - 30

        for (int i = 0; i < dll.size(); ++i){
            System.out.print(dll.get(i) + " - ");
        }
        System.out.println();

        System.out.println(dll.removeAt(0));    // 50 // 20 - 10 - 40 - 30
        System.out.println(dll.removeAt(1));    // 10 // 20 - 40 - 30
        System.out.println(dll.removeAt(dll.size()-1)); // 30 // 20 - 40

        for (int i = 0; i < dll.size(); ++i){
            System.out.print(dll.get(i) + " - ");
        }

    }
}
