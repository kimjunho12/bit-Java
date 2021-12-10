package com.ds.practice.test.thread;

class ATM implements Runnable {
    private long depositeMoney = 10000;
    boolean used = false;

    public void run() {
        synchronized (this) { // sync Start
            for (int i = 0; i < 10; ++i) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (getDepositeMoney() <= 0)
                    break;
                withDraw(1000);
                this.notify();

                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } // sync End
    }

    public void withDraw(long howMuch) {
        System.out.print(Thread.currentThread().getName() + ", ");
        if (getDepositeMoney() >= howMuch) {
            depositeMoney -= howMuch;
            System.out.printf("잔액 : %d원 %n", getDepositeMoney());
        } else {
            System.out.print("잔액이 부족합니다.");
        }
    }

    private long getDepositeMoney() {
        return depositeMoney;
    }
}

public class SyncroniazedEx {
    public static void main(String[] args) {
        ATM atm = new ATM();
        Thread trd_mom = new Thread(atm, "mom"); // thread 이름부여
        Thread trd_son = new Thread(atm, "son");

        trd_mom.start();
        trd_son.start();
    }
}