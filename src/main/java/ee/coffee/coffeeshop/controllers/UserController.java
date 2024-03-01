package ee.coffee.coffeeshop.controllers;


import ee.coffee.coffeeshop.entity.User;
import ee.coffee.coffeeshop.services.interfaces.CoffeeShopExeption;
import ee.coffee.coffeeshop.services.interfaces.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class UserController extends AbstractController {

    private final UserService userService;

    // получает идентификатор пользователя из объекта UserDetails
    @GetMapping(value = "/login")
    public String login() {
        return "login";
    }

    @GetMapping(value = "/registration")
    public String registration() {
        return "registration";
    }

    @PostMapping("/registration")
    public String createUser(User user, Model model) {
        try {
            userService.createUser(user);
        } catch (CoffeeShopExeption error) {
            setErrorMessage(model, error);
            return "registration";
        }
        return redirect("/login?signUpOk");
    }

    @GetMapping("/user/info")
    public String userInfo(@PathVariable("user") User user, Model model) {
        model.addAttribute("user", user);
        return "user-info";
    }
}
