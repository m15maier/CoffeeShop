package ee.coffee.coffeeshop.services.interfaces;

public interface CartService {
    void addProductToCart(Long productId, Long  quantity, Long userId);
    void deleteProductFromCart(Long productId, Long userId);

}
