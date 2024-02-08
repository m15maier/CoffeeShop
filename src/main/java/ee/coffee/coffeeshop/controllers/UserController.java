package ee.coffee.coffeeshop.controllers;

import ee.coffee.coffeeshop.models.User;
import ee.coffee.coffeeshop.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequiredArgsConstructor
//@Primary
public class UserController {

    private final UserService userService;


    @GetMapping(value = "/login")
    public String login() {
        return "login";
    }


    @GetMapping(value = "/registration")
    public String registration() {
        return "registration";
    }


    @PostMapping(value = "/registration")
    public String createUser(User user) {
        userService.createUser(user);
        return "redirect:/login";
    }

    @GetMapping(value = "/hello")
    public String securityUrl() {
        return "hello";
    }
}
