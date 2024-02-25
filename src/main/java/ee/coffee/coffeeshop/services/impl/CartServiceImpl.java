package ee.coffee.coffeeshop.services.impl;

import ee.coffee.coffeeshop.entity.Cart;
import ee.coffee.coffeeshop.entity.Product;
import ee.coffee.coffeeshop.entity.User;
import ee.coffee.coffeeshop.repositories.CartRepository;
import ee.coffee.coffeeshop.repositories.ProductRepository;
import ee.coffee.coffeeshop.repositories.UserRepository;
import ee.coffee.coffeeshop.services.interfaces.CartService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class CartServiceImpl implements CartService {

    private final CartRepository cartRepository;
    private final UserRepository userRepository;
    private final ProductRepository productRepository;

    // метод, который добавляет продукт в корзину пользователя

    @Override
    @Transactional
   public void addProductToCart(Long productId, Long quantity, Long userId) {
        // метод принимает три параметра

        Cart cartEntity = new Cart();   // создаётся новый продукт
//        cartEntity.setQuantity(cartEntity.getQuantity());   // устанавливается количество продукта в этой корзине

        Optional<User> userOptional = userRepository.findById(Long.valueOf(userId));     // поиск пользователя по идентификатору
        if (!userOptional.isPresent()) {    // если не найден, то выбрасывается исключение
            throw new EntityNotFoundException("not found");
    }
        cartEntity.setUser(userOptional.get());


        Optional<Product> productOptional = productRepository.findById(Math.toIntExact(productId));
        if (!productOptional.isPresent()) {     // поиск продукта
            throw new EntityNotFoundException("not found");     // если не найден, то выбрасывается исключение
    }
//        cartEntity.setProducts(productOptional.get());   // Если пользователь и продукт найдены, то устанавливается пользователь и продукт для объекта Cart, после чего этот объект сохраняется в репозитории корзины cartRepository.
//        cartRepository.save(cartEntity);
    }


    @Override
    @Transactional
    public void deleteProductFromCart(Long user_id, Long product_id) {
        Cart cartToDelete = CartRepository.getByQuantityAndUser_idAndProduct_id(Math.toIntExact(user_id), Math.toIntExact(product_id));
        assert cartToDelete != null;
        cartRepository.delete(cartToDelete);
    }
}