package com.example.wishlist;

import com.example.wishlist.repositores.Database;
import com.example.wishlist.service.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class WishlistApplication {
    public static Database db = new Database("jdbc:mysql://127.0.0.1:3306/wishlists","root","dk5gmjpfmebf");
    public static void main(String[] args) {
        SpringApplication.run(WishlistApplication.class, args);
    }

}
