package ee.coffee.coffeeshop.services.impl;

import ee.coffee.coffeeshop.entity.Image;
import ee.coffee.coffeeshop.entity.Product;
import ee.coffee.coffeeshop.entity.User;
import ee.coffee.coffeeshop.repositories.ImageRepository;
import ee.coffee.coffeeshop.repositories.ProductRepository;
import ee.coffee.coffeeshop.repositories.UserRepository;
import ee.coffee.coffeeshop.services.interfaces.CoffeeShopExeption;
import ee.coffee.coffeeshop.services.interfaces.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;  // связующий элемент между базой
    private final UserRepository userRepository;
    private final ImageRepository imageRepository;
    
    @Override
    public final List<Product> listProducts(String title) {
        if (title != null) return productRepository.findByTitle(title);
        return productRepository.findAll();
    }
    
    @Override
    public List<Product> listProducts()
    {
        return productRepository.findAll();
    }
    
    @Override
    public void saveProduct(User user, Product product, MultipartFile file1, MultipartFile file2)
    throws CoffeeShopExeption {
        checkNotEmpty(product.getTitle(), "title");
        product.setUser(user);
        product = productRepository.save(product);
        Image previewImage = addProductImage(product, file1, true);
        if(previewImage != null) {
            product.setPreviewImage(previewImage);
            product = productRepository.save(product);
        }
        addProductImage(product, file2, false);
    }

    private void checkNotEmpty(String value, String name) throws CoffeeShopExeption
    {
        if(!StringUtils.hasText(value)) {
            throw new CoffeeShopExeption("Empty value not allowed for '" + name + "'");
        }
    }

    private Image addProductImage(Product product, MultipartFile file, boolean previewImage) {
        Image image = toImageEntity(file);
        if (image == null) {
            return null;
        }
        image.setPreviewImage(previewImage);
        image.setProduct(product);
        return imageRepository.save(image);
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
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public Product getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }
}
