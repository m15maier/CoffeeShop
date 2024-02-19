package ee.coffee.coffeeshop.services.interfaces;

import ee.coffee.coffeeshop.entity.Cart;
import jakarta.transaction.Transactional;

import java.util.List;

public interface CartService {
    static List<Cart> getListCart(Integer userId) {
        return null;
    }
    static void updateCart(Integer productId, Integer quantity, Integer userId) {
    }
    void addToCart(Integer productId, Integer quantity, Integer userId);

    void deleteFromCart(Integer userId, Integer productId);

    @Transactional
    void addProductToCart(Integer productId, Integer quantity, Integer userId);

    @Transactional
    void deleteProductFromCart(Integer userId, Integer productId);

    @Transactional
    void changeQuantity(Integer productId, Integer useId, Integer quantity);

    @Transactional
    List<Cart> getCartList(Integer userId);
}
