package ee.coffee.coffeeshop.repositories;

import ee.coffee.coffeeshop.entity.CartProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository     // доступ к данным
public interface CartProductRepository extends JpaRepository<CartProduct, Long> {

}


