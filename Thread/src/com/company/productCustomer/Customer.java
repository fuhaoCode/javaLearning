package com.company.productCustomer;

public class Customer implements Runnable {
    private Product product;
    public Customer(Product product){
        this.product=product;
    }
    @Override
    public void run(){
        try {
            Thread.sleep((int)Math.random()*100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        product.getProduct();
    }


}
