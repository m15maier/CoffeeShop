package ee.coffee.coffeeshop.services.interfaces;

import ee.coffee.coffeeshop.entity.Cart;
import ee.coffee.coffeeshop.entity.User;

public interface CartService {
    void addProductToCart(Long productId, Integer quantity, User user);
    
    void deleteProductFromCart(User user, Long productId);
    
    Cart getCart(User user);
    
    void updateProductQuantity(Long productId, Integer quantity, User user);
}
