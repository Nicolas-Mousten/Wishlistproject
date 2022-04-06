package com.example.wishlist.model;

public class Wish {
    String wish;

    public Wish(String wish) {
        this.wish = wish;
    }

    public String getWish() {
        return wish;
    }

    public void setWish(String wish) {
        this.wish = wish;
    }

    @Override
    public String toString() {
        return "Wish{" +
                "wish='" + wish + '\'' +
                '}';
    }
}