package project.learnsecurity.controller.v1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ContentController {

    @GetMapping("/home")
    public String home() {
        return "home";
    }

    @GetMapping("/admin/home")
    public String adminHome() {
        return "home_admin";
    }

    @GetMapping("/user/home")
    public String userHome() {
        return "home_user";
    }

    @GetMapping("/login")
    public String login() {
        return "custom_login";
    }
}