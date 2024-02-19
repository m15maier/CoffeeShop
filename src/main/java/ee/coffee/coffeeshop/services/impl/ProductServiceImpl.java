package ee.coffee.coffeeshop.services.impl;

import ee.coffee.coffeeshop.entity.Product;
import ee.coffee.coffeeshop.enums.ProductStatus;
import ee.coffee.coffeeshop.repositories.ProductRepository;
import ee.coffee.coffeeshop.services.interfaces.ProductService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;


    @Override
    public Product getProductById(Integer id) {
        Optional<Product> optional = productRepository.findById(id);
        if (optional.isPresent()) {
            return optional.get();
        } else {
            throw new EntityNotFoundException("product " + id + " not found");
        }
    }

    @Override
    public void saveProduct(Product product) {
        productRepository.save(product);
    }

    @Override
    public void deleteProduct(Integer id) {
    }

    @Override
    public void activeById(Integer id) {
        Product product = getProductById(id);
        if (product == null) {
            return;
        }
        product.setStatus(ProductStatus.ACTIVE);
        productRepository.save(product);
    }


    @Override
    public void inactiveById(Integer id) {
        Product product = getProductById(id);
        if (product == null) {
            return;
        }
        product.setStatus(ProductStatus.INACTIVE);
        productRepository.save(product);
    }

    @Override
    public List<Product> getListOfAllProducts() {
        return null;
    }
}