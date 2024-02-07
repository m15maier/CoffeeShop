package ee.coffee.coffeeshop.controllers;

import ee.coffee.coffeeshop.models.Product;
import ee.coffee.coffeeshop.services.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@Controller
@RequiredArgsConstructor
@RequestMapping
public class ProductController {

    private final ProductService productService;


    @GetMapping(value ="/")
    public String products(@RequestParam(name = "title", required = false) String title, Model model) {
        model.addAttribute("products", productService.listProducts(title));
        return "products";
    }


    @GetMapping(value = "/products/{id}")
    public String productInfo(@PathVariable Long id, Model model) {
        model.addAttribute("product", productService.getProductById(id));
        return "product-info";
    }

    @PostMapping(value ="/products/create")
    public String createProduct(Product product) {
        productService.saveProduct(product);
        return "redirect:/";

    }

    @DeleteMapping(value = "/products/delete/{id}")
    public String deleteProduct(@PathVariable Long id) {
       productService.deleteProduct(id);
        return "redirect:/";
    }

}
