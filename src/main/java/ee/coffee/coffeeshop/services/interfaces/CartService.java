package ee.coffee.coffeeshop.services.interfaces;

import ee.coffee.coffeeshop.entity.User;

public interface CartService {
    void addProductToCart(Long productId, Long  quantity, User userId);
    void deleteProductFromCart(Long productId, Long userId);

}
