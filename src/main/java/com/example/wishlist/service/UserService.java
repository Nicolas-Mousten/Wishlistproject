package com.example.wishlist.service;

import com.example.wishlist.repositores.Database;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class UserService {

    public static boolean logIn(String userEmail, String userPassword){
        Database db = new Database("jdbc:mysql://127.0.0.1:3306/wishlists","root","Uvnx3gxc");
        String validation = db.selectUserEmail(userEmail);
        if(validation == null){
            return false;
        }else{
            //check if the password is the one that belongs to that email.
            int divider = validation.indexOf(",");
            String password = validation.substring(divider+1);
            if(userPassword.equals(password)){
                System.out.println("Welcome "+userEmail);
            }else{
                System.out.println("Wrong Password");
            }
        }
        return false;
    }
    public static void emailIsTaken(String userEmail, String userPassword){
        Database db = new Database("jdbc:mysql://127.0.0.1:3306/wishlists","root","Uvnx3gxc");
        String validation = db.selectUserEmail(userEmail);
        System.out.println(validation);
        if(validation == null){
            try {
                db.insertUser(userEmail, userPassword);
            }catch (SQLException e){
                System.out.println(e);
            }
        }else{
            System.out.println("this email is taken");
        }
        //check if email exist in database. Done!

        //create user if email is not in database
    }
}
