package com.example.wishlist.repositores;

import com.example.wishlist.model.Wish;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Database {
    private Connection con;
    private String url;
    private String password;
    private String user;
    private Statement stmt;

    public Database(String url, String user, String password) {
        this.url = url;
        this.user = user;
        this.password = password;
    }

    public Connection connectDB() {
        try
        {
            con = DriverManager.getConnection(url,user,password);
            System.out.println("We have a connection");
        }
        catch(Exception e){
            System.out.println("Failed Connection");
        }
        return con;
    }

    public void insertIntoProduct(Wish wish){
        int productId = wish.getProductId();
        String productName = wish.getProductName();
        double productPrice = wish.getProductPrice();
        boolean isReserved = wish.getIsReserved();
        try {
            stmt = con.createStatement();
            String sqlString = "INSERT INTO `product` (product_id,product_name, product_price,isReserved) " +
                    "VALUES (" + productId + ",'" + productName + "'," + productPrice + "," + isReserved + ");";
            stmt.executeUpdate(sqlString);
            stmt.close();
        } catch(Exception e) {
            System.out.println("Query fail");
        }
    }

    public void insertIntoWishList(int wishListId, int productId) {
        try {
            stmt = con.createStatement();
            String sqlString = "UPDATE `product` " +
                    "SET wish_list_id = " + wishListId +
                    "WHERE product_id = " + productId + ";";
            stmt.executeUpdate(sqlString);
            stmt.close();
        } catch (Exception e) {
            System.out.println("");
        }
    }
    public void insertUser(String userEmail, String userPassword){

    }
    public void selectUserEmail(String email){
        try{
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            String sqlStr = "SELECT * FROM `user` where `email`=\""+email+"\"";
            ResultSet rs = stmt.executeQuery(sqlStr);
            rs.next();
            System.out.println(rs.getString(1));

        }catch (Exception e){
            System.out.println(e);
            System.out.println("Something went wrong");
        }
    }
    public void removeFromWishList(int productId) {
        try {
            stmt = con.createStatement();
            String sqlString = "DELETE FROM `product` " +
                    "WHERE product_id = " + productId;
            stmt.executeUpdate(sqlString);
            stmt.close();
        } catch(Exception e) {
            System.out.println("");
        }
    }
}

