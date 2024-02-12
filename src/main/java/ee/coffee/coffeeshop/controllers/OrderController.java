package ee.coffee.coffeeshop.controllers;

import ee.coffee.coffeeshop.models.Order;
import ee.coffee.coffeeshop.services.impl.OrderServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class OrderController {

    private final OrderServiceImpl orderService;

        @GetMapping(value = "/order")
        public ResponseEntity<List<Order>> findAllOrder() {
            List<Order> order = orderService.findAllOrders();
            return ResponseEntity.ok(order);
        }

        @GetMapping(value = "/order/{id}")
        public Order getById(@PathVariable(value = "id") Integer id) {
            Order order = orderService.getById(id);
            return order;
        }

        @PostMapping(value = "/order/save")
        public void saveOrder(@RequestBody Order order) throws IOException {
            orderService.save(order);
        }

        @DeleteMapping(value = "/order/delete")
        public void deleteOrderById(@PathVariable(value = "order_id") Integer id) {
            orderService.deleteById(id);
        }

        @PutMapping(value = "/order/update")
        public void updateOrderById(@PathVariable(value = "order_id") Integer id, @RequestBody Order order) {
            orderService.update(id, order);
        }

    @GetMapping("/order/form")
    public String createOrder(Model model) {
//        model.addAttribute("users", orderService.findAllUsers());
        model.addAttribute("products", orderService.findAllProducts());
        model.addAttribute("order", new Order());
        return "order-form";
    }

    @PostMapping("/order/insert")
    public String insertOrder(Model model, Order order) {
        return "order-view";
    }

    }
