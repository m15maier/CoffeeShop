package ee.coffee.coffeeshop.controllers;

import ee.coffee.coffeeshop.models.Cart;
import ee.coffee.coffeeshop.services.impl.CartServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;


@Controller
@RequiredArgsConstructor

public class CartController {

    private final CartServiceImpl cartService;

    @GetMapping(value = "/cart")
    public ResponseEntity<List<Cart>> getAllCart() {
        List<Cart> cart = cartService.getAllCart();
        return ResponseEntity.ok(cart);
    }

    @GetMapping(value = "/cart/id")
    public Cart getById(@PathVariable(value = "cart_id") Integer id) {
        Cart cart = cartService.getById(id);
        return cart;
    }

    @PostMapping(value = "/save")
    public void saveCart(@RequestBody Cart cart) throws IOException {
        cartService.saveCart(cart);
    }

    @DeleteMapping(value = "/delete")
    public void deleteById(@PathVariable(value = "cart_id") Integer id) {
        cartService.deleteById(id);
    }

    @PutMapping(value = "/update")
    public void updateCartById(@PathVariable(value = "cart_id") Integer id, @RequestBody Cart cart) {
        cartService.update(id, cart);
    }
}
