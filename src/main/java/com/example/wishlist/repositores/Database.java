package com.example.wishlist.repositores;

import com.example.wishlist.model.Product;
import com.example.wishlist.service.UserService;
import com.mysql.cj.protocol.Resultset;

import java.sql.*;

public class Database {
    private static Connection con;
    private static String url;
    private static String password;
    private static String user;
    private static Statement stmt;
    private static String activeUserSession;

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

    public static void insertIntoProduct(Product product) throws SQLException {
        int productId = product.getProductId();
        String productName = product.getProductName();
        double productPrice = product.getProductPrice();
        boolean isReserved = product.getIsReserved();
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

    public static void insertIntoWishListInvites(String email, String wishListId) throws SQLException {
        try {
            stmt = con.createStatement();
            String sqlString = "INSERT INTO `wish_list_invites` (email, wish_list_id) " +
                    "VALUES ('" + email + "'," + wishListId + ");";
            stmt.executeUpdate(sqlString);
        } catch(Exception e) {
            System.out.println("Query fail");
        } finally {
            stmt.close();
        }
    }


    public static void insertIntoWishList(String email, String productId) throws SQLException {
        try {
            stmt = con.createStatement();
            String sqlString = "UPDATE `product` " +
                    "SET wish_list_id = " + getWishListId(email) +
                    "WHERE product_id = " + productId + ";";
            stmt.executeUpdate(sqlString);
        } catch (Exception e) {
            System.out.println("Product was not added to the wish list");
        } finally {
            stmt.close();
        }
    }

    public static boolean getIsReserved() {
       /* ResultSet rs = null;
        try {
            stmt = con.createStatement();
            String sqlString = "SELECT wish_list_id FROM wish_list WHERE email ='" + email + "'";
            rs = stmt.executeQuery(sqlString);
        } catch(Exception e) {
            System.out.println("Query fail");
        } finally {
            stmt.close();
        }
        assert rs != null;
        return rs.getString("wish_list_id");*/
        return true;
    }

    public static String getWishListId(String email) throws SQLException {
        ResultSet rs = null;
        try {
            stmt = con.createStatement();
            String sqlString = "SELECT wish_list_id FROM wish_list WHERE email ='" + email + "'";
            rs = stmt.executeQuery(sqlString);
        } catch(Exception e) {
            System.out.println("Query fail");
        } finally {
            stmt.close();
        }
        assert rs != null;
        return rs.getString("wish_list_id");
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

    public static void setActiveUserSession(String activeUserSession) {
        Database.activeUserSession = activeUserSession;
    }

    public static String getActiveUserSession() {
        return activeUserSession;
    }
}

