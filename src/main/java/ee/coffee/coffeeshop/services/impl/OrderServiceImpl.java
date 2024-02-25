package ee.coffee.coffeeshop.services.impl;

import ee.coffee.coffeeshop.entity.Cart;
import ee.coffee.coffeeshop.entity.Order;
import ee.coffee.coffeeshop.entity.OrderProduct;
import ee.coffee.coffeeshop.entity.User;
import ee.coffee.coffeeshop.enums.DeliveryMethod;
import ee.coffee.coffeeshop.enums.OrderStatus;
import ee.coffee.coffeeshop.enums.PaymentMethod;
import ee.coffee.coffeeshop.repositories.CartRepository;
import ee.coffee.coffeeshop.repositories.OrderRepository;
import ee.coffee.coffeeshop.repositories.UserRepository;
import ee.coffee.coffeeshop.services.interfaces.OrderService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final UserRepository userRepository;
    private final CartRepository cartRepository;

    @Transactional
    @Override
    public void saveOrder(PaymentMethod paymentType, DeliveryMethod deliveryType, User user) {
        Order order = new Order();   // создание заказа
//        order.setPayment_type(String.valueOf(paymentType));  // передача типа оплаты в заказ
//        order.setDelivery_type(String.valueOf(deliveryType));    // передача типа доставки заказа
//        order.setStatus(String.valueOf(OrderStatus.ACTIVE));    // автоматически присваевается статус

        order.setUser(user);  // устанавка клиента для этого заказа
        fillOrder(order);   // добавляется список товаров в заказе
        orderRepository.save(order);    // сохранение заказа в базу со всем списком товаров
        cartRepository.deleteByUserId(user);  // очищение таблицы
    }

    @Transactional
    @Override
    public void fillOrder(Order order) {     // добавление списка товаров в заказ
        List<Cart> cartList = cartRepository.getListByUserId(order.getUser().getId());
        List<OrderProduct> orderProductList = new ArrayList<>();   // создаётся пустого списка товаров в заказе
        Integer totalQuantity = 0;  // создаётся переменную, сколько всего товаров в заказе

        for (Cart cart : cartList) {    // перебират все продукты в корзине поочереди
            OrderProduct orderProduct = new OrderProduct();     // для каждого продукта из корзины создаётся заказ

//            orderProduct.setProduct(cart.getProducts());    //добавляется продукт
//            orderProduct.setQuantity(cart.getQuantity());     //добавляется количество
//            orderProduct.setOrder(order);    // заполняется заказ

            orderProductList.add(orderProduct);   // добавляется новый товар в список  товаров в заказе

            totalQuantity += orderProduct.getQuantity();  // добавляется по одному количество продуктов
        }

//        order.setOrderProducts(orderProductList);    // сохраняется список товаров в заказе
//        order.setQuantity(totalQuantity);      // сохраняет общее количество товаров в заказе
    }

    @Transactional
    @Override
    public List<Order> getOrderList() {
        return orderRepository.findAll();
    }

    @Transactional
    @Override
    public Order getOrderById(Long id) {
        Optional<Order> optionalOrder = orderRepository.findById(id);
        return optionalOrder.orElse(null);
    }

    @Transactional
    @Override
    public void setOrderStatus(OrderStatus orderStatus, Long id) {
        Order orderById = getOrderById(id);
        if (orderById == null) {
            return;
        }
//        orderById.setStatus(String.valueOf(orderStatus));
        orderRepository.save(orderById);
    }
}



