package com.company.ticketPackage;

import java.util.concurrent.locks.ReentrantLock;

public class Ticket extends Thread{
    private int ticket=10;
    private final ReentrantLock lock=new ReentrantLock();
    @Override
    public void run(){
        while (true){
            try {
                Thread.sleep((int)Math.random()*100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
          /* synchronized (this){
               if (ticket>0){
                   System.out.println(Thread.currentThread().getName()+"卖票"+ticket--);
               }else {
                   break;
               }
           }*/
          lock.lock();//加锁
          if (ticket>0){
              System.out.println(Thread.currentThread().getName()+"卖票"+ticket--);
          }else {
              break;
          }
          lock.unlock();//释放锁
        }
    }
}
