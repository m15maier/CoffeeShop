package ee.coffee.coffeeshop.services.interfaces;

import ee.coffee.coffeeshop.entity.Product;

import java.security.Principal;
import java.util.List;

public interface ProductService {

    void saveProduct(Product product, Long id);
    void deleteProduct(Long id);
    List<Product> listProducts();
    Product getProductById(Long id);
    Product getUserByPrincipal(Principal principal);
}
