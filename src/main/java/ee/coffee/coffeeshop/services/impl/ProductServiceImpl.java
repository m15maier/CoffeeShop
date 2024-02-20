package ee.coffee.coffeeshop.services.impl;

import ee.coffee.coffeeshop.entity.Product;
import ee.coffee.coffeeshop.repositories.ProductRepository;
import ee.coffee.coffeeshop.services.interfaces.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductServiceImpl implements ProductService {
    private List<Product> products = new ArrayList<>();
    private long ID = 0;
    public List<Product> productList() {return products; }

    @Override
    public void saveProduct(Product product, Long id) {
        product.setId(++ID);
        products.add(product);
    }

    @Override
    public void deleteProduct(Long id) {
        products.removeIf(product -> product.getId().equals(id));
    }

    @Override
    public List<Product> listProducts() {
        return products;
    }

    @Override
    public Product getProductById(Long id) {
        for (Product product : products) {
            if (product.getId().equals(id)) return product;
        }
        return null;
    }

    @Override
    public Product getUserByPrincipal(Principal principal) {
        return null;
    }
}