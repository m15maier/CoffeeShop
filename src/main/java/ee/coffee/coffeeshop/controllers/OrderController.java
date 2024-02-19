package ee.coffee.coffeeshop.controllers;

import ee.coffee.coffeeshop.dto.OrderDTO;
import ee.coffee.coffeeshop.entity.Order;
import ee.coffee.coffeeshop.entity.Security;
import ee.coffee.coffeeshop.enums.OrderStatus;
import ee.coffee.coffeeshop.services.interfaces.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller     // создаётся контроллер и управляется спрингом
@RequiredArgsConstructor    // позволит получить конструктор с параметром для каждого поля

public class OrderController {

    private final OrderService orderService;

    @PostMapping(value = "/user/order/add")
    public void addOrder(@RequestBody OrderDTO orderDTO, @AuthenticationPrincipal UserDetails userDetails) {
        Integer userId = ((Security) userDetails).getUserId();
        orderService.saveOrder(orderDTO.getPaymentMethod(), orderDTO.getDeliveryMethod(), userId);
    }


    // только с ролью админа

    @GetMapping(value = "/admin/order/list")
    public List<Order> getOrderList() {
        return orderService.getOrderList();
    }

    @GetMapping(value = "/admin/order/{id}")
    public Order getOrder(@PathVariable(name = "id") Integer id) {
        return orderService.getOrderById(id);
    }

    @PutMapping(value = "/admin/order/{id}/set_status/{status}")
    public void setOrderStatus(@PathVariable(name = "status") OrderStatus status, @PathVariable(name = "id") Integer id) {
        orderService.setOrderStatus(status, id);
    }
}

