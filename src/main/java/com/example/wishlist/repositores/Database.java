package com.example.wishlist.repositores;

import com.example.wishlist.model.Wish;

import java.sql.*;

public class Database {
    private static Connection con;
    private static String url;
    private static String password;
    private static String user;
    private static Statement stmt;

    public Database(String url, String user, String password) {
        Database.url = url;
        Database.user = user;
        Database.password = password;
        connectDB();
    }

    private static void connectDB() {
        try
        {
            con = DriverManager.getConnection(url,user,password);
            System.out.println("We have a connection");
        }
        catch(Exception e){
            System.out.println("Failed Connection");
        }
    }

    public static void insertIntoProduct(Wish wish) throws SQLException {
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
        } finally {
            stmt.close();
        }
    }

    public static void insertIntoWishList(int wishListId, int productId) throws SQLException {
        try {
            stmt = con.createStatement();
            String sqlString = "UPDATE `product` " +
                    "SET wish_list_id = " + wishListId +
                    "WHERE product_id = " + productId + ";";
            stmt.executeUpdate(sqlString);
        } catch (Exception e) {
            System.out.println("");
        } finally {
            stmt.close();
        }
    }
    public static void insertUser(String userEmail, String userPassword) throws SQLException {
        try{
            stmt = con.createStatement();
            String sqlString = "INSERT INTO `user`(`email`,`password`) Values" +
                    "('"+userEmail+"','"+userPassword+"');";
            stmt.executeUpdate(sqlString);
        }catch(Exception e){
            System.out.println(e);
        } finally{
            stmt.close();
        }
    }
    public static String selectUserEmail(String email) throws SQLException {
        ResultSet rs;
        try{
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            String sqlStr = "SELECT * FROM `user` where `email`=\""+email+"\"";
            rs = stmt.executeQuery(sqlStr);
            rs.next();
            String output = "";
            output += rs.getString(1);
            output += ",";
            output += rs.getString(2);
            return output;

        }catch (Exception e){
            System.out.println("Email does not exist");
        } finally {
            stmt.close();
        }
        return null;
    }
    public static void removeFromWishList(int productId) throws SQLException {
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

