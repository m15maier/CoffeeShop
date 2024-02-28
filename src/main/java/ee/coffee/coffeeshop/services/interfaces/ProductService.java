package ee.coffee.coffeeshop.services.interfaces;

import ee.coffee.coffeeshop.entity.Product;
import ee.coffee.coffeeshop.entity.User;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ProductService {

    void saveProduct(User user, Product product, MultipartFile file1,  MultipartFile file2)
            throws CoffeeShopExeption;
    
    void deleteProduct(Long id);
    
    Product getProductById(Long id);
    
    List<Product>  listProducts(String title);
    
    List<Product> listProducts();
}
