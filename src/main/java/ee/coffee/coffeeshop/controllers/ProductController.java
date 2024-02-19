package ee.coffee.coffeeshop.controllers;

import ee.coffee.coffeeshop.entity.Product;
import ee.coffee.coffeeshop.services.interfaces.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller     // создаётся контроллер и управляется спрингом
@RequiredArgsConstructor    // позволит получить конструктор с параметром для каждого поля
public class ProductController {

    private final ProductService productService;

    // только с ролью админа

    @DeleteMapping(value = "/products/delete/{id}")
    public String deleteProduct(@PathVariable Integer id) {
       productService.deleteProduct(id);
        return "redirect:/";
    }


    @PostMapping(value = "/admin/product/add")
    public void addProduct(@RequestBody Product product) {
        System.out.println(product.getTitle());
        productService.addProduct(product);
    }
}
