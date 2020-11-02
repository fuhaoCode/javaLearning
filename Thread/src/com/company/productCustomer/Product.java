package com.company.productCustomer;

public class Product {
    private int products;
    public synchronized void addProduct(){
        while (true){
            if (products>=20){
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }else {
                products++;
                System.out.println("生产者生产了"+products+"号牛奶");
                notifyAll();
            }
        }
    }

    public synchronized void getProduct(){
        while (true){
            if (products<=0){
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }else {
                System.out.println("消费者消费了"+products+"号牛奶");
                products--;
                notifyAll();
            }
        }
    }
}
