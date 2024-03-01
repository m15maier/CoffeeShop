package ee.coffee.coffeeshop.controllers;

import ee.coffee.coffeeshop.dto.UserDTO;
import ee.coffee.coffeeshop.entity.User;
import ee.coffee.coffeeshop.enums.Role;
import ee.coffee.coffeeshop.services.interfaces.CoffeeShopExeption;
import ee.coffee.coffeeshop.services.interfaces.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@Controller
@RequiredArgsConstructor
public class AdminUserController extends AbstractController {
    
    static final String LIST = "/admin/user/list";
    static final String EDIT = "/admin/user/edit";
    static final String USER = "user";
    
    private final UserService userService;
    
    @GetMapping(LIST)
    public String list(Model model) {
        setList(model, userService.list());
        return LIST;
    }
    
    @GetMapping(EDIT + "/{id}")
    public String edit(Model model, @PathVariable Long id) {
        User user = userService.getById(id);
        UserDTO dto = new UserDTO();
        BeanUtils.copyProperties(user, dto);
        model.addAttribute(USER, dto);
        addEnumConstants(model, Role.class);
        return EDIT;
    }
    
    protected void addEnumConstants(Model model, Class<? extends Enum<?>> type) {
        model.addAttribute(type.getSimpleName(), type.getEnumConstants());
    }
    
    @PostMapping( EDIT + "/{id}")
    public String save(Model model, @ModelAttribute(USER) @Valid UserDTO dto, BindingResult bindingResult) {
        if(checkErrors(model, bindingResult)) {
            addEnumConstants(model, Role.class);
            return EDIT;
        }
        try {
            userService.updateUser(dto);
        } catch(CoffeeShopExeption e) {
            setErrorMessage(model, e);
            return EDIT;
        }
        return redirect(LIST);
    }
    
    @PostMapping("/admin/user/delete/{id}")
    public String delete(@PathVariable Long id) {
        return doWithRedirect(LIST, () -> userService.deleteUser(id));
    }
}
