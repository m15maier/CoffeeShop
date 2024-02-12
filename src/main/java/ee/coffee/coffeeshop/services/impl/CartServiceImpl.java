package ee.coffee.coffeeshop.services.impl;

import ee.coffee.coffeeshop.models.Cart;
import ee.coffee.coffeeshop.models.User;
import ee.coffee.coffeeshop.repositories.CartRepository;
import ee.coffee.coffeeshop.services.interfaces.CartService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class CartServiceImpl implements CartService {

    private final CartRepository cartRepository;

    @Override
    public List<Cart> getAllCart() {
        return cartRepository.findAll();
    }

    @Override
    public Collection<Cart> getAllByUsers(User user) {
        return null;
    }

    @Override
    public void save(Cart cart) {

    }

    @Override
    public List<Cart> getAllCartItems() {
        return cartRepository.findAll();
    }

    @Override
    public Cart getById(Integer id) {
        Optional<Cart> optional = cartRepository.findById(id);
        return optional.orElse(null);
    }

    @Override
    public void saveCart(Cart cart) {
        if (cart == null) {
            return;
        }
        cartRepository.save(cart);
    }

    @Override
    public void deleteById(Integer id) {
        if (cartRepository.existsById(id)) {
            cartRepository.deleteById(id);
        }
    }
    @Override
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
