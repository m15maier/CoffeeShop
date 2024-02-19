package ee.coffee.coffeeshop.services.interfaces;

import ee.coffee.coffeeshop.entity.Product;
import java.util.List;

public interface ProductService {
    void saveProduct(Product product);
    void deleteProduct(Integer id);
}
