package com.company.thread;

public class ThreadTest {
    public static void main(String[] args) {
        ThreadDemo threadDemo = new ThreadDemo();
        ThreadDemo1 threadDemo1 = new ThreadDemo1();
        new Thread(threadDemo1).start();
        threadDemo.start();

//        threadDemo.setName("偶数线程：");
    }
}
