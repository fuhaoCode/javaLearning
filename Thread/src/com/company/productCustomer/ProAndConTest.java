package com.company.productCustomer;

public class ProAndConTest{
    public static void main(String[] args) {
        Product product=new Product();
        Productor productor=new Productor(product);
        Customer customer=new Customer(product);
        new Thread(productor).start();
        new Thread(customer).start();
    }

}
