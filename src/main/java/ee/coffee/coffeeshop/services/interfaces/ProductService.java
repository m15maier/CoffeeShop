package ee.coffee.coffeeshop.services.interfaces;

import ee.coffee.coffeeshop.entity.Product;
import ee.coffee.coffeeshop.entity.User;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.security.Principal;

public interface ProductService {

    void saveProduct(Product product, Principal principal, MultipartFile file1,  MultipartFile file2) throws IOException;
    void deleteProduct(Long product_id);
    Product getProductById(Long product_id);
    User getUserByPrincipal(Principal principal);
    Object listProducts(String title);
}
