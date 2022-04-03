package com.example.wishlist.Controller;


import com.example.wishlist.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
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

    @PostMapping("/sign-up")
    public String signUp(WebRequest dataFromForm)
    {
        String email = dataFromForm.getParameter("email");
        String name = dataFromForm.getParameter("name");
        String password = dataFromForm.getParameter("pwd");
        try {
            UserService.isEmailTaken(email, password);
        } catch (Exception e) {
            System.out.println(e);
        }
        return "redirect:/LoginPage";
    }

    @GetMapping("/LoginPage")
    public String loginPage(WebRequest dataFromForm)
    {
        return "LoginPage";
    }
}

