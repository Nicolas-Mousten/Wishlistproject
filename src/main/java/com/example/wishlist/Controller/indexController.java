package com.example.wishlist.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class indexController {

    @GetMapping("/hej")
    public String index(){
        System.out.println("hello");
        return "Frontpage";
    }


}
