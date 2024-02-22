package ee.coffee.coffeeshop.controllers;

import ee.coffee.coffeeshop.dto.UserDTO;
import ee.coffee.coffeeshop.entity.Security;
import ee.coffee.coffeeshop.entity.User;
import ee.coffee.coffeeshop.services.interfaces.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller     // создаётся контроллер и управляется спрингом
@RequiredArgsConstructor    // позволит получить конструктор с параметром для каждого поля
public class UserController {

    private final UserService userService;

    // получает идентификатор пользователя из объекта UserDetails
    @GetMapping(value = "/login")
    public String saveUser() {
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

    @GetMapping("/user/{user}")
    public String userInfo(@PathVariable("user") User user, Model model) {
        model.addAttribute("user", user);
        return "user-info";
    }



//    @GetMapping("/user/get")
//    public User getUserById(@AuthenticationPrincipal UserDetails userDetails) { // Аннотация указывает на то, что нужно использовать текущего аутентифицированного пользователя в качестве значения параметра userDetails
//
//        Long userId = Long.valueOf(((Security) userDetails).getUserId());
//        return userService.getUserById(userId);
//    }

    // сохраняет нового пользователя и его данные
//    @PostMapping(value = "/user/add")
//    public void addNewUser(@RequestBody UserDTO userDTO) {   // Аннотация указывает на то, что объект UserDTO должен быть извлечен из тела запроса
//        User user = userService.saveUser(userDTO.getName(), userDTO.getEmail(), userDTO.getAddress(), userDTO.getPhone());
//        userService.saveSecurity(user.getUserId(), userDTO.getPassword(), user.getUser_email());
//    }



//    // только с ролью админа
//    @PreAuthorize("hasRole('ADMIN')")
//    @GetMapping(value = "admin/user/get_all_users")
//    public List<User> getAllUsers() {
//        return userService.getAllUsers();
//    }
//


}