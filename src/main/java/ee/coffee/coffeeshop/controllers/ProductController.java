package ee.coffee.coffeeshop.controllers;

import ee.coffee.coffeeshop.entity.Product;
import ee.coffee.coffeeshop.services.interfaces.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller     // создаётся контроллер и управляется спрингом
@RequiredArgsConstructor    // позволит получить конструктор с параметром для каждого поля
public class ProductController {

    private final ProductService productService;

    @GetMapping(value = "/products/{id}")
    public Product productById(@PathVariable Integer id) {
        Product product = productService.getProductById(id);
        return product;
    }

    @DeleteMapping(value = "/products/delete/{id}")
    public String deleteProduct(@PathVariable Integer id) {
       productService.deleteProduct(id);
        return "redirect:/";
    }

// только с ролью админа
    @PostMapping(value = "/admin/product/save")
    public void saveProduct(@RequestBody Product product) {
        System.out.println(product.getTitle());
        productService.saveProduct(product);
    }


    @GetMapping(value = "/admin/product/active/{id}")
    public void activeProduct (@PathVariable Integer id) {
        productService.activeById(id);
    }


    @PutMapping(value = "/admin/product/inactive/{id}")
    public void inactiveProduct (@PathVariable Integer id) {
        productService.inactiveById(id);
    }


    @PutMapping(value = "/admin/product_list")
    public List<Product> getProductList() {
        return productService.getListOfAllProducts();
    }
}
