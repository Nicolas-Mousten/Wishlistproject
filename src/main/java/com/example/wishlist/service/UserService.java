package com.example.wishlist.service;

import com.example.wishlist.repositores.Database;

import java.sql.Connection;

public class UserService {

    public boolean logIn(String email, String password){
        Database db = new Database("jdbc:mysql://127.0.0.1:3306/wishlists","root","Uvnx3gxc");
        db.connectDB();


        return false;
    }
    public void createUser(String email, String password){
        Database db = new Database("jdbc:mysql://127.0.0.1:3306/wishlists","root","Uvnx3gxc");
        Connection con = db.connectDB();
        String stmt;
        try{
            stmt = con.
        }catch(Exception e){

        }
    }
}
