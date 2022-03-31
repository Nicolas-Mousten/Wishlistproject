package com.example.wishlist;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.example.wishlist.repositores.Database;


@SpringBootApplication
public class WishlistApplication {
    public static void main(String[] args) {
        Database db = new Database("jdbc:mysql://127.0.0.1:3306/wishlists","root","Uvnx3gxc");
        db.connectDB();
        SpringApplication.run(WishlistApplication.class, args);
    }

}
