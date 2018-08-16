package io.pivotal.workshop;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String goLogin(){
        return "login";
    }

    @GetMapping("/")
    public String goHome() {
        return "home";
    }
}
