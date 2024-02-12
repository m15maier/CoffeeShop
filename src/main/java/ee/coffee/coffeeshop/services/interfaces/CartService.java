package ee.coffee.coffeeshop.services.interfaces;

import ee.coffee.coffeeshop.models.Cart;
import ee.coffee.coffeeshop.models.User;

import java.util.Collection;
import java.util.List;

public interface CartService {
    List<Cart> getAllCartItems();
    Cart getById(Integer id);
    List<Cart> getAllCart();
    Collection<Cart> getAllByUsers(User user);
    void save(Cart cart);
    void saveCart(Cart cart);
    void deleteById(Integer id);
    void update (Integer id, Cart cart);

}
