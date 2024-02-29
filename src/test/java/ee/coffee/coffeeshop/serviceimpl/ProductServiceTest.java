package ee.coffee.coffeeshop.serviceimpl;

import ee.coffee.coffeeshop.entity.Product;
import ee.coffee.coffeeshop.repositories.ProductRepository;
import ee.coffee.coffeeshop.services.impl.ProductServiceImpl;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {
    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductServiceImpl productService;

    @Test
    public void saveProductTest() {
        Product product = new Product();
        product.setTitle("New Coffee");
        product.setId(9L);



    }
}
