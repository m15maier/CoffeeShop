package ee.coffee.coffeeshop.services.interfaces;

import ee.coffee.coffeeshop.entity.Cart;
import jakarta.transaction.Transactional;

import java.util.List;

public interface CartService {
    void addProductToCart(Integer productId, Integer quantity, Integer userId);

    void deleteProductFromCart(Integer userId, Integer productId);

}
