package ee.coffee.coffeeshop.controllers;

import ee.coffee.coffeeshop.entity.Product;
import ee.coffee.coffeeshop.services.interfaces.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller     // создаётся контроллер и управляется спрингом
@RequiredArgsConstructor    // позволит получить конструктор с параметром для каждого поля
public class ProductController {

    private final ProductService productService;

    // только с ролью админа

    @GetMapping(value = "/products")
    public String allProducts(Model model) {
        return "products";
    }


    @DeleteMapping(value = "/products/delete/{id}")
    public String deleteProduct(@PathVariable Integer id) {
       productService.deleteProduct(id.longValue());
        return "redirect:/";
    }

    @PostMapping(value = "/admin/product/add")
    public void addProduct(@RequestBody Product product) {
        System.out.println(product.getTitle());
        productService.addProduct(product);
    }
}
