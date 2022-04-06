package com.example.wishlist.Controller;


import com.example.wishlist.model.Wish;
import com.example.wishlist.repositores.Database;
import com.example.wishlist.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;

import java.sql.SQLException;
import java.util.ArrayList;


@Controller
public class indexController {

    Database database=new Database();

    boolean isEmailValid = false;
    @GetMapping("/")
    public String index()
    {
        return "Frontpage";
    }

    @GetMapping("/Onskepage")
    public String onskePage()
    {
        return "Onskepage";
    }

    @GetMapping("/Frontpage")
    public String knowmore(){
        return "Frontpage";
    }

    @GetMapping("/SignUpPage")
    public String signOpPage(){
        return "SignUpPage";
    }

    @PostMapping("/signup")
    public String signup(WebRequest dataFromForm) {
        String email = dataFromForm.getParameter("email");
        String name = dataFromForm.getParameter("name");
        String password = dataFromForm.getParameter("pwd");
        try {
            isEmailValid = UserService.isEmailTaken(email);
            if(!isEmailValid) {
                Database.insertUser(email, password);
            }
        }catch (SQLException e){
            System.out.println(e);
        }

        if(isEmailValid){
            return "redirect:/emailTaken";
        }else{
            return "redirect:/";
        }
    }

    @PostMapping("/login")
    public String logIn(WebRequest dataFromForm){
        String email = dataFromForm.getParameter("email");
        String password = dataFromForm.getParameter("pwd");
        Boolean loginStatus = false;
        try {
            loginStatus = UserService.logIn(email, password);
            /*Database.setActiveUserSession(email);*/
        }catch(Exception e){
            System.out.println(e);
        }
        if(loginStatus == true){
            return "redirect:/hej";                         //Place redirect place into code
        }else{
            return "redirect:/";
        }
    }
/*
    @PostMapping("/addToWishList")
    public String addToWishList(WebRequest dataFromForm) {
        String productId = dataFromForm.getParameter("productId");
        try {
            Database.insertIntoWishList(Database.getActiveUserSession(), productId);
        } catch (Exception e) {
            System.out.println(e);
        }
        return "redirect:/oenskepage";
    }*/


    @GetMapping("/emailTaken")
    public String emailTaken(Model model){
        String output;
        if(isEmailValid){
            output = "Email is taken";
        }else{
            output = "";
        }
        model.addAttribute("emailIsTaken",output);
        return "SignUpPage";
    }

    @PostMapping("/Onskepage")
    public String Onskepage(WebRequest dataFromForm) {
        String wish = dataFromForm.getParameter("wish");
        System.out.println(wish);
        Database.makeWishTable(wish);

        return "redirect:/WishlistPage";
    }

    @GetMapping("/wishlist")
    public String email(Model model){
        ArrayList<Wish> list = database.getWishFromDatabase();
        model.addAttribute("wish", list);
        return "WishlistPage";
    }
}

