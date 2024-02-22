package ee.coffee.coffeeshop.controllers;

import ee.coffee.coffeeshop.entity.Product;
import ee.coffee.coffeeshop.services.interfaces.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.security.Principal;

@Controller     // создаётся контроллер и управляется спрингом
@RequiredArgsConstructor    // позволит получить конструктор с параметром для каждого поля
public class ProductController {

    @Autowired
    private final ProductService productService;


//    @GetMapping(value = "/")
//    public String home(@RequestParam(name = "product_title", required = false) String title, Principal principal, Model model) {
//        model.addAttribute("products", productService.listProducts(title));
//        model.addAttribute("user", productService.getUserByPrincipal(principal));
//        return "home";
//    }

    @GetMapping(value = "/")
    public String products(@RequestParam(name = "product_title", required = false) String title, Principal principal, Model model) {
        model.addAttribute("products", productService.listProducts(title));
        model.addAttribute("user", productService.getUserByPrincipal(principal));
        return "products";
    }

    @GetMapping(value = "/product/{id}")
    public String productInfo(@PathVariable Long id, Model model) {
        model.addAttribute("product", productService.getProductById(id));
        return "product-info";
    }

    @PostMapping(value = "/product/create")
    public String createProduct (Product product, Principal principal) throws IOException{
        productService.saveProduct(product, principal);
        return "redirect:/";
    }
    // только с ролью админа

//    @PreAuthorize("hasAuthority('ADMIN')")
//    @PostMapping(value = "/products/create")
//    public String createProduct(Product product, Product principal) throws IOException {
//        productService.saveProduct(principal, product);
//        return "redirect:/";
//    }

//    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping(value = "/product/delete/{id}")
    public String deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return "redirect:/";
    }
}
