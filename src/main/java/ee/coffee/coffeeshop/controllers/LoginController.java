package ee.coffee.coffeeshop.controllers;

import ee.coffee.coffeeshop.entity.User;
import ee.coffee.coffeeshop.services.interfaces.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller     // создаётся контроллер и управляется спрингом
@RequiredArgsConstructor    // позволит получить конструктор с параметром для каждого поля

public class LoginController {
    private final UserService userService;

    @GetMapping("/login")
    public String login() {
       return "/login";

    }
    @GetMapping(value = "/registration")
    public String registration() {
        return "registration";
    }


    @PostMapping(value = "/registration")
    public String createUser(User user, Model model) {
        if (!userService.createUser(user)) {
            model.addAttribute("errorMessage", "User with this email: " + user.getUser_email() + " already exists");
            return "registration";
        }
        return "redirect:/login";
    }
}
