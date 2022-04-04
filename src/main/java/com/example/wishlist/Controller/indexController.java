package com.example.wishlist.Controller;


import com.example.wishlist.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;


@Controller
public class indexController {

    @GetMapping("/")
    public String index()
    {
        return "Frontpage";
    }

    @GetMapping("/hej")
    public String onskePage()
    {
        return "Onskepage";
    }

    @GetMapping("/SignUpPage")
    public String signOpPage(){
        return "SignUpPage";
    }

    private boolean emailIsTaken;

    @PostMapping("/signup")
    public String signup(WebRequest dataFromForm)
    {
        String email = dataFromForm.getParameter("email");
        String name = dataFromForm.getParameter("name");
        String password = dataFromForm.getParameter("pwd");
        try {
             emailIsTaken = UserService.isEmailTaken(email, password);
        } catch (Exception e) {
            System.out.println(e);
        }
        if(emailIsTaken == true){
            return "redirect:/emailTaken";
        }else{
            return "redirect:/";
        }

    }

    @PostMapping("/addToWishList")
    public String addToWishList(WebRequest dataFromForm) {
        String wishId = dataFromForm.getParameter("wishId");
        return "redirect:/oenskepage";
    }
    @GetMapping("/emailTaken")
    public String emailTaken(Model model){
        String output;
        if(emailIsTaken==true){
            output = "Email is taken";
        }else{
            output = "";
        }
        model.addAttribute("emailIsTaken",output);
        return "SignUpPage";
    }


}

