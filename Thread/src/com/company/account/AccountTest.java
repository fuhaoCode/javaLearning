package com.company.account;


public class AccountTest {
    public static void main(String[] args) {
        Account account = new Account();
        new Thread(account,"1号").start();
        new Thread(account,"2号").start();
    }
}
