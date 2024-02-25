package ee.coffee.coffeeshop.services.impl;

import ee.coffee.coffeeshop.entity.Image;
import ee.coffee.coffeeshop.entity.Product;
import ee.coffee.coffeeshop.entity.User;
import ee.coffee.coffeeshop.repositories.ImageRepository;
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

    private final ProductRepository productRepository;  // связующий элемент между базой
    private final UserRepository userRepository;
    private final ImageRepository imageRepository;

    public final List<Product> listProducts(String title) {
        if (title != null) return productRepository.findByTitle(title);
        return productRepository.findAll();
    }
    @Override
    public void saveProduct(Product product, Principal principal, MultipartFile file1, MultipartFile file2) throws IOException {
        product = productRepository.save(product);

        addProductImage(product, file1, true);
        addProductImage(product, file2, false);
    }

    private void addProductImage(Product product, MultipartFile file, boolean previewImage) {
        Image image = toImageEntity(file);
        if (image == null) {
            return;
        }
            image.setPreviewImage(previewImage);
            image.setProduct(product);
            imageRepository.save(image);
    }

    @Override
    public User getUserByPrincipal(Principal principal) {
        if (principal == null) return new User();
        return userRepository.findByEmail(principal.getName());
    }


    private Image toImageEntity(MultipartFile file) {
        if (file == null || file.getSize() == 0) {      // если файла нет или он пустой, тогда возвращать null
            return null;
        }

        Image image = new Image();
        image.setName(file.getName());
        image.setOriginalFileName(file.getOriginalFilename());
        image.setContentType(file.getContentType());
        image.setSize(file.getSize());
        try {
            image.setBytes(file.getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
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