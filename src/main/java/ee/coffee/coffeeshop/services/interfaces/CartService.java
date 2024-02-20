package ee.coffee.coffeeshop.services.interfaces;

public interface CartService {
    void addProductToCart(Long productId, Integer quantity, Integer userId);

    void deleteProductFromCart(Integer userId, Integer productId);

}
