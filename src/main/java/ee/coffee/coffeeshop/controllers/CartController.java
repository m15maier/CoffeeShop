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
    @PostMapping(value = "/user/cart/add")
    public void addProductToCart(@AuthenticationPrincipal UserDetails userDetails, @RequestBody CartDTO cartDTO) {
        Integer userId = ((Security) userDetails).getUserId();
        cartService.addProductToCart(cartDTO.getProductId(), cartDTO.getQuantity(), userId);
    }

    @DeleteMapping(value = "/user/cart/delete/{product_id}")
    public void deleteProductFromCart(@AuthenticationPrincipal UserDetails userDetails, @PathVariable(value = "product_id") Integer productId) {
        Integer userId = ((Security) userDetails).getUserId();
        cartService.deleteProductFromCart(userId, productId);
    }
}
