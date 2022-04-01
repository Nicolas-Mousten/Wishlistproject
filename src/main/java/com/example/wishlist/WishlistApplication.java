package com.example.wishlist;

import com.example.wishlist.service.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class WishlistApplication {
    public static void main(String[] args) {

        /*db.insertIntoProduct(new Wish(5687,"computer",145,1578));*/
        SpringApplication.run(WishlistApplication.class, args);
        UserService.emailIsTaken("tobias@gmail.com","iAmStupid");
        UserService.logIn("tobias@gmail.com","iAmStupid");
    }

}
