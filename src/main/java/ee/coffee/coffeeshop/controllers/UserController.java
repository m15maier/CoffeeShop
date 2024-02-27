package ee.coffee.coffeeshop.controllers;


import ee.coffee.coffeeshop.entity.User;
import ee.coffee.coffeeshop.repositories.UserRepository;
import ee.coffee.coffeeshop.services.interfaces.CreateUserExeption;
import ee.coffee.coffeeshop.services.interfaces.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller     // создаётся контроллер и управляется спрингом
@RequiredArgsConstructor    // позволит получить конструктор с параметром для каждого поля
public class UserController {

    private final UserService userService;
    private final UserRepository userRepository;

    // получает идентификатор пользователя из объекта UserDetails
    @GetMapping(value = "/login")
    public String login() { return "login";
    }

    @GetMapping(value = "/registration")
    public String registration() {
        return "registration";
    }

    @PostMapping("/registration")
    public String createUser(User user, Map<String, Object> model) {

        try {
            userService.createUser(user);
        } catch (CreateUserExeption error) {
            model.put("errorMessage", error.getMessage());
            return "registration";
        }
        return "redirect:/login?signUpOk";
    }


    @GetMapping("/user/{user}")
    public String userInfo(@PathVariable("user") User user, Model model) {
        model.addAttribute("user", user);
        return "user-info";
    }


//    // только с ролью админа
//    @PreAuthorize("hasRole('ADMIN')")
//    @GetMapping(value = "admin/user/get_all_users")
//    public List<User> getAllUsers() {
//        return userService.getAllUsers();
//    }
//


}
