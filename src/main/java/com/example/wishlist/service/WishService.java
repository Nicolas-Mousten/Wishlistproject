package com.example.wishlist.service;

import com.example.wishlist.repositores.Database;

import javax.xml.crypto.Data;
import java.sql.SQLException;

public class WishService {


/*
    public void inviteToWishList(String email, String activeUserSession) throws SQLException {
        String userEmail = email;
        String wishListId = Database.getWishListId(activeUserSession);

        if(UserService.isEmailTaken(userEmail) && doesWishListExist(activeUserSession)) {
            Database.insertIntoWishListInvites(userEmail, wishListId);
        } else if (!UserService.isEmailTaken(userEmail) && !doesWishListExist(activeUserSession)) {
            System.out.println("The email provided, and the wish list does not exist");
        } else if (!UserService.isEmailTaken(userEmail)) {
            System.out.println("The email provided does not exist");
        } else {
            System.out.println("The wish list does not exist");
        }
    }

    public boolean doesWishListExist(String activeUserSession) throws SQLException {
        if(Database.getWishListId(activeUserSession) != null) {
            return true;
        }
        return false;
    }

    public void reserveWish() {

    }*/
}
