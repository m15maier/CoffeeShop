package ee.coffee.coffeeshop.services;

import ee.coffee.coffeeshop.models.Cart;
import ee.coffee.coffeeshop.repositories.CartRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class CartService {

    private final CartRepository cartRepository;

    @Bean
    public List<Cart> getAllCart() {
        return cartRepository.findAll();
    }

    @Bean
    public List<Cart> getAllCartItems() {
        return cartRepository.findAll();
    }


    public Cart getById(Integer id) {
        Optional<Cart> optional = cartRepository.findById(id);
        return optional.orElse(null);
    }


    public void saveCart(Cart cart) throws IOException {
        if (cart == null) {
            return;
        }
        cartRepository.save(cart);
    }


    public void deleteById(Integer id) {
        if (cartRepository.existsById(id)) {
            cartRepository.deleteById(id);
        }
    }

    public void update(Integer id, Cart cart) {
        Optional<Cart> persistCartItemOptional = cartRepository.findById(id);
        if (persistCartItemOptional.isPresent()) {
            Cart persistCart = persistCartItemOptional.get();
            persistCart.setCart_id(cart.getCart_id());
            persistCart.setName(cart.getName());
            persistCart.setPrice(cart.getPrice());
            persistCart.setQuantity(cart.getQuantity());

            cartRepository.save(persistCart);
        }
    }
}
