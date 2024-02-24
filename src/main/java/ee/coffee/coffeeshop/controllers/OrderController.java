package ee.coffee.coffeeshop.controllers;

import ee.coffee.coffeeshop.dto.OrderDTO;
import ee.coffee.coffeeshop.entity.Order;
import ee.coffee.coffeeshop.entity.Security;
import ee.coffee.coffeeshop.enums.OrderStatus;
import ee.coffee.coffeeshop.services.interfaces.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
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
        Integer userId = Math.toIntExact(((Security) userDetails).getId());
        orderService.saveOrder(orderDTO.getPaymentMethod(), orderDTO.getDeliveryMethod(), userId);
    }

    // только с ролью админа
    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping(value = "/admin/order/list")
    public List<Order> getOrderList() {
        return orderService.getOrderList();
    }
    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping(value = "/admin/order/{id}")
    public Order getOrderById(@PathVariable(name = "id") Long id) {
        return orderService.getOrderById(id);
    }
    @PreAuthorize("hasAuthority('ADMIN')")
    @PutMapping(value = "/admin/order/{id}/set_status/{order_status}")
    public void setOrderStatus(@PathVariable(name = "order_status") OrderStatus orderStatus, @PathVariable(name = "id") Long id, @PathVariable String order_status) {
        orderService.setOrderStatus(orderStatus, id);
    }
}


