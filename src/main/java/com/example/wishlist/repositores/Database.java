package com.example.wishlist.repositores;

import com.example.wishlist.model.Wish;

import java.sql.Connection;
import java.sql.DriverManager;
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
            try{
                con = DriverManager.getConnection(url,user,password);
                System.out.println("We have a connection");
            }
            catch(Exception e){
                System.out.println("Failed Connection");
            }
        }

        public void insertIntoProduct(Wish wish){
            int productId = wish.getProductId();
            String productName = wish.getProductName();
            double productPrice = wish.getProductPrice();
            try {
                stmt = con.createStatement();
                String sqlString = "INSERT INTO `product` (product_id, product_name, product_price,isReserved) " +
                        "VALUES ();";
                stmt.executeUpdate(sqlString);
                stmt.close();

            } catch(Exception e) {
                System.out.println();
            }

        }

        public void insertIntoWishList(){
            String sqlString = "INSERT INTO `wish_list` ()values()";

        }

}

