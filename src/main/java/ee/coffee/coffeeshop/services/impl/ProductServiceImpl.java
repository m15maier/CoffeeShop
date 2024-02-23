package ee.coffee.coffeeshop.services.impl;

import ee.coffee.coffeeshop.entity.Image;
import ee.coffee.coffeeshop.entity.Product;
import ee.coffee.coffeeshop.entity.User;
import ee.coffee.coffeeshop.repositories.ProductRepository;
import ee.coffee.coffeeshop.repositories.UserRepository;
import ee.coffee.coffeeshop.services.interfaces.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.security.Principal;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final UserRepository userRepository;

    public final List<Product> listProducts(String title) {
        if (title != null) return productRepository.findByTitle(title);
        return productRepository.findAll();
    }
    @Override
    public void saveProduct(Product product, Principal principal, MultipartFile file1, MultipartFile file2) throws IOException {
        Image image1;
        Image image2;

        if (file1.getSize() != 0) {
            image1 = toImageEntity(file1);
            image1.set_preview_image(true);
            product.addImageToProduct(image1);
        }
        if (file2.getSize() != 0) {
            image2 = toImageEntity(file1);
            product.addImageToProduct(image2);
        }

        product.setUser(getUserByPrincipal(principal));

        log.info("Saving new Product {}", product.getTitle());
        Product productFromDb = productRepository.save(product);
        productFromDb.setPreview_image_id(productFromDb.getImages().get(0).getImage_id());
        productRepository.save(product);
    }


    @Override
    public User getUserByPrincipal(Principal principal) {
        if (principal == null) return new User();
        return userRepository.findByEmail(principal.getName());
    }


    private Image toImageEntity(MultipartFile file) throws IOException {
        Image image = new Image();
        image.setImage_name(file.getName());
        image.setOriginal_file_name(file.getOriginalFilename());
        image.setContent_type(file.getContentType());
        image.setSize(file.getSize());
        image.setBytes(file.getBytes());
        return image;
    }


    @Override
    public void deleteProduct(Long product_id) {
        productRepository.deleteById(Math.toIntExact(product_id));
    }

    @Override
    public Product getProductById(Long product_id) {
        return productRepository.findById(Math.toIntExact(product_id)).orElse(null);
    }
}