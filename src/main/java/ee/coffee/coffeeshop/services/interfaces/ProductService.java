package ee.coffee.coffeeshop.services.interfaces;

import ee.coffee.coffeeshop.entity.Product;
import java.util.List;

public interface ProductService {
    void saveProduct(Product product);

    void deleteProduct(Integer id);

    Product getProductById(Integer id);

    void inactiveById(Integer id);

    List<Product> getListOfAllProducts();

    void activeById(Integer id);
}
