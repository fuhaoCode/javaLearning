package com.company.account;

import java.util.concurrent.locks.ReentrantLock;

public class Account implements Runnable{
        private int money=0;
        private final ReentrantLock lock=new ReentrantLock();
        @Override
        public void run() {
            while (true) {

                try {
                    Thread.sleep((int)Math.random()*100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                lock.lock();
                for (int i=0;i<3;i++){
                    money+=1000;
                    System.out.println(Thread.currentThread().getName() + "存钱" + 1000);
                    System.out.println("账户余额："+money);
                }
                lock.unlock();
                break;

            }
        }
}
