package repository;

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
            try{
                this.url = url ;
                con = DriverManager.getConnection(url,user,password);
                System.out.println("We have a connection");
            }
            catch(Exception e){
                System.out.println("Failed Connection");
            }
        }

        public void insertIntoProduct(){
            String sqlString = "INSERT INTO `product` (product_id, product_name, product_price,isReserved,wish_list_id)Values();";

        }
        public void insertIntoWishList(){
            String sqlString = "INSERT INTO `wish_list` ()values()";

        }

}

