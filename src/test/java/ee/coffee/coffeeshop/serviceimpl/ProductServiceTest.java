package ee.coffee.coffeeshop.serviceimpl;

import ee.coffee.coffeeshop.entity.Product;
<<<<<<< HEAD
import ee.coffee.coffeeshop.entity.User;
=======
>>>>>>> сделала много всего, добавила тест
import ee.coffee.coffeeshop.repositories.ProductRepository;
import ee.coffee.coffeeshop.services.impl.ProductServiceImpl;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

<<<<<<< HEAD
import static junit.framework.TestCase.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

=======
>>>>>>> сделала много всего, добавила тест

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {
    @Mock
    private ProductRepository productRepository;

    @InjectMocks
<<<<<<< HEAD
    private ProductServiceImpl productServiceImpl;

    @Test
    public void saveProductTest() {
        Product newProduct = new Product();
        newProduct.setTitle("New Coffee");
        newProduct.setId(9L);

        productServiceImpl.saveProduct(newProduct);
        assertEquals(newProduct, new Product());

        verify(productRepository, times(1)).save(newProduct);
=======
    private ProductServiceImpl productService;

    @Test
    public void saveProductTest() {
        Product product = new Product();
        product.setTitle("New Coffee");
        product.setId(9L);



>>>>>>> сделала много всего, добавила тест
    }
}
