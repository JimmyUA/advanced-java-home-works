package com.sergey.prykhodko.example.shop;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Sergey on 10.07.2017.
 */
public class Shop {
    private Product[] availableProducts;

    public Shop(Product[] availableProducts) {
        this.availableProducts = availableProducts;
    }

    public Product[] getAvailableProducts() {
        return availableProducts;
    }

    public void setAvailableProducts(Product[] availableProducts) {
        this.availableProducts = availableProducts;
    }


    class Cart {
        private Shop shop;
        private List<Product> products = new ArrayList<>();


        public Cart() {
            this.shop = Shop.this;
        }

        public void add(Product[] newProducts) {
            products.addAll(Arrays.asList(newProducts));
        }

        public long getTotalPrice() {
            long sum = 0;
            for (Product product : products) {
                sum += product.getPrice();
            }
            return sum;
        }

        public void buyAll(Account seller, Account buyer) {
            Thread t = null;
                t = new Thread(() -> {
                    synchronized(seller) {
                        if (buyer.getBalance() >= getTotalPrice()) {
                            for (Product product : products) {
                                buyer.setBalance(buyer.getBalance() - product.getPrice());
                                seller.setBalance(seller.getBalance() + product.getPrice());
                            }
                        }
                    }

                });
                t.start();
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}