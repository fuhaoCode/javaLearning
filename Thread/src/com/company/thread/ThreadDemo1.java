package com.company.thread;

public class ThreadDemo1 extends Thread{
    @Override
    public void run() {
        for(int i=1;i<100;i+=2){
            System.out.println("奇数："+i);
        }
    }
}
