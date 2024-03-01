package ee.coffee.coffeeshop.repositories;

import ee.coffee.coffeeshop.entity.Cart;
import ee.coffee.coffeeshop.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {

	Cart findByUser(User user);
}


