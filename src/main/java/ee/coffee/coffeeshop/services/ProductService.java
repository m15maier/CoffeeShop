package ee.coffee.coffeeshop.services;

import ee.coffee.coffeeshop.models.Product;
import ee.coffee.coffeeshop.models.User;
import ee.coffee.coffeeshop.repositories.ProductRepository;
import ee.coffee.coffeeshop.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.security.Principal;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {
    private final ProductRepository productRepository;
    private final UserRepository userRepository;

    public List<Product> listProducts(String title) {
        if (title != null) return productRepository.findByTitle(title);
        return productRepository.findAll();
    }


    public void saveProduct(Principal principal, Product product) throws IOException {
        product.setUser(getUserByPrincipal(principal));

        log.info("Saving new Product. Title: {}; Author email: {}", product.getTitle(),product.getUser().getEmail());
        
        productRepository.save(product);
    }

    public User getUserByPrincipal(Principal principal) {
        if (principal == null) return new User();
        return userRepository.findByEmail(principal.getName());
    }


    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }


    public Product getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }
}