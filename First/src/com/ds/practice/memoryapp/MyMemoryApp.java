package com.ds.practice.memoryapp;

import java.util.Scanner;

public class MyMemoryApp {
    static int maxSize;
    public static void main(String[] args) {
        Memory<Integer> s, q;
        Scanner sc = new Scanner(System.in);
        System.out.printf("최대 사이즈를 입력하세요. : ");  maxSize = sc.nextInt();
        Integer[] stack = new Integer[maxSize];
        Integer[] queue = new Integer[maxSize];

        s = new MyStack<>(maxSize, stack);
        q = new MyQueue<>(maxSize, queue);
        
        OUT : while (true) {
            int choose = 0;
            System.out.printf("1. Stack\t2. Queue\t3. Break\t : ");
            choose = sc.nextInt();
            switch (choose) {
                case 1 :
                    stackFunc(s);
                    break;
                case 2 :
                    queueFunc(q);
                    break;
                case 3 :
                    System.out.println("종료합니다.");
                    break OUT;
                default : 
                    System.out.println("1, 2, 3 중에서 선택 해 주세요");
            }
            
        }
        sc.close();
    }
    private static void stackFunc(Memory<Integer> s) {
        STACK : while (true) {
            int stackChoose = 0;
            Scanner sc = new Scanner(System.in);

            System.out.printf("1. push\t\t2. pop\t\t3. Break\t : ");
            stackChoose = sc.nextInt();
            switch (stackChoose) {
                case 1 :
                    System.out.print("추가할 숫자를 입력 하세요. : ");
                    int input = sc.nextInt();
                    s.push(input);
                    break;
                case 2 :
                    try {                    
                        int top = s.pop();
                        System.out.printf("가장 위 %d를 출력합니다.\n", top);
                    } catch (NullPointerException e) {
                        System.out.print("");
                    }
                    break;
                case 3 :
                    System.out.println("Stack 설정을 종료합니다.");
                    break STACK;
                default : 
                    System.out.println("1, 2, 3 중에서 선택 해 주세요");
            }
        }
    }

    private static void queueFunc(Memory<Integer> q) {
        QUEUE : while (true) {
            int queueChoose = 0;
            Scanner sc = new Scanner(System.in);

            System.out.printf("1. push\t\t2. pop\t\t3. Break\t : ");
            queueChoose = sc.nextInt();
            switch (queueChoose) {
                case 1 :
                    System.out.print("추가할 숫자를 입력 하세요. : ");
                    int input = sc.nextInt();
                    q.push(input);
                    break;
                case 2 :
                    try {                    
                        int first = q.pop();
                        System.out.printf("가장 앞 %d를 출력합니다.\n", first);
                    } catch (NullPointerException e) {
                        System.out.print("");
                    }
                    break;
                case 3 :
                    System.out.println("Queue 설정을 종료합니다.");
                    break QUEUE;
                default : 
                    System.out.println("1, 2, 3 중에서 선택 해 주세요");
            }
        }
    }
}
