package ee.coffee.coffeeshop.services.interfaces;

import ee.coffee.coffeeshop.models.Delivery;
import ee.coffee.coffeeshop.models.User;

import java.util.Collection;
import java.util.List;

public interface DeliveryService {
    List<Delivery> findAllDelivery();

    Collection<Delivery> getAllByUser(User user);

    void save(Delivery delivery);

    void deleteById(Integer id);

    void update(Integer id, Delivery delivery);
}
