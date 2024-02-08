package ee.coffee.coffeeshop.controllers;

import ee.coffee.coffeeshop.models.Product;
import ee.coffee.coffeeshop.services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.security.Principal;
import java.util.Map;


@Controller
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;


    @GetMapping(value = "/")
    public String products(@RequestParam(name = "title", required = false) String title, Principal principal, Model model) {
        model.addAttribute("products", productService.listProducts(title));
        model.addAttribute("user", productService.getUserByPrincipal(principal));
        return "products";
    }

    @GetMapping(value = "/products/{id}")
    public String productInfo(@PathVariable Long id, Model model) {
        model.addAttribute("product", productService.getProductById(id));
        return "product-info";
    }

    @PostMapping(value = "/products/create")
    public String createProduct(Product product, Principal principal) throws IOException {
        productService.saveProduct(principal, product);
        return "redirect:/";

    }

    @DeleteMapping(value = "/products/delete/{id}")
    public String deleteProduct(@PathVariable Long id) {
       productService.deleteProduct(id);
        return "redirect:/";
    }
}
