package ee.coffee.coffeeshop.services.interfaces;

import ee.coffee.coffeeshop.entity.Product;
import ee.coffee.coffeeshop.entity.User;

import java.io.IOException;
import java.security.Principal;
import java.util.List;

public interface ProductService {

    void saveProduct(Product product, Principal principal) throws IOException;
    void deleteProduct(Long id);
    Product getProductById(Long id);
    User getUserByPrincipal(Principal principal);
    Object listProducts(String title);
}
