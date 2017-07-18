package com.sergey.prykhodko.example.shop;

/**
 * Created by Sergey on 10.07.2017.
 */
public class Product {
    private String name;
    private long price;

    public Product(String name, int price) {
        this.name = name;
        this.price =price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(long price) {

        this.price = price;
    }

    public long getPrice() {

        return price;
    }

    public String getName() {

        return name;
    }
}
