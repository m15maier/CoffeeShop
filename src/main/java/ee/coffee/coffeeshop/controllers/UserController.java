package ee.coffee.coffeeshop.controllers;

import ee.coffee.coffeeshop.models.User;
import ee.coffee.coffeeshop.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@EntityScan("ee.coffee.*")
@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;


    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

    @PostMapping("/registration")
    public String createUser(User user, Model model) {
        if(!userService.createUser(user)) {
            model.addAttribute("errorMessage", "User with email: " + user.getEmail() + "already exists");
            return "registration";
        }
        return "redirect:/login";
    }

    @GetMapping("/hollo")
    public String securityUrl() {
        return "hello";
    }
}
