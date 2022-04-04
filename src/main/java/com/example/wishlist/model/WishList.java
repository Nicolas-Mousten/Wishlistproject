package com.example.wishlist.model;

import java.util.ArrayList;

public class WishList {
    private ArrayList<Wish> wishes = new ArrayList<>();
    int userId;
    String wishListName;
    int wishListId;

    private WishList(int userId, String wishListName, int wishListId) {
        this.userId = userId;
        this.wishListName = wishListName;
        this.wishListId = wishListId;
    }

    public void addToWishList(Wish wish) {
        wishes.add(wish);
    }

    public Wish getWish(int index) {
        return wishes.get(index);
    }
}
