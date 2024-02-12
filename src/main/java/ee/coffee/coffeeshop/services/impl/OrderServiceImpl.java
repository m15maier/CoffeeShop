package ee.coffee.coffeeshop.services.impl;

import ee.coffee.coffeeshop.models.Order;
import ee.coffee.coffeeshop.repositories.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderServiceImpl {
    private final OrderRepository orderRepository;
    private final UserServiceImpl userService;

    public Order getById(Integer order_id) {
        Optional<Object> optional = Optional.of(orderRepository.findById(order_id));
        return (Order) orderRepository.findById(order_id).orElse(null);
    }

    @Bean
    public List<Order> findAllOrders() {
        return orderRepository.findAll();
    }
    @Bean
    public List<Order> findAllProducts() {
        return orderRepository.findAll();
    }
    @Bean
    public List<Order> findAllUsers() {
        return orderRepository.findAll();
    }

    public void save(Order order) {
        if (order == null) {
            return;
        }
        orderRepository.save(order);
    }


    public void deleteById(Integer id) {
    if (id != null && orderRepository.existsById(id)) {
    orderRepository.deleteById(id);
    }
}

public void update(Integer id, Order order) {
        Optional<Order> persistOrderOptional = orderRepository.findById(id);
        if (persistOrderOptional.isPresent()) {
            Order persistOrder = persistOrderOptional.get();
            persistOrder.setCarts(order.getCarts());
            orderRepository.save(persistOrder);
        }
    }
}

