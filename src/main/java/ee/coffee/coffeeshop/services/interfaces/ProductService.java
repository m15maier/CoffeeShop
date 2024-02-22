package ee.coffee.coffeeshop.services.interfaces;

import ee.coffee.coffeeshop.entity.Product;
import ee.coffee.coffeeshop.entity.User;

import java.io.IOException;
import java.security.Principal;

public interface ProductService {

    void saveProduct(Product product, Principal principal) throws IOException;
    void deleteProduct(Long product_id);
    Product getProductById(Long product_id);
    User getUserByPrincipal(Principal principal);
    Object listProducts(String title);
}
