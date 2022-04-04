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

    @PostMapping("")

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
        return "redirect:/LoginPage";
    }
    private boolean emailIsTaken;
    @GetMapping("/emailTaken")
    public String emailTaken(Model model){
        model.addAttribute("emailIsTaken",emailIsTaken);
        return "SignUpPage";
    }
}

