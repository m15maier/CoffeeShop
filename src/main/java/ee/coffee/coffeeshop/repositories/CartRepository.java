package ee.coffee.coffeeshop.repositories;

import ee.coffee.coffeeshop.entity.Cart;
import ee.coffee.coffeeshop.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository     // доступ к данным
public interface CartRepository extends JpaRepository<Cart, Long> {

	Cart findByUser(User user);
}


