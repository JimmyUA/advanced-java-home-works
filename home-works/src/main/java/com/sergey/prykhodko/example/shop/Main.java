package com.sergey.prykhodko.example.shop;

import static java.lang.Thread.sleep;

/**
 * Created by Sergey on 10.07.2017.
 */
public class Main {

    private static final Product[] PRODUCTS = {
        new Product("bread", 356),
                new Product("chese", 356),
                new Product("doom", 356),
                new Product("poom", 356)
    };

    private static final int ALL_PRODUCTS_PRICE;

    static {
        long sum = 0;
        for (Product product : PRODUCTS) {
            sum += product.getPrice();
        }
        ALL_PRODUCTS_PRICE = (int) sum;
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Cart price is: " + ALL_PRODUCTS_PRICE);
        System.out.print("TEST PROGRESS: ");
        Account seller = new Account(7000_7263_232l, "1234", 0);
        do {
//            sleep(100);
            seller.setBalance(0);
            Shop shop = new Shop(PRODUCTS);

            Account johnAccount = new Account(234230_7263_232l, "3434", 2000);
            Shop.Cart johnCart = shop.new Cart();
            johnCart.add(PRODUCTS);

            Account lucyAccount = new Account(7230_4363_232l, "0234", 2000);
            Shop.Cart lucyCart = shop.new Cart();
            lucyCart.add(PRODUCTS);

            johnCart.buyAll(seller, johnAccount);
            johnCart.buyAll(seller, lucyAccount);


            if (seller.getBalance() != ALL_PRODUCTS_PRICE * 2) {
                System.out.println(". " + seller.getBalance());
            }
            else {
                System.out.println("\nSeller balance is: " + seller.getBalance());
                break;
            }
        }while (true);
    }



}
