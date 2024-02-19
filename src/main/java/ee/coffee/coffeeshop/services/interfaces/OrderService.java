package ee.coffee.coffeeshop.services.interfaces;

import ee.coffee.coffeeshop.entity.Order;
import ee.coffee.coffeeshop.enums.DeliveryMethod;
import ee.coffee.coffeeshop.enums.OrderStatus;
import ee.coffee.coffeeshop.enums.PaymentMethod;
import jakarta.transaction.Transactional;

import java.util.List;

public interface OrderService {

    void saveOrder(PaymentMethod paymentType, DeliveryMethod deliveryType, Integer userId);

    List<Order> getOrderList();

    Order getOrderById(Integer id);

    @Transactional
    void setOrderStatus(OrderStatus orderStatus, Integer id);

}