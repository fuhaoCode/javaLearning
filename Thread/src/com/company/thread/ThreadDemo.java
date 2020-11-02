package com.company.thread;

public class ThreadDemo  extends Thread{
    @Override
    public void run() {
        for(int i=2;i<100;i+=2){
            System.out.println("偶数："+i);
        }
    }
}
