package com.example.wishlist.repositores;

import com.example.wishlist.model.Wish;

import java.sql.*;

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

    private void connectDB() {
        try
        {
            con = DriverManager.getConnection(url,user,password);
            System.out.println("We have a connection");
        }
        catch(Exception e){
            System.out.println("Failed Connection");
        }
    }

    public void insertIntoProduct(Wish wish) throws SQLException {
        int productId = wish.getProductId();
        String productName = wish.getProductName();
        double productPrice = wish.getProductPrice();
        boolean isReserved = wish.getIsReserved();
        try {
            connectDB();
            stmt = con.createStatement();
            String sqlString = "INSERT INTO `product` (product_id,product_name, product_price,isReserved) " +
                    "VALUES (" + productId + ",'" + productName + "'," + productPrice + "," + isReserved + ");";
            stmt.executeUpdate(sqlString);
            stmt.close();
        } catch(Exception e) {
            System.out.println("Query fail");
        } finally {
            stmt.close();
        }
    }

    public void insertIntoWishList(int wishListId, int productId) throws SQLException {
        try {
            connectDB();
            stmt = con.createStatement();
            String sqlString = "UPDATE `product` " +
                    "SET wish_list_id = " + wishListId +
                    "WHERE product_id = " + productId + ";";
            stmt.executeUpdate(sqlString);
            stmt.close();
        } catch (Exception e) {
            System.out.println("");
        } finally {
            stmt.close();
        }
    }
    public void insertUser(String userEmail, String userPassword){
        try{
            connectDB();
            stmt = con.createStatement();
            String sqlString = "INSERT INTO `user`(`email`,`password`) Values" +
                    "("+userEmail+","+userPassword+");";
            stmt.executeUpdate(sqlString);
        }catch(Exception e){
            System.out.println(e);
        }
    }
    public String selectUserEmail(String email){
        ResultSet rs;
        connectDB();
        try{
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            String sqlStr = "SELECT * FROM `user` where `email`=\""+email+"\"";
            rs = stmt.executeQuery(sqlStr);
            rs.next();
            return rs.getString(1);

        }catch (Exception e){
            System.out.println("Email does not exist");
        }
        return null;
    }
    public void removeFromWishList(int productId) throws SQLException {
        try {
            stmt = con.createStatement();
            String sqlString = "DELETE FROM `product` " +
                    "WHERE product_id = " + productId;
            stmt.executeUpdate(sqlString);
        } catch(Exception e) {
            System.out.println("Query fail");
        } finally {
            stmt.close();
        }
    }
}

