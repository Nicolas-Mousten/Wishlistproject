package com.example.wishlist.service;

import com.example.wishlist.repositores.Database;
import com.example.wishlist.WishlistApplication;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class UserService {

    public static boolean logIn(String userEmail, String userPassword) throws SQLException {
        String validation = Database.selectUserEmail(userEmail);
        if(validation == null){
            return false;
        }else{
            //check if the password is the one that belongs to that email.
            int divider = validation.indexOf(",");
            String password = validation.substring(divider+1);
            if(userPassword.equals(password)){
                System.out.println("Welcome "+userEmail);
                return true;
            }else{
                System.out.println("Wrong Password");
                return false;
            }
        }
    }

    public static boolean isEmailTaken(String userEmail, String userPassword) throws SQLException {
        String validation = Database.selectUserEmail(userEmail);
        System.out.println(validation);
        if(validation == null){
            try {
                Database.insertUser(userEmail, userPassword);
            }catch (SQLException e){
                System.out.println(e);
            }
        }else{
            System.out.println("this email is taken");
            return true;
        }
        return false;
    }
}
