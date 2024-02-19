package ee.coffee.coffeeshop.controllers;

import ee.coffee.coffeeshop.dto.CartDTO;
import ee.coffee.coffeeshop.entity.Cart;
import ee.coffee.coffeeshop.entity.Security;
import ee.coffee.coffeeshop.services.interfaces.CartService;
import lombok.RequiredArgsConstructor;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Controller     // создаётся контроллер и управляется спрингом
@RequiredArgsConstructor    // позволит получить конструктор с параметром для каждого поля
public class CartController {

    public CartService cartService;

    @GetMapping(value = "/user/cart/get")
    public List<Cart> getCart (@AuthenticationPrincipal UserDetails userDetails) {
        Integer userId = ((Security)userDetails).getUserId();
        return CartService.getListCart(userId);
    }

    @PostMapping(value = "/user/cart/add")
    public void addToCart(@AuthenticationPrincipal UserDetails userDetails, @RequestBody CartDTO cartDTO)  {
    Integer userId = ((Security) userDetails).getUserId();
    cartService.addToCart(cartDTO.getProductId(), cartDTO.getQuantity(), userId);
    }

    @DeleteMapping(value = "/user/cart/delete/{product_id}")
    public void deleteFromCart(@AuthenticationPrincipal UserDetails userDetails, @PathVariable(value = "product_id") Integer productId) {
        Integer userId = ((Security)userDetails).getUserId();
        cartService.deleteFromCart(userId, productId);
    }

    @PutMapping(value = "/user/cart/update")
    public void updateCart(@AuthenticationPrincipal UserDetails userDetails, @PathVariable CartDTO cartDTO) {
        Integer userId = ((Security) userDetails).getUserId();
        CartService.updateCart(cartDTO.getProductId(), cartDTO.getQuantity(), userId);
    }
}
