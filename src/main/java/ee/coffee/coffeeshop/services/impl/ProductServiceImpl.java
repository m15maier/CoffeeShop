package ee.coffee.coffeeshop.services.impl;

import ee.coffee.coffeeshop.entity.EntityUtil;
import ee.coffee.coffeeshop.entity.Image;
import ee.coffee.coffeeshop.entity.Product;
import ee.coffee.coffeeshop.entity.User;
import ee.coffee.coffeeshop.repositories.ImageRepository;
import ee.coffee.coffeeshop.repositories.ProductRepository;
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
    private final ImageRepository imageRepository;
    
    @Override
    public List<Product> listProducts() {
        return productRepository.findAll();
    }
    
    @Override
    public Product saveProduct(User user, Product product, MultipartFile previewImageFile)
    throws CoffeeShopExeption {
        product.setUser(user);
        checkNotEmpty(product.getTitle(), "title");
        // надо сохранить текущий previewImage, если не указали новый
        Image previewImage = toImageEntity(previewImageFile);
        if(previewImage != null) {
            product.setPreviewImage(imageRepository.save(previewImage));
        } else if(!EntityUtil.isNew(product)) {
            Product dbProduct = productRepository.findById(product.getId()).orElseThrow();
            product.setPreviewImage(dbProduct.getPreviewImage());
        }
        product = productRepository.save(product);
        return product;
    }

    private void checkNotEmpty(String value, String name) throws CoffeeShopExeption
    {
        if(!StringUtils.hasText(value)) {
            throw new CoffeeShopExeption("Empty value not allowed for '" + name + "'");
        }
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
        // удаляем продукт и изображение
        Product product = productRepository.findById(id).orElseThrow();
        Image image = product.getPreviewImage();
        productRepository.delete(product);
        if(image != null) {
            imageRepository.delete(image);
        }
    }

    @Override
    public Product getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }
}
