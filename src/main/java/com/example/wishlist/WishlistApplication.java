package com.example.wishlist;

import com.example.wishlist.model.Wish;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.example.wishlist.repositores.Database;


@SpringBootApplication
public class WishlistApplication {
    static Database db = new Database("jdbc:mysql://127.0.0.1:3306/wish_list","root","dk5gmjpfmebf");
    public static void main(String[] args) {
        Database db = new Database("jdbc:mysql://127.0.0.1:3306/wishlists","root","dk5gmjpfmebf");
        db.connectDB();
        db.selectUserEmail("nicolas.mousten@gmail.com");
        /*db.insertIntoProduct(new Wish(5687,"computer",145,1578));*/
        SpringApplication.run(WishlistApplication.class, args);
    }

}
