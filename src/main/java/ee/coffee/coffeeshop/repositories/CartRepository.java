package ee.coffee.coffeeshop.repositories;

import ee.coffee.coffeeshop.models.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository<Cart, Integer> {

    Cart getById (Integer id);
    void deleteById(Integer id);

}

