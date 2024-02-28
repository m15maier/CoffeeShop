package ee.coffee.coffeeshop.controllers;

import ee.coffee.coffeeshop.entity.Product;
import ee.coffee.coffeeshop.services.impl.UserDetailsServiceImpl;
import ee.coffee.coffeeshop.services.interfaces.CoffeeShopExeption;
import ee.coffee.coffeeshop.services.interfaces.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


import static ee.coffee.coffeeshop.services.impl.UserDetailsServiceImpl.getUser;

@Controller     // создаётся контроллер и управляется спрингом
@RequiredArgsConstructor    // позволит получить конструктор с параметром для каждого поля
public class AdminProductController extends AbstractController {

    static final String LIST = "/admin/product/list";
    static final String EDIT = "/admin/product/edit";
    private final ProductService productService;

    @GetMapping(LIST)
    public String list(Model model) {
        setList(model, productService.listProducts());
        return LIST;
    }

    @GetMapping(EDIT + "/{id}")
    public String edit(Model model, @PathVariable Long id) {
        Product product = id == NEW_ENTITY_ID ? new Product() : productService.getProductById(id);
        model.addAttribute(product);
        return EDIT;
    }
    
    @PostMapping( EDIT + "/{id}")
    public String save(Model model,
        @AuthenticationPrincipal UserDetails userDetails,
        Product product,
        @RequestParam("file1") MultipartFile file1,
        @RequestParam("file2") MultipartFile file2) {
        try {
            productService.saveProduct(getUser(userDetails), product, file1, file2);
        } catch(CoffeeShopExeption e) {
            model.addAttribute(product);
            setErrorMessage(model, e);
            return EDIT;
        }
        return redirect(LIST);
    }
    @PostMapping("/admin/product/delete/{id}")
    public String delete(@PathVariable Long id) {
        productService.deleteProduct(id);
        return redirect(LIST);
    }
}
