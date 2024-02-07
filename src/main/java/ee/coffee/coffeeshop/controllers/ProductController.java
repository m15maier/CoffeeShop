package ee.coffee.coffeeshop.controllers;

import ee.coffee.coffeeshop.models.Product;
import ee.coffee.coffeeshop.services.ProductService;
import org.springframework.ui.Model;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
@RequestMapping
public class ProductController {

    private final ProductService productService;


    @GetMapping("/")
    public String products(@RequestParam(name = "title", required = false) String title, Model model) {
        model.addAttribute("products", productService.listProducts(title));
        return "products";
    }


    @GetMapping("/products/{id}")
    public String productInfo(@PathVariable Long id, Model model) {
        model.addAttribute("product", productService.getProductById(id));
        return "product-info";
    }

    @PostMapping("/products/create")
    public String createProduct(Product product) {
        productService.saveProduct(product);
        return "redirect:/";

    }

    @DeleteMapping("/products/delete/{id}")
    public String deleteProduct(@PathVariable Long id) {
       productService.deleteProduct(id);
        return "redirect:/";
    }

}
