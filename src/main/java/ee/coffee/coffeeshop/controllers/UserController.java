package ee.coffee.coffeeshop.controllers;

import ee.coffee.coffeeshop.dto.UserDTO;
import ee.coffee.coffeeshop.entity.Security;
import ee.coffee.coffeeshop.entity.User;
import ee.coffee.coffeeshop.enums.UserRole;
import ee.coffee.coffeeshop.services.interfaces.UserService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller     // создаётся контроллер и управляется спрингом
@RequiredArgsConstructor    // позволит получить конструктор с параметром для каждого поля
public class UserController {

    private final UserService userService;


    // получает идентификатор пользователя из объекта UserDetails
    @GetMapping("/user/get")
    public User getUser(@AuthenticationPrincipal UserDetails userDetails) { // Аннотация указывает на то, что нужно использовать текущего аутентифицированного пользователя в качестве значения параметра userDetails

        Integer userId = ((Security) userDetails).getUserId();
        User user = userService.getUserById(userId);
        return user;
    }

    // сохраняет нового пользователя и его данные
    @PostMapping(value = "/user/add")
    public void addNewUser(@RequestBody UserDTO userDTO) {   // Аннотация указывает на то, что объект UserDTO должен быть извлечен из тела запроса
        User user = userService.saveUser(userDTO.getName(), userDTO.getEmail(), userDTO.getAddress(), userDTO.getPhone());
        userService.saveSecurity(user.getUserId(), userDTO.getPassword(), user.getUser_email());
    }








    // только с ролью админа

    @GetMapping(value = "/admin/user/{id}")
    public User getUser(@PathVariable(value = "id") Integer id, HttpServletRequest request, @Param(value = "ADMIN") UserRole userRole) {
        User user = userService.getUserById(id);
        return user;
    }


    @GetMapping(value = "admin/user/get_all_users")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }


    @GetMapping(value = "/admin/user/{id}/status/{status}")
    public List<User> getUserByStatus(@PathVariable(name = "status") String status) {
        return userService.getUserByStatus(status);
    }
}