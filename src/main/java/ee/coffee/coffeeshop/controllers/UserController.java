package ee.coffee.coffeeshop.controllers;

import ee.coffee.coffeeshop.models.User;
import ee.coffee.coffeeshop.models.enums.Role;
import ee.coffee.coffeeshop.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping(value = "/registration")
    public String registration() {
        return "registration";
    }


    @PostMapping(value = "/registration")
    public String createUser(User user, Model model) {
        if (!userService.createUser(user)) {
            model.addAttribute("errorMessage", "User with this email: " + user.getEmail() + " already exists");
            return "registration";
        }
        return "redirect:/login";
    }

    @GetMapping("/user/{user}")
    public String userInfo(@PathVariable("user") User user, Model model) {
            model.addAttribute("user", user);
            model.addAttribute("products", user.getProducts());
            model.addAttribute("roles", Role.values());
        return "user-info";
    }
}