package ee.coffee.coffeeshop.repositories;

import ee.coffee.coffeeshop.models.Delivery;
import ee.coffee.coffeeshop.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface DeliveryRepository extends JpaRepository<Delivery, Integer> {

    Collection<Delivery> findAllByUser(User user);
}
