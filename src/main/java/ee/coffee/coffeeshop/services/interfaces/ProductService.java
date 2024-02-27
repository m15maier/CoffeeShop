package ee.coffee.coffeeshop.services.interfaces;

import ee.coffee.coffeeshop.entity.Product;
import ee.coffee.coffeeshop.entity.User;
import org.springframework.web.multipart.MultipartFile;

import java.security.Principal;
import java.util.List;

public interface ProductService {

    void saveProduct(Product product, MultipartFile file1,  MultipartFile file2)
            throws CoffeeShopExeption;
    void deleteProduct(Long product_id);
    Product getProductById(Long product_id);
    User getUserByPrincipal(Principal principal);
    Object listProducts(String title);
    
    List<Product> listProducts();
}
