package com.example.wishlist;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import repository.Database;

@SpringBootApplication
public class WishlistApplication {
    static Database db = new Database("jdbc:mysql://127.0.0.1:3306/wish_list","root","dk5gmjpfmebf");
    public static void main(String[] args) {
        SpringApplication.run(WishlistApplication.class, args);
    }

}
