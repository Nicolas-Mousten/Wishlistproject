package com.example.wishlist.model;

import java.util.ArrayList;

public class WishList {
    private ArrayList<Product> products = new ArrayList<>();
    private ArrayList<User> guests = new ArrayList<>();
    String userEmail;
    String wishListName;


    private WishList(String userEmail, String wishListName, int wishListId) {
        this.userEmail = userEmail;
        this.wishListName = wishListName;
    }

    public void addToWishList(Product product) {
        products.add(product);
    }

    public Product getProduct(int index) {
        return products.get(index);
    }
}
