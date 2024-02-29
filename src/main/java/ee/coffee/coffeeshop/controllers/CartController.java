package ee.coffee.coffeeshop.controllers;

import ee.coffee.coffeeshop.entity.Cart;
import ee.coffee.coffeeshop.entity.User;
import ee.coffee.coffeeshop.services.impl.UserDetailsServiceImpl;
import ee.coffee.coffeeshop.services.interfaces.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller     // создаётся контроллер и управляется спрингом
@RequiredArgsConstructor    // позволит получить конструктор с параметром для каждого поля
public class CartController extends AbstractController {

    static final String CART = "/user/cart";
    
    private final CartService cartService;
    
    @GetMapping(CART)
    public String getCart(Model model, @AuthenticationPrincipal UserDetails userDetails) {
        User user = UserDetailsServiceImpl.getUser(userDetails);
        Cart cart = cartService.getCart(user);
        model.addAttribute(cart);
        return CART;
    }
    
    @PostMapping(CART + "/add/{productId}")
    public String addProduct(@AuthenticationPrincipal UserDetails userDetails,
        @PathVariable(value = "productId") Long productId,
        @RequestParam("quantity") Integer quantity) {
        User user = UserDetailsServiceImpl.getUser(userDetails);
        cartService.addProductToCart(productId, quantity, user);
        return redirect(CART);
    }
    
    @PostMapping(CART + "/update/{productId}")
    public String updateProductQuantity(Model model, @AuthenticationPrincipal UserDetails userDetails,
        @PathVariable(value = "productId") Long productId,
        @RequestParam("quantity") Integer quantity) {
        User user = UserDetailsServiceImpl.getUser(userDetails);
        cartService.updateProductQuantity(productId, quantity, user);
        return redirect(CART);
    }

    @PostMapping(CART + "/delete/{productId}")
    public String deleteProduct(@AuthenticationPrincipal UserDetails userDetails,
        @PathVariable(value = "productId") Long productId) {
        User user = UserDetailsServiceImpl.getUser(userDetails);
        cartService.deleteProductFromCart(user, productId);
        return redirect(CART);
    }
}
