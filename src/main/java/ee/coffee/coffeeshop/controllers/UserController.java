package ee.coffee.coffeeshop.controllers;


import ee.coffee.coffeeshop.entity.User;
import ee.coffee.coffeeshop.enums.UserRole;
import ee.coffee.coffeeshop.repositories.UserRepository;
import ee.coffee.coffeeshop.services.interfaces.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@Controller     // создаётся контроллер и управляется спрингом
@RequiredArgsConstructor    // позволит получить конструктор с параметром для каждого поля
public class UserController {

    private final UserService userService;
    private final UserRepository userRepository;

    // получает идентификатор пользователя из объекта UserDetails
    @GetMapping(value = "/login")
    public String login() { return "/login";
    }

    @GetMapping(value = "/registration")
    public String registration() {
        return "registration";
    }

    @PostMapping("/registration")
    public String createUser(User user, Map<String, Object> model) {
        User userFromDb = userRepository.findByEmail(user.getUsername());

        if (userFromDb != null) {   // если такой юзер есть в базе, то выдаит ошибку
            model.put("errorMessage", "User exists!");
            return "registration";
        }

        user.setActive(true);
        user.setRoles(Collections.singleton(UserRole.USER));
        userRepository.save(user);

        return "redirect:/login";
    }


//    @PostMapping(value = "/registration")
//    public String createUser(User user, Model model) {
//        if (!userService.createUser(user)) {
//            model.addAttribute("errorMessage", "User with this email: " + user.getUser_email() + " already exists");
//            return "registration";
//        }
//        return "redirect:/login";
//    }

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