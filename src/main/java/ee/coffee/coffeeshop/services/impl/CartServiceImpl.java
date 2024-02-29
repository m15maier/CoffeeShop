package ee.coffee.coffeeshop.services.impl;

import ee.coffee.coffeeshop.entity.Cart;
import ee.coffee.coffeeshop.entity.CartProduct;
import ee.coffee.coffeeshop.entity.Product;
import ee.coffee.coffeeshop.entity.User;
import ee.coffee.coffeeshop.repositories.CartProductRepository;
import ee.coffee.coffeeshop.repositories.CartRepository;
import ee.coffee.coffeeshop.repositories.ProductRepository;
import ee.coffee.coffeeshop.services.interfaces.CartService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class CartServiceImpl implements CartService {

    private final CartRepository cartRepository;
    private final CartProductRepository cartProductRepository;
    private final ProductRepository productRepository;

    // метод, который добавляет продукт в корзину пользователя

    @Override
    public void addProductToCart(Long productId, Integer quantity, User user) {
        Cart cart = getCart(user);
        // найти Product и соответствующий элемент CartProduct
        // создать новый если такого нет
        Product product = productRepository.findById(productId).orElseThrow();
        CartProduct cartProduct = cart.findCartProduct(product.getId());
        if(cartProduct == null) {
            cartProduct = new CartProduct();
            cartProduct.setCart(cart);
            cartProduct.setProduct(product);
        }
        cartProduct.setQuantity(cartProduct.getQuantity() + quantity);
        cartProductRepository.save(cartProduct);
    }

    @Override
    public void deleteProductFromCart(User user, Long productId) {
        Cart cart = getCart(user);
        CartProduct cartProduct = cart.findCartProduct(productId);
        if(cartProduct != null) {
            cart.getCartProducts().remove(cartProduct);
            cartProductRepository.delete(cartProduct);
        }
    }
    
    @Override public Cart getCart(User user) {
        // no user - no cart
        if(user == null) {
            return null;
        }
        // найти существующую корзину, создать новую если не нашли
        Cart cart = cartRepository.findByUser(user);
        if(cart == null) {
            cart = new Cart();
            cart.setUser(user);
            cart = cartRepository.save(cart);
        }
        return cart;
    }
    
    @Override public void updateProductQuantity(Long productId, Integer quantity, User user) {
        Cart cart = getCart(user);
        CartProduct cartProduct = cart.findCartProduct(productId);
        if(cartProduct != null) {
            if(quantity > 0) {
                cartProduct.setQuantity(quantity);
                cartProductRepository.save(cartProduct);
            } else {
                cart.getCartProducts().remove(cartProduct);
                cartProductRepository.delete(cartProduct);
            }
        }
    }
}
