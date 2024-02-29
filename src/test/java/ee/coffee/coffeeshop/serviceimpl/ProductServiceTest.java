package ee.coffee.coffeeshop.serviceimpl;

import ee.coffee.coffeeshop.entity.Product;
import ee.coffee.coffeeshop.entity.User;
import ee.coffee.coffeeshop.repositories.ProductRepository;
import ee.coffee.coffeeshop.services.impl.ProductServiceImpl;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;


@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {
    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductServiceImpl productServiceImpl;

    @Test
    public void saveProductTest() {
        Product newProduct = new Product();
        newProduct.setTitle("New Coffee");
        newProduct.setId(9L);

        productServiceImpl.saveProduct(newProduct);
        assertEquals(newProduct, new Product());

        verify(productRepository, times(1)).save(newProduct);
    }
}
