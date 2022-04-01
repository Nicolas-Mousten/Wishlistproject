package com.example.wishlist.service;

import com.example.wishlist.repositores.Database;

import java.sql.Connection;
import java.sql.Statement;

public class UserService {

    public static boolean logIn(String email, String password){

        return false;
    }
    public static void emailIsTaken(String userEmail, String userPassword){
        Database db = new Database("jdbc:mysql://127.0.0.1:3306/wishlists","root","Uvnx3gxc");
        String validation = db.selectUserEmail(userEmail);
        System.out.println(validation);
        if(validation == null){
            System.out.println("this email is free");
            db.insertUser(userEmail, userPassword);

        }else{
            System.out.println("this email is taken");
        }
        //check if email exist in database.

        //create user if email is not in database
    }
}
