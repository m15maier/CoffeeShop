package ee.coffee.coffeeshop.controllers;


import ee.coffee.coffeeshop.dto.UserInfoDTO;
import ee.coffee.coffeeshop.dto.UserSignupDTO;
import ee.coffee.coffeeshop.entity.User;
import ee.coffee.coffeeshop.services.interfaces.CoffeeShopExeption;
import ee.coffee.coffeeshop.services.interfaces.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController     // создаётся контроллер и управляется спрингом
@RequiredArgsConstructor    // позволит получить конструктор с параметром для каждого поля
public class UserController extends AbstractController {

    private final UserService userService;

    @GetMapping(value = "/user/current")
    public UserInfoDTO currentUser(@AuthenticationPrincipal UserDetails userDetails) {
        return new UserInfoDTO();
    }

    @PostMapping(value = "/public/signup")
    public void signup(@RequestBody @Validated UserSignupDTO data) throws CoffeeShopExeption {
        userService.signUp(data);
    }

    @PostMapping("/registration")
    public String createUser(User user) {
        try {
            userService.createUser(user);
        } catch (CoffeeShopExeption error) {
//            setErrorMessage(model, error);
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
