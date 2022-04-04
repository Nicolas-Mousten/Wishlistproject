package com.example.wishlist.model;

import java.util.ArrayList;

public class WishList {
    private ArrayList<Product> products = new ArrayList<>();
    int userEmail;
    String wishListName;
    int wishListId;

    private WishList(int userEmail, String wishListName, int wishListId) {
        this.userEmail = userEmail;
        this.wishListName = wishListName;
        this.wishListId = wishListId;
    }

    public void addToWishList(Product product) {
        products.add(product);
    }

    public Product getProduct(int index) {
        return products.get(index);
    }
}
