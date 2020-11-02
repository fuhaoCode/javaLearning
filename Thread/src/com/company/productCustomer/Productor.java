package com.company.productCustomer;

public class Productor implements Runnable {
    private Product product;
    public Productor(Product product){
        this.product=product;
    }
    @Override
    public void run(){
        try {
            Thread.sleep((int)Math.random()*100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        product.addProduct();
    }
}
