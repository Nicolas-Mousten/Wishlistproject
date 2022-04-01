package com.example.wishlist;

import com.example.wishlist.model.Wish;
import com.example.wishlist.service.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.example.wishlist.repositores.Database;


@SpringBootApplication
public class WishlistApplication {
    public static void main(String[] args) {

        /*db.insertIntoProduct(new Wish(5687,"computer",145,1578));*/
        SpringApplication.run(WishlistApplication.class, args);
        UserService.emailIsTaken("nicolas.mousten@gmail.com");
    }

}
