package ee.coffee.coffeeshop.services.impl;

import ee.coffee.coffeeshop.entity.Product;
import ee.coffee.coffeeshop.enums.ProductStatus;
import ee.coffee.coffeeshop.repositories.ProductRepository;
import ee.coffee.coffeeshop.services.interfaces.ProductService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;


    @Override
    public void saveProduct(Product product) {
        productRepository.save(product);
    }

    @Override
    public void deleteProduct(Integer id) {
    }
}